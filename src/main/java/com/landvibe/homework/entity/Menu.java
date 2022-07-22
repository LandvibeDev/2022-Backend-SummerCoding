package com.landvibe.homework.entity;

public class Menu {
    private Long id;
    private String name;
    private Integer price;

    public Menu(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void print() {
        System.out.println(this.name + " " + this.price + "원");
    }

    @Override
    public String toString() {
        return id + ". " + name + " " + price + "원";
    }
}
