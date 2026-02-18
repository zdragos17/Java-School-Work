package isp.lab5.exercise2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Exercise2Test {
    @Test
    public void chargeTest(){
        Laptop laptop=new Laptop(20);
        SmartPhone smartPhone=new SmartPhone(20);
        SmartWatch smartWatch=new SmartWatch(20);
        laptop.charge(20);
        smartPhone.charge(20);
        smartWatch.charge(20);
        assertEquals(40,laptop.getBatteryLevel());
        assertEquals(50,smartPhone.getBatteryLevel());
        assertEquals(60,smartWatch.getBatteryLevel());
        laptop.charge(500);
        assertEquals(100,laptop.getBatteryLevel());
    }
}
