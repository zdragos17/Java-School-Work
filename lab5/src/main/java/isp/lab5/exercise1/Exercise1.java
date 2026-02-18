package isp.lab5.exercise1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Exercise1 {

    public static void main(String[] args) {
        Product product1 = new Product("12", ProductCategory.TOYS, 25.5F, "Woody");
        Product product2 = new Product("12243", ProductCategory.ELECTRONICS, 213.5F, "AppleWatch");
        Product product3 = new Product("1221", ProductCategory.FASHION, 112.5F, "Hoodie");

        System.out.println(product1);
        Order order1 = new Order("133", LocalDateTime.of(1987, 10, 25, 13, 45, 51));
        System.out.println(order1);
        order1.addProduct(product1);
        order1.addProduct(product2);
        order1.addProduct(product3);
        System.out.println(order1);
        Customer customer1= new Customer("21A","Dragos","071234");
        order1.setCustomer(customer1);
        System.out.println(order1);
        Address address=new Address("Principala 529","Botiza");
        customer1.setAddress(address);
        System.out.println(order1);

    }
}
