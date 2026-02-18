package edu.tucn.aut.isp.lab4.exercise6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhTest {
    @Test
    void phTest() {
        PHControl phControl = new PHControl("Alala", "bala");
        AquariumController aquariumController = new AquariumController("Neptune Systems", "Apex Controller", phControl);
        FishFeeder feeder = new FishFeeder("Eheim", "AutoFeeder", 4);
        Actuator actuator = new Actuator("EcoTech Marine", "VorTech MP40");
        LevelSensor levelSensor = new LevelSensor("Tunze", "Osmolator 3155");
        TemperatureSensor temperatureSensor = new TemperatureSensor("Inkbird", "ITC-306A");
        Alarm alarm = new Alarm("GHL", "Profilux Alarm");
        Heater heater = new Heater("Fluval", "E300");
        aquariumController.setAlarm(alarm);

        assertTrue(phControl.phMonitor(7.0F));
        assertFalse(phControl.phMonitor(1.0F));
        assertTrue(phControl.phMonitor(8F));
        aquariumController.setPh(3.0F);
        assertFalse(aquariumController.checkPH());
        aquariumController.setPh(7.0F);
        assertTrue(aquariumController.checkPH());
    }
}
