package org.pc.oops;

enum VehicleType {
    BUS,
    VAN,
    LORRY
}

interface Vehicle {
    void start();
    void stop();

    default void fuelType() {
        System.out.println("Fuel type is Diesel");
    }
}

abstract class VehicleBase implements Vehicle {
    private String vehicleNumber;
    private int capacity;

     VehicleBase(String vehicleNumber, int capacity) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        // Common initialization for all vehicles can be done here
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public int getCapacity() {
        return capacity;
    }
}

class VehicleFactory {
    public static Vehicle getVehicle(VehicleType type) {
        return switch (type){
            case BUS ->  new Bus("BUS123", 50);
            case LORRY ->  new Lorry("LORRY456", 100);
            case VAN ->  new Van("VAN789", 20);
        };
    }
}

class Bus extends VehicleBase {

    Bus(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity);
    }

    @Override
    public void start() {
        System.out.println(getVehicleNumber() + " with capacity " + getCapacity());
        System.out.println("Bus started");
    }

    @Override
    public void stop() {
        System.out.println("Bus stopped");
    }

    public void fuelType() {
        System.out.println("Fuel type is Petrol");
    }
}

class Van extends VehicleBase {
    Van(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity);
    }

    @Override
    public void start() {
        System.out.println(getVehicleNumber() + " with capacity " + getCapacity());
        System.out.println("Van started");
    }

    @Override
    public void stop() {
        System.out.println("Van stopped");
    }
}

class Lorry extends VehicleBase {

    Lorry(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity);
    }

    @Override
    public void start() {
        System.out.println(getVehicleNumber() + " with capacity " + getCapacity());
        System.out.println("Lorry started");
    }

    @Override
    public void stop() {
        System.out.println("Lorry stopped");
    }
}


public class AbstractionEx {
    static void main() {
        Vehicle bus = VehicleFactory.getVehicle(VehicleType.BUS);
        bus.start();
        bus.fuelType();
        bus.stop();

        Vehicle van = VehicleFactory.getVehicle(VehicleType.VAN);
        van.start();
        van.fuelType();
        van.stop();
    }
}
