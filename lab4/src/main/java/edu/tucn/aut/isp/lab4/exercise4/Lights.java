package edu.tucn.aut.isp.lab4.exercise4;

public class Lights {
    private boolean isOn;

    public Lights(boolean isOn) {
        this.isOn = isOn;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
        }

    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
        }
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Lights{" +
                "isOn=" + isOn +
                '}';
    }
}
