package com.landvibe.homework;
import com.landvibe.homework.ChineseRestaurant;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Customer> customer = new ArrayList<Customer>();
        customer.add(new Customer("심찬희", 100000));
        ChineseRestaurant restaurant = new ChineseRestaurant();
        restaurant.open(customer);
    }


}
