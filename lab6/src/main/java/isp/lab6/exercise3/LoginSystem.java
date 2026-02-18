package isp.lab6.exercise3;

import java.util.HashSet;
import java.util.Set;

public class LoginSystem {
    private Set<User> users = new HashSet<User>();
    private String store;
    private User user;

    public LoginSystem(String store) {
        this.store = store;
    }

    public void register(String username, String password) {
        if (username == null || password == null) {
            users.add(new User(username, password));

        }
    }

    public boolean login(String username, String password) {
        if (username == user.getUsername() && password == user.getPassword()) {
            return true;
        } else return false;
    }

    public boolean logut(String username) {
        if (username == user.getUsername()) {
            return true;
        } else return false;
    }


}
