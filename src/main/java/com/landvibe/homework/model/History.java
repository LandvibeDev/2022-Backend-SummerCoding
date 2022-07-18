package com.landvibe.homework.model;

public class History {
    String ordererName;
    Menu menu;

    public History(String ordererName, Menu menu){
        this.ordererName = ordererName;
        this.menu = menu;
    }

    public String getOrdererName() {
        return ordererName;
    }

    public void setOrdererName(String ordererName) {
        this.ordererName = ordererName;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
