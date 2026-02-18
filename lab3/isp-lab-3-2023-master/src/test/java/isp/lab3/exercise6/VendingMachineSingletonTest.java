package isp.lab3.exercise6;

import isp.lab3.exercise6.VendingMachineSingleton;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineSingletonTest {


    @Test
    public void getInstanceTest() {
        VendingMachineSingleton instance1 = VendingMachineSingleton.getInstance();
        assertNotNull(instance1);
        VendingMachineSingleton instance2 = VendingMachineSingleton.getInstance();
        assertSame(instance1, instance2);
        String[] products = {"Cola", "Chips"};
        int[] prices = {5, 10};
        VendingMachineSingleton instance3 = VendingMachineSingleton.getInstance(products, prices);
        assertSame(instance1, instance3);
    }

}

