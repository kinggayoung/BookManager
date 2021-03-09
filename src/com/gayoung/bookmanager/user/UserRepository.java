package com.gayoung.bookmanager.user;

import java.util.Collection;
import java.util.TreeMap;

public class UserRepository {

    private static UserRepository instance;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {

    }

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

    public void updateUser(User user) {
        idByUser.put(user.getIndex(), user);
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

}
