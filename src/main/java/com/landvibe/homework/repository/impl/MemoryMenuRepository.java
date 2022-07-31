package com.landvibe.homework.repository.impl;

import com.landvibe.homework.entity.Menu;
import com.landvibe.homework.repository.MenuRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryMenuRepository implements MenuRepository {
    private static final Map<Long, Menu> store = new HashMap<>();

    @Override
    public void save(Menu menu) {
        store.put(menu.getId(), menu);
    }

    @Override
    public Menu findById(Long menuId) {
        return store.get(menuId);
    }

    @Override
    public Menu findByName(String menuName) {
        for (Menu menu : store.values()) {
            if (menu.getName().equals(menuName)) return menu;
        }
        return null;
    }

    @Override
    public List<Menu> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Long getCount() {
        return (long) store.size() + 1;
    }
}
