package com.landvibe.homework;

public class Account {
    private String owner;
    private int account;

    public Account(String owner, int account) {
        this.owner = owner;
        this.account = account;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void printAccount() {
        System.out.println(this.getOwner() + "님의 잔고 : " + this.getAccount() + "원\n");
    }

    public boolean isPossibleToWithdraw(int price) {
        return this.account >= price;
    }

    public void withdraw(int price){
        this.account -= price;
    }
}
