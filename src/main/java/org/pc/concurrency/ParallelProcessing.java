package org.pc.concurrency;

import org.pc.util.dtos.Order;
import org.pc.util.dtos.Product;
import org.pc.util.dtos.User;
import org.pc.util.parser.JSONParser;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ParallelProcessing {
    private static JSONParser parser = new JSONParser();
    public static void main(String[] args) {

       // sequentialProcess();

        long startTime = System.currentTimeMillis();
        var userFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchUsers();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        var orderFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchOrders();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        var productFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchProducts();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<Void> allOf = CompletableFuture.allOf(userFuture, orderFuture, productFuture);
        allOf.join(); // Wait for all to complete
        try {
            List<User> users = userFuture.get();
            List<Order> orders = orderFuture.get();
            List<Product> products = productFuture.get();
            System.out.println("Users: " + users);
            System.out.println("Orders: " + orders);
            System.out.println("Products: " + products);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime) + " ms");

        }

    private static void sequentialProcess() {
        long sequentialStartTime = System.currentTimeMillis();
        try {
            List<User> users = fetchUsers();
            List<Order> orders = fetchOrders();
            List<Product> products = fetchProducts();
            System.out.println("Users: " + users);
            System.out.println("Orders: " + orders);
            System.out.println("Products: " + products);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long sequentialEndTime = System.currentTimeMillis();
        System.out.println("Total time taken (sequential): " + (sequentialEndTime - sequentialStartTime) + " ms");
    }

    private static List<Product> fetchProducts() throws IOException {
        return parser.readJson("products.json", Product.class);
    }

    private static List<Order> fetchOrders() throws IOException {
        return parser.readJson("orders.json", Order.class);
    }

    private static List<User> fetchUsers() throws IOException {
        return parser.readJson("users.json", User.class);
    }
}
