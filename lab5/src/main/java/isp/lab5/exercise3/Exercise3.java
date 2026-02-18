package isp.lab5.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        Sensor sensor1 = new TemperatureSensor("Bucatarie", "senzor1", 20);
        Sensor sensor2 = new TemperatureSensor("Dormitor", "senzor2", 30);
        Sensor sensor3 = new TemperatureSensor("Baie", "senzor3", 40);
        Sensor sensor4 = new PressureSensor("Baie", "senzor4", 20);
        Sensor sensor5 = new PressureSensor("Dormitor", "senzor5", 30);
        Sensor sensor6 = new PressureSensor("Bucatarie", "senzor6", 40);
        System.out.println(sensor1);
        System.out.println(sensor4);
        MonitoringService monitoringService = new MonitoringService();
        monitoringService.addSensor(sensor1);
        monitoringService.addSensor(sensor2);
        monitoringService.addSensor(sensor3);
        monitoringService.addSensor(sensor4);
        monitoringService.addSensor(sensor5);
        monitoringService.addSensor(sensor6);
        System.out.println(monitoringService);
        System.out.println(monitoringService.getAverageTemperature());
        System.out.println(monitoringService.getAveragePressure());
        System.out.println(monitoringService.getAverageAll());


    }
}
