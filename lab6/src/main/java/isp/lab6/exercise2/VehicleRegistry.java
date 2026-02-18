package isp.lab6.exercise2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class VehicleRegistry {
    private Set<Vehicle> vehicles = new HashSet<>();

    public VehicleRegistry() {
        this.vehicles = new HashSet<Vehicle>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public void checkVehicle(Vehicle vehicle) {
        for (Vehicle v : vehicles) {
            if (v.equals(vehicle)) {
                System.out.println("Masina cu VIN-ul: " + vehicle.getVin() + " exista");
            } else {
                System.out.println("Masina cu VIN-ul: " + vehicle.getVin() + " nu exista");
            }
        }


    }

    public void displayVehicles() {
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    @Override
    public String toString() {
        return "VehicleRegistry{" +
                "vehicles=" + vehicles +
                '}';
    }
}
