package com.gayoung.bookmanager.user;

public class User {


    private int index;
    private final String name;
    private final int age;


    public User(String name, int age) {
        this.name = name;
        this.age = age;

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


    @Override
    public String toString() {
        return getIndex() + "\t\t" +
                getName() + "\t\t" +
                getAge() + "\t\t" ;
    }


}

