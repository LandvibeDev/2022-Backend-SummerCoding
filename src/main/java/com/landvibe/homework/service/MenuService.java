package com.landvibe.homework.service;

import com.landvibe.homework.entity.Menu;

public interface MenuService {
    void createMenu(String name, int price);

    void printAllMenu();

    Menu findMenu(String menuName);

}
