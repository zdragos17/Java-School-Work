package isp.lab5.exercise3;

public abstract class Sensor {
    private String installLocation;
    private String name;

    public Sensor(String installLocation, String name) {
        this.installLocation = installLocation;
        this.name = name;
    }
    public abstract double getValue();

    public abstract int whatSensor();

    public String getInstallLocation() {
        return installLocation;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "installLocation='" + installLocation + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
