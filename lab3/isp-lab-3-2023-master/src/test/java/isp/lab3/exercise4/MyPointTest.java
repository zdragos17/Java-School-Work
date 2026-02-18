package isp.lab3.exercise4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyPointTest {
    @Test
    public void testDistance() {
        MyPoint myPoint = new MyPoint();
        double distance = myPoint.distance(new MyPoint(2, 4, 6));
        assertEquals(Math.sqrt(56), distance, 1e-10);
        distance = myPoint.distance(new MyPoint());
        assertEquals(Math.sqrt(0), distance, 1e-10);

    }

}
