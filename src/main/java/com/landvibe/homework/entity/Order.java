package com.landvibe.homework.entity;

public class Order {

    private Long id;
    private Menu menu;
    private User user;

    public Order(Long id, Menu menu, User user) {
        this.id = id;
        this.menu = menu;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "이름 : " + user.getName() + "\n메뉴 : " + menu.getName() + ", 가격 : " + menu.getPrice();
    }
}
