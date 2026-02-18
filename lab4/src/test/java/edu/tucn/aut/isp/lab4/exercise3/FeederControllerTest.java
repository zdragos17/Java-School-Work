package edu.tucn.aut.isp.lab4.exercise3;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeederControllerTest {
    @Test
    public void feedTest() {
        FishFeeder f = new FishFeeder("ajaja", "lalal", 1);
        AquariumController a = new AquariumController("ajaja", "lalal", f);
        a.setFeedingTime(LocalTime.of(10, 0));
        a.setCurrentTime(LocalTime.of(9, 0));
        assertEquals(1, f.getMeals());
        a.setCurrentTime(LocalTime.of(10, 0));
        assertEquals(0, f.getMeals());
        f.fillUp();
        assertEquals(14, f.getMeals());

    }
}
