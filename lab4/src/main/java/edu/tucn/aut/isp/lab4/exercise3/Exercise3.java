package edu.tucn.aut.isp.lab4.exercise3;

import java.time.LocalTime;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("Eheim", "AutoFeeder", 3);
        AquariumController aquariumController = new AquariumController("Neptune Systems", "Apex Controller", fishFeeder);
        aquariumController.setFeedingTime(LocalTime.of(20, 0));
        aquariumController.setCurrentTime(LocalTime.of(20, 20));

        System.out.println(fishFeeder);

        aquariumController.setCurrentTime(LocalTime.of(20, 0));
        System.out.println(fishFeeder);

        fishFeeder.fillUp();
        System.out.println(fishFeeder);
    }
}
