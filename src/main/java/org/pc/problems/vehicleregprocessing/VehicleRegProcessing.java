package org.pc.problems.vehicleregprocessing;

import java.util.Comparator;
import java.util.List;

public class VehicleRegProcessing {
    static void main() {
        Vehicle car = new Car(2000, 400000.0);
        Vehicle truck = new Truck( 5000, 800000.0);
        Vehicle bike = new Bike(1500, 150000.0);

        VehicleRegProcessing processor = new VehicleRegProcessing();

        System.out.println("Tax for Car: " + processor.calculateTax(car));
        System.out.println("Tax for Truck: " + processor.calculateTax(truck));
        System.out.println("Tax for Bike: " + processor.calculateTax(bike));

        List<Vehicle> vehicles = List.of(car, truck, bike);
        double sum = vehicles.stream()
                .mapToDouble(processor::calculateTax) // method reference to calculateTax instance method
                .sum();
        System.out.println("Total Tax for all vehicles: " + sum);

// Find the most expensive vehicle
        Vehicle mostExpensiveVehicle = vehicles.stream()
                .max(Comparator.comparingDouble(VehicleRegProcessing::priceOf))// method reference to priceOf static method
                .orElseThrow(() -> new IllegalStateException("No vehicles available"));

        Vehicle leastExpensiveVehicle = vehicles.stream()
                .min(Comparator.comparingDouble(VehicleRegProcessing::priceOf))
                .orElseThrow(() -> new IllegalStateException("No vehicles available"));

//        want to find most expensive vehicle using traditopnal approach
        Vehicle mostExpensive = vehicles.getFirst();
        for (Vehicle v : vehicles) {
            if (priceOf(v) > priceOf(mostExpensive)) {
                mostExpensive = v;
            }
        }
        System.out.println("Most expensive vehicle (traditional): " + priceOf(mostExpensive));
        System.out.println("Most expensive vehicle (stream): " + priceOf(mostExpensiveVehicle));
        System.out.println("Least expensive vehicle (stream): " + priceOf(leastExpensiveVehicle));

        List<Integer> values = List.of(10, 20, 30, 40, 50);
        int maxValue = values.getFirst();
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

    public double calculateTax(Vehicle vehicle){
        return switch (vehicle){
            case Car car -> {
                double tax = 0.0;
                if (car.engineCapacity() <= 1500) {
                    tax = car.engineCapacity() * 0.03;
                } else if (car.engineCapacity() <= 2500) {
                    tax = car.engineCapacity() * 0.05;
                }
                yield tax;
            }
            case Truck truck-> truck.engineCapacity() * 0.1;
            case Bike bike -> bike.engineCapacity() * 0.03;
        };
    }
}
