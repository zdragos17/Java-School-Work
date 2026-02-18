package isp.lab3.exercise5;

import java.util.Arrays;
import java.util.Scanner;

public class VendingMachine {
    private int currentCredit;
    private String[] products;
    private int[] productPrices;

    public VendingMachine(String[] products, int[] productPrices) {
        this.currentCredit = 0;
        this.products = products;
        this.productPrices = productPrices;
    }

    public VendingMachine() {
        this.currentCredit = 0;
    }

    public String displayProducts() {
        String result = "Available products:\n";
        for (int i = 0; i < products.length; i++) {
            result += "ID: " + (i + 1) +
                    " | Product: " + products[i] +
                    " | Price: " + productPrices[i] + " coins\n";
        }
        System.out.println(result);
        return result;
    }


    public int insertCoin(int value) {
        if (value > 0) {
            this.currentCredit += value;
        } else System.out.println("Invalid value");
        return this.currentCredit;
    }

    public void displayCredit() {
        System.out.println("Current credit: " + this.currentCredit);
    }

    public String selectProduct(int id) {
        if (id < 1 || id > products.length) {
            return "Invalid product";
        }
        int index = id - 1;
        if (this.productPrices[index] <= this.currentCredit) {
            this.currentCredit -= this.productPrices[index];
            return " Thanks for your order: " + this.products[index];
        } else return "Insufficient coins!";


    }

    public void UserMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the VendingMachine");
        while (true) {
            System.out.println("\n Vending Machine Menu: ");
            System.out.println("1. Display products");
            System.out.println("2. Insert coin");
            System.out.println("3. Select product");
            System.out.println("4. Display credit");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    System.out.println("Enter coin value: ");
                    insertCoin(sc.nextInt());
                    break;
                case 3:
                    System.out.println("Enter product id: ");
                    System.out.println(selectProduct(sc.nextInt()));
                    break;
                case 4:
                    displayCredit();
                    break;
                case 5:
                    System.out.println("Thank you for using our vending machine! Bye!");
                    return;
                default:
                    System.out.println("Invalid choice, try again!");

            }
        }
    }


}
