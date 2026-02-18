package isp.lab6.exercise2;

import java.util.Objects;

public class Vehicle {

    private String make;
    private String model;
    private int year;
    private String licensePlate;
    private String vin;

    public String getVin() {
        return vin;
    }

    public Vehicle(String licensePlate, int year, String model, String vin, String make) {
        this.licensePlate = licensePlate;
        this.year = year;
        this.model = model;
        this.make = make;
        this.vin = vin;
    }

    public Vehicle(String vin) {
        this.vin = vin;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vin, vehicle.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vin);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", licensePlate='" + licensePlate + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}

