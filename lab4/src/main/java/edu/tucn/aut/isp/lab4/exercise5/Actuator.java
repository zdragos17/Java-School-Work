package edu.tucn.aut.isp.lab4.exercise5;

public class Actuator {
    private String manufacturer;
    private String model;
    private boolean on;

    public Actuator(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void turnOn() {
        this.on = true;

    }

    public boolean isOn() {
        return on;
    }

    public void turnOff() {
        this.on = false;
    }

    @Override
    public String toString() {
        return "Actuator{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", on=" + on +
                '}';
    }
}
