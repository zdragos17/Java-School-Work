package isp.lab5.exercise2;

public class Laptop implements Chargeable {
    private int batteryLevel;

    public Laptop(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public void charge(int durationInMinutes) {
        if (durationInMinutes < 0) {
            System.out.println("Invalid duration");
        }
        if (this.batteryLevel < 100) {
            this.batteryLevel = this.batteryLevel + durationInMinutes;

        }
        if (this.batteryLevel > 100) {
            this.batteryLevel = 100;
        }
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }
}
