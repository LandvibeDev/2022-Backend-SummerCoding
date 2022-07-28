package com.landvibe.homework;

import java.util.ArrayList;
import java.util.Vector;

public class Customer {
    private String name;
    private int balance;
    ArrayList<Integer> orderList = new ArrayList<Integer>();

    void setOrderList(int id) {
        orderList.add(id);
    }

    ArrayList getOrderList() {
        return orderList;
    }

    Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    String getName() {
        return name;
    }

    int getBalance() {
        return balance;
    }

    boolean checkBalance(int price) {
        return balance >= price;
    }

    void expenditure(int price) {
        balance -= price;
    }
}
