package edu.tucn.aut.isp.lab4.exercise4;

import java.time.LocalTime;

public class AquariumController {

    //attributs
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private FishFeeder feeder;
    private LocalTime feedingTime;
    private LocalTime lightsOnTime;
    private LocalTime lightsOffTime;
    private Lights lights;


    //constructors

    public AquariumController(String manufacturer, String model, FishFeeder feeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.feeder = feeder;
        this.lights = new Lights(false);// intre lights si aquarium avem compozitie
    }

    public AquariumController() {

    }
    //methods


    public void setFeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;

    }

    public void setLightsOnTime(LocalTime lightsOnTime) {
        this.lightsOnTime = lightsOnTime;
    }

    public void setLightsOffTime(LocalTime lightsOffTime) {
        this.lightsOffTime = lightsOffTime;
    }

    public void setCurrentTime(LocalTime currentTime) {

        this.currentTime = currentTime;
        if (this.currentTime.equals(this.feedingTime)) {
            this.feeder.feed();
            System.out.println("Pestele a primit mancare pt ca a fost ora de feedare");
        }

        if (this.currentTime.equals(this.lightsOnTime)) {
            System.out.println("Lumina a pornit");
            this.lights.turnOn();

        } else if (this.currentTime.equals(this.lightsOffTime)) {
            System.out.println("Lumina a fost oprita");
            this.lights.turnOff();

        }
    }

    public boolean lightOn() {
        return this.lights.isOn();
    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feeder=" + feeder +
                ", feedingTime=" + feedingTime +
                ", lightsOnTime=" + lightsOnTime +
                ", lightsOffTime=" + lightsOffTime +
                ", lights=" + lights +
                '}';
    }
}
