package org.pc.concurrency;

import org.pc.util.parser.JSONParser;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

record User(int id, String name) {}
record Order(int id, String item) {}
record Product(int id, String name) {}

public class ParallelProcessing {
    private static JSONParser parser = new JSONParser();
    static void main() {

        //sequentialProcess();

        long startTime = System.currentTimeMillis();

        CompletableFuture<List<User>> userFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchUsers();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<List<Order>> orderFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return fetchOrders();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<List<Product>> productFuture = CompletableFuture.supplyAsync(() -> {
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
        List<Product> products = parser.readJson("products.json", Product.class);
        return products;

    }

    private static List<Order> fetchOrders() throws IOException {
        List<Order> orders = parser.readJson("orders.json", Order.class);
        return orders;
    }

    private static List<User> fetchUsers() throws IOException {
        List<User> users = parser.readJson("users.json", User.class);
        return users;
    }
}
