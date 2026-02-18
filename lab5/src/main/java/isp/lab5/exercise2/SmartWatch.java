package isp.lab5.exercise2;

public class SmartWatch implements Chargeable {
    private int batteryLevel;

    public SmartWatch(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public void charge(int durationInMinutes) {
        if (durationInMinutes < 0) {
            System.out.println("Invalid duration");
        }
        if (this.batteryLevel < 100) {
            this.batteryLevel = this.batteryLevel + durationInMinutes * 2;
        }
        if (this.batteryLevel > 100) {
            this.batteryLevel = 100;
        }
    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }
}
