package com.landvibe.homework.model;

import java.util.List;
import java.util.ArrayList;

public class MenuBoard {
    private List<Menu> menuBoard;

    public MenuBoard() {
        this.menuBoard = new ArrayList<>();
    }

    public List<Menu> getMenuBoard() {
        return menuBoard;
    }

    public void setMenuBoard(Menu menu) {
        this.menuBoard.add(menu);
    }

    public Menu isExistMenu(String numberOrName) {
        for (Menu menu : this.menuBoard) {
            if (Integer.toString(menu.getNumber()).equals(numberOrName) || menu.getName().equals(numberOrName))
                return menu;
        }
        return null;
    }
}