package com.landvibe.homework.repository;

import com.landvibe.homework.entity.Order;

import java.util.List;

public interface OrderRepository {

    Long getCount();

    void save(Order order);

    List<Order> findAllOrders();

    List<Order> findOrderByUser(Long userId);
}
