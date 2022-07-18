package com.landvibe.homework.model;

import java.util.ArrayList;

public class Customer {
    String name;
    int balance;
    ArrayList<History> orderHistory;

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.orderHistory = new ArrayList<>();
    }

    public ArrayList<History> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(History history) {
        this.orderHistory.add(history);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}