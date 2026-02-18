package edu.tucn.aut.isp.lab4.exercise4;

import java.time.LocalTime;

public class Exercise4 {
    public static void main(String[] args) {

        FishFeeder feeder = new FishFeeder("Eheim", "AutoFeeder", 3);
        AquariumController aquariumController = new AquariumController("Neptune Systems", "Apex Controller", feeder);
        aquariumController.setFeedingTime(LocalTime.of(9, 0));
        aquariumController.setLightsOffTime(LocalTime.of(10, 0));
        aquariumController.setLightsOnTime(LocalTime.of(18, 0));
        aquariumController.setCurrentTime(LocalTime.of(9, 0));
        aquariumController.setCurrentTime(LocalTime.of(10, 0));
        aquariumController.setCurrentTime(LocalTime.of(18, 0));
        System.out.println(aquariumController);

    }
}
