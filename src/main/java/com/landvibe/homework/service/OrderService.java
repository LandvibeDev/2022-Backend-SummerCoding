package com.landvibe.homework.service;

import com.landvibe.homework.entity.Menu;
import com.landvibe.homework.entity.User;

public interface OrderService {
    void createOrder(User user, Menu menu);

    void printOrderList(User user);

    void printOrderList();
}
