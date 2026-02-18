package isp.lab5.exercise3;

import java.util.Arrays;

public class MonitoringService {
    private double averageTemperature;
    private double averagePressure;
    private double averageAll;
    private Sensor[] sensors = new Sensor[10];
    private int counter = 0;


    public void addSensor(Sensor sensor) {
        sensors[counter++] = sensor;

    }


    public double getAverageTemperature() {
        int count = 0;
        double temp = 0;
        for (int i = 0; i < counter; i++) {
            if (sensors[i].whatSensor() == 1) {
                count++;
                temp = sensors[i].getValue() + temp;
            }
        }
        this.averageTemperature = temp / count;
        return averageTemperature;
    }

    public double getAveragePressure() {
        int count = 0;
        double press = 0;
        for (int i = 0; i < counter; i++) {
            if (sensors[i].whatSensor() == 2) {
                count++;
                press = sensors[i].getValue() + press;
            }
        }
        this.averagePressure = press / count;
        return averagePressure;
    }

    public double getAverageAll() {
        int count = 0;
        double all = 0;
        for (int i = 0; i < counter; i++) {
            count++;
            all = all + sensors[i].getValue();
        }
        this.averageAll = all / count;
        return averageAll;

    }

    @Override
    public String toString() {
        return "MonitoringService{" +
                ", sensors=" + Arrays.toString(sensors) +
                ", counter=" + counter +
                '}';
    }
}
