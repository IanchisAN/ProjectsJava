package isp.lab6.exercise3;

import java.util.HashSet;
import java.util.Set;

public class LoginSystem {
    private OnlineStore onlineStore;
    private Set<User> users;

    public LoginSystem(OnlineStore onlineStore) {
        this.onlineStore = onlineStore;
        this.users = new HashSet<>();
    }

    public void register(String username, String password) {
        User user1 = new User(username, password);
        users.add(user1);
    }
    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("You are logged in");
                onlineStore.addSession(username);
                return true;
            }
        }
        System.out.println("You are not logged in");
        return false;
    }
    public boolean logout(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("You have logged out");
                onlineStore.removeSession(username);
                return true;
            }
        }
        System.out.println("You have not logged out");
        return false;
    }


}