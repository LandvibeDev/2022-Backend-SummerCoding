package com.landvibe.homework;

public class Menu {
    private String name;
    private int menuNumber, price;

    public Menu(int menuNumber, String name, int price) {
        this.menuNumber = menuNumber;
        this.name = name;
        this.price = price;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public void setMenuNumber(int menuNumber) {
        this.menuNumber = menuNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSameMenu(String numOrName){
        return (Integer.toString(this.menuNumber).equals(numOrName) || this.name.equals(numOrName));
    }
}
