package edu.tucn.aut.isp.lab4.exercise5;

public class TemperatureSensor extends Sensor {
    float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public TemperatureSensor(String manufacturer, String model) {
        super(manufacturer, model);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
