package edu.tucn.aut.isp.lab4.exercise1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AquariumControllerTest {
    //implement minimal tests

    @Test
    void dummyTestNPE() {
        Assertions.assertThrows(
                NullPointerException.class, () -> {
                    Integer nullInt = null;
                    nullInt.toString();
                });
        AquariumController aquariumController = new AquariumController("lala","bala", LocalTime.of(10,20));
        aquariumController.toString();
        assertEquals("AquariumController{manufacturer='lala', model='bala', currentTime=10:20}", aquariumController.toString());
        aquariumController.setCurrentTime(LocalTime.of(15,59));
        assertEquals("AquariumController{manufacturer='lala', model='bala', currentTime=15:59}", aquariumController.toString());


    }
}
