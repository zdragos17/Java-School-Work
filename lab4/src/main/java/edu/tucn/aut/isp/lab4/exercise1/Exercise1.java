package edu.tucn.aut.isp.lab4.exercise1;

import java.time.LocalTime;

public class Exercise1 {

    public static void main(String[] args) {
        int[] time = {12, 20, 43};
        AquariumController aquariumController = new AquariumController("Neptune Systems", "Apex Controller", LocalTime.now());
        aquariumController.toString();
        System.out.println(aquariumController);
        aquariumController.setCurrentTime(LocalTime.of(10, 20));
        System.out.println(aquariumController);
    }
}
