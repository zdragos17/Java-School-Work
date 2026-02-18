package isp.lab5.exercise1;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Order {
    private String orderId;
    private LocalDateTime date;
    private double totalPrice;
    private Customer customer;
    private Product[] products = new Product[10];
    private int quantity = 0;

    public Order(String orderId, LocalDateTime date) {
        this.orderId = orderId;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }


    public void addProduct(Product product) {
//        for (int i = 0; i < products.length; i++) {
//                products[i] = product;
//
//
//        }
        products[quantity++] = product;
        totalPrice += product.getPrice();

    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}
