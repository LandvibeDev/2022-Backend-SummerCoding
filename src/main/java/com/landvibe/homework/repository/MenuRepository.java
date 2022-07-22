package com.landvibe.homework.repository;

import com.landvibe.homework.entity.Menu;

import java.util.List;

public interface MenuRepository {
    Long getCount();

    void save(Menu menu);

    Menu findById(Long menuId);

    Menu findByName(String menuName);

    List<Menu> findAll();
}
