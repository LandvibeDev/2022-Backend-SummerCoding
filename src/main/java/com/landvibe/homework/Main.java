package com.landvibe.homework;

import com.landvibe.homework.ChineseRestaurant;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("심찬희", 100000);
        ChineseRestaurant restaurant = new ChineseRestaurant();
        restaurant.open(customer);
    }


}
