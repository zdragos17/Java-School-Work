package isp.lab3.exercise5;

public class Exercise5 {
    public static void main(String[] args) {
        String[] products = {"fanta", "pepsi", "foietaj cu mere"};
        int[] prices = {12, 2, 3};
        VendingMachine vendingMachine = new VendingMachine(products, prices);
        vendingMachine.UserMenu();
    }
}
