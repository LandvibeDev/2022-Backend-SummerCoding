package com.landvibe.homework;

public class Menu {

    private int orderNum;
    private int cost;
    private String name;

    Menu(int OrderNum,
         String name,
         int cost) {
        this.orderNum = OrderNum;
        this.cost = cost;
        this.name = name;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
