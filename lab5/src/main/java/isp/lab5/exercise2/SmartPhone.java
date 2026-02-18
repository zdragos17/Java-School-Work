package isp.lab5.exercise2;

public class SmartPhone implements Chargeable {
    private int batteryLevel;

    public SmartPhone(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public void charge(int durationInMinutes) {
        if(durationInMinutes < 0) {
            System.out.println("Invalid duration");
        }
        if (this.batteryLevel < 100) {
            this.batteryLevel = this.batteryLevel + durationInMinutes * 3 / 2;
        }
        if (this.batteryLevel > 100) {
            this.batteryLevel = 100;
        }
    }


    public int getBatteryLevel() {
        return this.batteryLevel;
    }
}
