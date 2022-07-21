package com.landvibe.homework.model;

import java.util.List;
import java.util.ArrayList;

public class Customer {
    private String name;
    private int balance;
    private List<Menu> orderHistory;

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.orderHistory = new ArrayList<>();
    }

    public List<Menu> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(Menu menu) {
        this.orderHistory.add(menu);
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}