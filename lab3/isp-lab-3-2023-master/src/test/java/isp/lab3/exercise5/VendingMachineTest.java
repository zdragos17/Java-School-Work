package isp.lab3.exercise5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    @Test
    public void displayProductsTest() {

        String[] products = {"A", "B", "C"};
        int[] prices = {12, 2, 3};
        VendingMachine vendingMachine = new VendingMachine(products, prices);

        String expectedOutput = "Available products:\n" +
                "ID: 1 | Product: A | Price: 12 coins\n" +
                "ID: 2 | Product: B | Price: 2 coins\n" +
                "ID: 3 | Product: C | Price: 3 coins\n";
        String actualOutput = vendingMachine.displayProducts();
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void insertCoinTest() {
        int value = 6;
        VendingMachine vm = new VendingMachine();
        assertEquals(6, vm.insertCoin(value));
        value = -2;
        assertEquals(6, vm.insertCoin(value));


    }

    @Test
    public void selectProductTest() {
        String[] products = {"A", "B", "C"};
        int[] prices = {1, 2, 3};
        VendingMachine vendingMachine = new VendingMachine(products, prices);
        vendingMachine.insertCoin(2);
        assertEquals(" Thanks for your order: A", vendingMachine.selectProduct(1));
        assertEquals("Insufficient coins!", vendingMachine.selectProduct(2));
        assertEquals("Invalid product", vendingMachine.selectProduct(0));

    }

}

