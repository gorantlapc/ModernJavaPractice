
package org.pc.collections;

import java.util.ArrayList;
import java.util.List;

record Order(int orderId, List<String> product, int quantity) {
}

/* Demonstrates the use of flatMap to flatten nested collections
 * Here, we have a list of orders, each containing a list of products.
 * We use flatMap to create a single stream of products from all orders.
 */
public class StreamFlatMapEx {
    public static void main(String[] args) {
        // Implementation can be added here in the future
        List<Order> orders = List.of(
                new Order(1, List.of("Laptop", "Mouse"), 2),
                new Order(2, List.of("Keyboard", "Monitor"), 1)
        );

        var products = orders.stream()
                .flatMap(order -> order.product().stream())
                .toList(); // returns unmodifiable list of products

        // traditional way to do the same
        var productsTraditional = new ArrayList<String>();
        for (Order order : orders) {
            for (String product : order.product()) {
                productsTraditional.add(product);
            }
        }

        //
        var products2 = new ArrayList<String>();
        orders.forEach(order -> products2.addAll(order.product()));

        products2.forEach(System.out::println);
    }
}
