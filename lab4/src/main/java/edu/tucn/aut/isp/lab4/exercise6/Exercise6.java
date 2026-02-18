package edu.tucn.aut.isp.lab4.exercise6;


public class Exercise6 {
    public static void main(String[] args) {
        PHControl phControl = new PHControl("Alala", "bala");
        AquariumController aquariumController = new AquariumController("Neptune Systems", "Apex Controller", phControl);
        FishFeeder feeder = new FishFeeder("Eheim", "AutoFeeder", 4);
        Actuator actuator = new Actuator("EcoTech Marine", "VorTech MP40");
        LevelSensor levelSensor = new LevelSensor("Tunze", "Osmolator 3155");
        TemperatureSensor temperatureSensor = new TemperatureSensor("Inkbird", "ITC-306A");
        Alarm alarm = new Alarm("GHL", "Profilux Alarm");
        Heater heater = new Heater("Fluval", "E300");
        aquariumController.setAlarm(alarm);

        aquariumController.setPh(3.0F);
        aquariumController.checkPH();
        aquariumController.setPh(7.0F);
        aquariumController.checkPH();

    }
}
