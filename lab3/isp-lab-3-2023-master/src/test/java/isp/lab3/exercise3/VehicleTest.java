package isp.lab3.exercise3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VehicleTest {
    @Test
    public void toStringTest() {
        Vehicle vehicle = new Vehicle("Dacia", "Logan", 400, 'B');
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setModel("Dacia");
        vehicle2.setType("Logan");
        vehicle2.setSpeed(300);
        vehicle2.setFuelType('D');
        assertEquals("Vehicle{" +
                "model='" + "Dacia" + '\'' +
                ", type='" + "Logan" + '\'' +
                ", speed=" + 400 +
                ", fuelType=" + 'B' +
                '}', vehicle.toString());
        assertEquals("Vehicle{" +
                "model='" + "Dacia" + '\'' +
                ", type='" + "Logan" + '\'' +
                ", speed=" + 300 +
                ", fuelType=" + 'D' +
                '}', vehicle2.toString());
    }
};;
