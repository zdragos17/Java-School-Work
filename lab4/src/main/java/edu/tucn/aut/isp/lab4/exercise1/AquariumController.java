package edu.tucn.aut.isp.lab4.exercise1;

import java.time.LocalTime;


public class AquariumController {

    //attributs
    private String manufacturer;
    private String model;
    private LocalTime currentTime;

    //constructors

    public AquariumController(String manufacturer, String model, LocalTime currentTime) {
        this.manufacturer = manufacturer;
        this.currentTime = currentTime;
        this.model = model;
    }

    public AquariumController() {

    }
    //methods


    public void setCurrentTime(LocalTime currentTime) {

        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "AquariumController{" + "manufacturer='" + manufacturer + '\'' + ", model='" + model + '\'' + ", currentTime=" + currentTime + '}';
    }
}







