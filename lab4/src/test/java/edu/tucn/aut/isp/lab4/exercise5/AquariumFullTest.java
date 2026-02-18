package edu.tucn.aut.isp.lab4.exercise5;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class AquariumFullTest {
    @Test
    void testAquariumFunctions() {
        FishFeeder feeder = new FishFeeder("Eheim", "AutoFeeder", 4);
        AquariumController aquariumController = new AquariumController("Neptune Systems", "Apex Controller", feeder);
        Actuator actuator = new Actuator("EcoTech Marine", "VorTech MP40");
        LevelSensor levelSensor = new LevelSensor("Tunze", "Osmolator 3155");
        TemperatureSensor temperatureSensor = new TemperatureSensor("Inkbird", "ITC-306A");
        Alarm alarm = new Alarm("GHL", "Profilux Alarm");
        Heater heater = new Heater("Fluval", "E300");
        aquariumController.setLevelSensor(levelSensor);
        aquariumController.setTemperatureSensor(temperatureSensor);
        aquariumController.setAlarm(alarm);
        aquariumController.setHeater(heater);

// acest test nu merge , nu am reusit sa il rezolv complet la timp
        aquariumController.setFeedingTime(LocalTime.of(10, 20));
        aquariumController.setCurrentTime(LocalTime.of(10, 20));
        assertEquals(LocalTime.of(10, 20), aquariumController.getFeedingTime());

        temperatureSensor.setValue(24.5F);
        aquariumController.setPresetTemperature(15.0F);
        aquariumController.checkTemperature();
        assertTrue(heater.isOn());


        temperatureSensor.setValue(15.0F);
        aquariumController.setPresetTemperature(15.0F);
        aquariumController.checkTemperature();
        assertFalse(heater.isOn());


        levelSensor.setValue(10);
        aquariumController.setPresetLevel(12);
        aquariumController.checkWaterLevel();
        assertTrue(alarm.isOn());
        levelSensor.setValue(12);
        aquariumController.setPresetLevel(12);
        aquariumController.checkWaterLevel();
        assertFalse(alarm.isOn());
    }
}



