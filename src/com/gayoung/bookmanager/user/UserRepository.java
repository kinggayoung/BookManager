package com.gayoung.bookmanager.user;

import java.util.Collection;
import java.util.TreeMap;

public class UserRepository {
    // Singleton Pattern
    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {

    }

    // UserManager Function
    private final TreeMap<Integer, User> idByUser = new TreeMap<>();

    public void addUser(User user) {
        int index;
        if (idByUser.size() == 0) {
            index = 1;
        } else {
            index = idByUser.lastKey() + 1;
        }
        user.setIndex(index);
        idByUser.put(index, user);
    }

    public void updateUser(int index, User user) {
        user.setIndex(index);

        idByUser.put(index, user);
    }

    public void removeUser(int index) {
        idByUser.remove(index);
    }

    public User getUser(int index) {
        return idByUser.get(index);
    }

    public Collection<User> getUsers() {
        return idByUser.values();
    }

    public String getUserName(int index) {
        return idByUser.get(index).getName();
    }
}
