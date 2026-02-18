package isp.lab3.exercise3;

import java.util.Objects;

public class Vehicle {
    private static int vehicleCount = 0;
    private String model;
    private String type;
    private int speed;
    private char fuelType;

    public Vehicle() {
        vehicleCount++;
    }


    public Vehicle(String model, String type, int speed, char fuelType) {
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.fuelType = fuelType;
        vehicleCount++;
    }

    public static int getVehicleCount() {
        System.out.println("Vehicle Count: " + vehicleCount);
        return vehicleCount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return speed == vehicle.speed && fuelType == vehicle.fuelType && Objects.equals(model, vehicle.model) && Objects.equals(type, vehicle.type);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getFuelType() {
        return fuelType;
    }

    public void setFuelType(char fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", speed=" + speed +
                ", fuelType=" + fuelType +
                '}';
    }

}
