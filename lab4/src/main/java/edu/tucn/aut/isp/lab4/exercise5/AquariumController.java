package edu.tucn.aut.isp.lab4.exercise5;


import java.time.LocalTime;

public class AquariumController {

    //attributs
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private FishFeeder feeder;
    private LocalTime feedingTime;
    private int presetTemperature;
    private float presetLevel;
    private LevelSensor levelSensor;
    private TemperatureSensor temperatureSensor;
    private Actuator heater;
    private Actuator alarm;


    //constructors

    public AquariumController(String manufacturer, String model, FishFeeder feeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.feeder = feeder;
    }

    public AquariumController() {

    }
    //methods


    public LocalTime getFeedingTime() {
        return feedingTime;
    }

    public void setLevelSensor(LevelSensor levelSensor) {
        this.levelSensor = levelSensor;
    }

    public void setTemperatureSensor(TemperatureSensor temperatureSensor) {
        this.temperatureSensor = temperatureSensor;
    }

    public void setHeater(Actuator heater) {
        this.heater = heater;
    }

    public void setAlarm(Actuator alarm) {
        this.alarm = alarm;
    }

    public void setPresetTemperature(float presetTemperature) {
        this.presetTemperature = (int) presetTemperature;
    }

    public void setPresetLevel(int presetLevel) {
        this.presetLevel = presetLevel;
    }

    public void setFeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;
    }


    public void setCurrentTime(LocalTime currentTime) {

        this.currentTime = currentTime;
        if (this.currentTime == this.feedingTime) {
            this.feeder.feed();
            System.out.println("Pestele a primit mancare pt ca a fost ora de feedare");
        }

    }

    public void checkTemperature() {
        if (this.presetTemperature > this.temperatureSensor.getValue()) {
            heater.turnOn();
        } else if (this.presetTemperature == this.temperatureSensor.getValue()) {
            heater.turnOff();
        }

    }


    public void checkWaterLevel() {
        if (this.presetLevel > this.levelSensor.getValue()) {
            alarm.turnOn();
        } else if (this.presetLevel == this.levelSensor.getValue()) {
            alarm.turnOff();
        }

    }

    @Override
    public String toString() {
        return "AquariumController{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", currentTime=" + currentTime +
                ", feeder=" + feeder +
                ", feedingTime=" + feedingTime +
                ", presetTemperature=" + presetTemperature +
                ", presetLevel=" + presetLevel +
                '}';
    }
}
