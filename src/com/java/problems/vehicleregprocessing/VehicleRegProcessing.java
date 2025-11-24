package com.java.problems.vehicleregprocessing;

import java.util.List;

public class VehicleRegProcessing {
    static void main() {
        Vehicle car = new Car(2000, 400000.0);
        Vehicle truck = new Truck( 5000, 800000.0);
        Vehicle bike = new Bike(1500, 150000.0);

        System.out.println("Tax for Car: " + calculateTax(car));
        System.out.println("Tax for Truck: " + calculateTax(truck));
        System.out.println("Tax for Bike: " + calculateTax(bike));

        List<Vehicle> vehicles = List.of(car, truck, bike);
        double sum = vehicles.stream()
                .mapToDouble(v -> calculateTax(v))
                .sum();
        System.out.println("Total Tax for all vehicles: " + sum);

// Find the most expensive vehicle
        Vehicle mostExpensiveVehicle = vehicles.stream()
                .max((v1, v2) ->
                    Double.compare(priceOf(v1), priceOf(v2)))
                .orElseThrow(() -> new IllegalStateException("No vehicles available"));

        Vehicle leastExpensiveVehicle = vehicles.stream()
                .min((v1, v2) ->
                        Double.compare(priceOf(v1), priceOf(v2)))
                .orElseThrow(() -> new IllegalStateException("No vehicles available"));

//        want to find most expensive vehicle using traditopnal approach
        Vehicle mostExpensive = vehicles.get(0);
        for (Vehicle v : vehicles) {
            if (priceOf(v) > priceOf(mostExpensive)) {
                mostExpensive = v;
            }
        }
        System.out.println("Most expensive vehicle (traditional): " + priceOf(mostExpensive));
        System.out.println("Most expensive vehicle (stream): " + priceOf(mostExpensiveVehicle));

        List<Integer> values = List.of(10, 20, 30, 40, 50);
        int maxValue = values.get(0);
        for (int val : values) {
            if (val > maxValue) {
                maxValue = val;
            }
        }
    }

    private static double priceOf(Vehicle v1) {
        return switch (v1) {
            case Car c -> c.price();
            case Truck t -> t.price();
            case Bike b -> b.price();
        };
    }

    public static double calculateTax(Vehicle vehicle){
        double tax = 0.0;
        return switch (vehicle){
            case Car car -> tax = car.engineCapacity() * 0.05;
            case Truck truck-> tax = truck.engineCapacity() * 0.1;
            case Bike bike -> tax = bike.engineCapacity() * 0.03;
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + vehicle);
        };
    }
}
