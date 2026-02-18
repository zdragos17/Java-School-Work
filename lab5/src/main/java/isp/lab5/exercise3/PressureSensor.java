package isp.lab5.exercise3;

public class PressureSensor extends Sensor {
    private double pressure;

    public PressureSensor(String installLocation, String name, double pressure) {
        super(installLocation, name);
        this.pressure = pressure;
    }
    public double getPressure() {
        return pressure;
    }

    @Override
    public double getValue() {
        return pressure;
    }

    @Override
    public int whatSensor() {
        return 2;
    }

    @Override
    public String toString() {
        return "PressureSensor{" +
                "installLocation='" + getInstallLocation() + '\'' +
                ", name='" + getName() + '\'' +
                ", pressure=" + pressure +
                '}';
    }
}
