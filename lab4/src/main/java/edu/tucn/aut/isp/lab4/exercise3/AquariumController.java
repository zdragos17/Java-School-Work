package edu.tucn.aut.isp.lab4.exercise3;

import java.time.LocalTime;

public class AquariumController {

    //attributs
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private FishFeeder feeder;
    private LocalTime feedingTime;


    //constructors

    public AquariumController(String manufacturer, String model, FishFeeder feeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.feeder = feeder;
    }

    public AquariumController() {

    }
    //methods


    public void setFeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;
    }


    public void setCurrentTime(LocalTime currentTime) {

        this.currentTime = currentTime;
        if (this.currentTime == this.feedingTime) {
            this.feeder.feed();
            System.out.println("Pestele a primit mancare pt ca a fost ora de feedare");
        } else System.out.println("Nu este ora de feedare");
    }


    @Override
    public String toString() {
        return "AquariumController" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feeder=" + feeder +
                ", feedingTime=" + feedingTime;
    }
}
