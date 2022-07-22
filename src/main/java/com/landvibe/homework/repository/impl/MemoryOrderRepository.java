package com.landvibe.homework.repository.impl;

import com.landvibe.homework.entity.Order;
import com.landvibe.homework.repository.OrderRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryOrderRepository implements OrderRepository {

    private static final Map<Long, Order> store = new HashMap<>();

    @Override
    public void save(Order order) {
        store.put(order.getId(), order);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Order> findOrderByUser(Long userId) {
        List<Order> orderList = new ArrayList<>();
        for (Order order : store.values()) {
            if (order.getUser().getId().equals(userId))
                orderList.add(order);
        }

        return orderList;
    }

    @Override
    public Long getCount() {
        return (long) store.size() + 1;
    }
}
