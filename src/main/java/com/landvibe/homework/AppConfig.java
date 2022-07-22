package com.landvibe.homework;

import com.landvibe.homework.repository.MenuRepository;
import com.landvibe.homework.repository.OrderRepository;
import com.landvibe.homework.repository.UserRepository;
import com.landvibe.homework.repository.impl.MemoryMenuRepository;
import com.landvibe.homework.repository.impl.MemoryOrderRepository;
import com.landvibe.homework.repository.impl.MemoryUserRepository;
import com.landvibe.homework.service.MenuService;
import com.landvibe.homework.service.OrderService;
import com.landvibe.homework.service.UserService;
import com.landvibe.homework.service.impl.MenuServiceImpl;
import com.landvibe.homework.service.impl.OrderServiceImpl;
import com.landvibe.homework.service.impl.UserServiceImpl;

public class AppConfig {
    private static final MenuRepository menuRepository = new MemoryMenuRepository();
    private static final OrderRepository orderRepository = new MemoryOrderRepository();
    private static final UserRepository userRepository = new MemoryUserRepository();
    private static final MenuService menuService = new MenuServiceImpl(menuRepository);
    private static final OrderService orderService = new OrderServiceImpl(orderRepository,menuRepository);
    private static final UserService userService = new UserServiceImpl(userRepository);

    public MenuRepository getMenuRepository() {
        return menuRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public MenuService getMenuService() {
        return menuService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public UserService getUserService() {
        return userService;
    }
}
