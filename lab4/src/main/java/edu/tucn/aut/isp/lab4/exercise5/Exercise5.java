package edu.tucn.aut.isp.lab4.exercise5;

import java.time.LocalTime;

public class Exercise5 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("Eheim", "AutoFeeder", 4);
        AquariumController aquariumController = new AquariumController("Neptune Systems", "Apex Controller", feeder);
        Actuator actuator = new Actuator("EcoTech Marine", "VorTech MP40");
        LevelSensor levelSensor = new LevelSensor("Tunze", "Osmolator 3155");
        TemperatureSensor temperatureSensor = new TemperatureSensor("Inkbird", "ITC-306A");
        Alarm alarm = new Alarm("GHL", "Profilux Alarm");
        Heater heater = new Heater("Fluval", "E300");

        levelSensor.setValue(10);
        temperatureSensor.setValue(24.5F);
        aquariumController.setPresetTemperature(15);
        aquariumController.setPresetLevel(12);
        aquariumController.setLevelSensor(levelSensor);
        aquariumController.setTemperatureSensor(temperatureSensor);
        aquariumController.setAlarm(alarm);
        aquariumController.setHeater(heater);
        aquariumController.setFeedingTime(LocalTime.of(10, 20));
        aquariumController.setCurrentTime(LocalTime.of(10, 20));

        System.out.println(aquariumController);
        aquariumController.checkWaterLevel();
        aquariumController.checkTemperature();
    }
}
