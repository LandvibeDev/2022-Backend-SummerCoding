package com.landvibe.homework.model;

import java.util.ArrayList;

public class MenuBoard {
    ArrayList<Menu> menuBoard;

    public MenuBoard() {
        this.menuBoard = new ArrayList<>();
    }

    public ArrayList<Menu> getMenuBoard() {
        return menuBoard;
    }

    public void setMenuBoard(Menu menu) {
        this.menuBoard.add(menu);
    }

    // isExist 메소드는 메뉴판에 있는 메뉴인지 확인하는 동작은 같고
    // 번호로 확인하는지, 이름으로 확인하는지에 따라 다른 것이기 때문에
    // 스트림에 다른 조건을 걸어서 하나로 줄일 수 있는지 생각해보기
    public boolean isExistName(String name, MenuBoard menuBoard) {
        return menuBoard.getMenuBoard().stream()
                .anyMatch(menu -> name.equals(menu.getName()));
    }

    public boolean isExistNumber(int number, MenuBoard menuBoard) {
        return menuBoard.getMenuBoard().stream()
                .anyMatch(menu -> number == menu.getNumber());
    }

    // findMenu 메소드는 메뉴판에 있는 메뉴를 찾아서 리턴하는 동작은 같고
    // 번호로 찾는지, 이름으로 찾는지에 따라 다른 것이기 때문에
    // 스트림에 다른 조건을 걸어서 하나로 줄일 수 있는지 생각해보기
    public Menu findMenuByName(String name, MenuBoard menuBoard) {
        Menu item = menuBoard.getMenuBoard().stream()
                .filter(menu -> name.equals(menu.getName()))
                .findFirst()
                .get();
        return item;
    }

    public Menu findMenuByNumber(int number, MenuBoard menuBoard) {
        Menu item = menuBoard.getMenuBoard().stream()
                .filter(menu -> number == menu.getNumber())
                .findFirst()
                .get();
        return item;
    }
}