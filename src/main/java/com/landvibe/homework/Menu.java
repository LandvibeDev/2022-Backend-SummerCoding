package com.landvibe.homework;

public class Menu {

    private int OrderNum;
    private int cost;
    private String name;

    Menu(int OrderNum,
         String name,
         int cost) {
        this.OrderNum = OrderNum;
        this.cost = cost;
        this.name = name;
    }

    public int getOrderNum() {
        return OrderNum;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
