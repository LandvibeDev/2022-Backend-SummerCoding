package com.landvibe.homework.entity;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private String name;
    private Integer credit;
    private List<Order> orderList;

    public User(Long id, String name, Integer credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.orderList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void work(int value) {
        this.credit += value;
    }

    @Override
    public String toString() {
        return "이름 : " + name + "\n잔액 : " + credit;
    }

    public void addOrder(Order order) {
        orderList.add(order);
        credit -= order.getMenu().getPrice();
    }
}
