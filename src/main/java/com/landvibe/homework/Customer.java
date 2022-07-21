package com.landvibe.homework;

import java.util.List;

public class Customer {

    private String name;

    private List<Menu> menu;
    private int balance;

    Customer(String name, int balance, List<Menu> menu) {
        this.name = name;
        this.balance = balance;
        this.menu= menu;
    }

    public boolean checkMenu(String orderLog,String checkNum, String checkName){
       if(orderLog.equals(checkNum)|| orderLog.equals(checkName)){
           return true;
       }
       return false;
    }

    public boolean checkBalance(int cost){
        if(balance>=cost)
            return true;
        return false;
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
