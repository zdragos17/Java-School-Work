package isp.lab3.exercise6;

public class Exercise6 {
    public static void main(String[] args) {
        String[] products = {"fanta", "pepsi", "foietaj cu mere"};
        int[] prices = {12, 2, 3};
        VendingMachineSingleton vendingMachineSingleton = VendingMachineSingleton.getInstance(products, prices);
        vendingMachineSingleton.UserMenu();
    }
}
