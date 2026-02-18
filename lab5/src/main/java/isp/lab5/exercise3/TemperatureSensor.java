package isp.lab5.exercise3;

public class TemperatureSensor extends Sensor {
    private double temperature;

    public TemperatureSensor(String installLocation, String name, double temperature) {
        super(installLocation, name);
        this.temperature = temperature;
    }
    public double getTemperature() {
        return temperature;
    }

    @Override
    public double getValue() {
        return temperature;
    }

    @Override
    public int whatSensor() {
        return 1;
    }

    @Override
    public String toString() {
        return "TemperatureSensor{" +
                "installLocation='" + getInstallLocation() + '\'' +
                ", name='" + getName() + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
