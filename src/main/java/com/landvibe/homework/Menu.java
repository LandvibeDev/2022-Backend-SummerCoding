package com.landvibe.homework;

public class Menu {
    private String id;
    private String name;
    private int price;
    Menu(){}
    Menu(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    String getMenuId() {
        return id;
    }

    String getMenuName() {
        return name;
    }

    int getPrice() {
        return price;
    }
}
