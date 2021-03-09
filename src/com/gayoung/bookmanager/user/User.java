package com.gayoung.bookmanager.user;

public class User {

    private int index;
    private final String name;
    private final int age;
    private final char gender;

    public User(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getIndex() + "\t\t" + getName() + "\t\t" + getAge() + "\t\t" + getGender();
    }
}
