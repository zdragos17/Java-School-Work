package edu.tucn.aut.isp.lab4.exercise6;

import java.time.LocalTime;

public class AquariumController {

    //attributs
    private String manufacturer;
    private String model;
    private LocalTime currentTime;
    private FishFeeder feeder;
    private LocalTime feedingTime;
    private float presetTemperature;
    private int presetLevel;
    private LevelSensor levelSensor;
    private TemperatureSensor temperatureSensor;
    private Actuator heater;
    private Actuator alarm;
    private PHControl phControl;
    private float ph;


    //constructors

    public AquariumController(String manufacturer, String model, PHControl phControl) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.phControl = phControl;
    }

    public AquariumController() {

    }
    //methods


    public PHControl getPhControl() {
        return phControl;
    }

    public void setPhControl(PHControl phControl) {
        this.phControl = phControl;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        this.ph = ph;
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

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    public void setPresetTemperature(float presetTemperature) {
        this.presetTemperature = presetTemperature;
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

    public boolean checkPH() {
        if (this.phControl.phMonitor(this.ph)) {
            System.out.println("Nivelul de PH setat este in raza normala");
            return true;
        } else {
            alarm.turnOn();
            return false;
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
