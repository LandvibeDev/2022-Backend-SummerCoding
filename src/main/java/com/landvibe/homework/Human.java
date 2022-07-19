package com.landvibe.homework;

public class Human {

    private String name;
    private int balance;

    Human(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void calBalance(int cost) {
        balance -= cost;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
