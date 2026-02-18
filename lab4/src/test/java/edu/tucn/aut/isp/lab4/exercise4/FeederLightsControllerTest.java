package edu.tucn.aut.isp.lab4.exercise4;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class FeederLightsControllerTest {
    @Test
    public void feederLightsController() {
        FishFeeder feeder = new FishFeeder("alala", "BAA", 3);
        AquariumController aquariumController = new AquariumController("alal", "alala", feeder);
        aquariumController.setLightsOnTime(LocalTime.of(10, 20));
        aquariumController.setLightsOffTime(LocalTime.of(18, 20));
        aquariumController.setCurrentTime(LocalTime.of(10, 20));
        assertTrue(aquariumController.lightOn());
        aquariumController.setCurrentTime(LocalTime.of(18, 20));
        assertFalse(aquariumController.lightOn());

    }

}
