package edu.tucn.aut.isp.lab4.exercise6;

public class PHControl {
    private String manufacturer;
    private String model;

    public PHControl(String model, String manufacturer) {
        this.model = model;
        this.manufacturer = manufacturer;
    }

    public boolean phMonitor(float ph) {
        if (ph >= 6.5 && ph <= 8) {
            return true;
        } else {
            return false;
        }
    }
}
