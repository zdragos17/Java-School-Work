package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.Map;

public class ActiveSession {
    private String username;
    private Map<Product, Integer> shopingCart= new HashMap<>();
    public ActiveSession(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void addToCart(Product product, int quantity) {
        shopingCart.put(product, quantity);

    }

}
