package edu.tucn.aut.isp.lab4.exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FishFeederTest {
    @Test
    public void feedTest() {
        FishFeeder f = new FishFeeder("ajaja", "lalal", 1);
        f.feed();
        assertEquals(0, f.getMeals());

    }

    @Test
    public void fillUpTest() {
        FishFeeder f = new FishFeeder("ajaja", "lalal", 1);
        f.fillUp();
        assertEquals(14, f.getMeals());

    }
}
