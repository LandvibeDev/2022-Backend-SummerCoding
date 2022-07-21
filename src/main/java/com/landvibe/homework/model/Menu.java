package com.landvibe.homework.model;

public class Menu {
    private int number;
    private String name;
    private int price;

    public Menu(int number, String name, int price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}