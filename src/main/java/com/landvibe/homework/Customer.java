package com.landvibe.homework;

import java.util.*;

public class Customer {
    private String name;
    private int money;
    //고객이 주문한 주문 번호를 저장해놓는 정수형 리스트
    private List<Menu> orderHistory = new ArrayList<>();

    public Customer(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() { return name; };
    public int getMoney() { return money; };
    public List<Menu> getOrderHistory() { return orderHistory; };

    // ArrayList인 orderHistory에 주문 메뉴 하나를 더해주는 함수
    public void addOrderHistory(Menu menu) {
        orderHistory.add(menu);
    }

    // 잔고를 출력하는 함수
    public void printMoney() {
        System.out.println(name + " 님의 잔고 : " + money + "원");
    }

    // 계산하는 함수로, 계산에 성공했을 경우 true return
    public boolean payMoney(int price) {
        if(price > money) {
            System.out.println("잔고가 부족합니다.");
            return false;
        }

        this.money -= price;
        System.out.println("주문이 완료되었습니다.");
        return true;
    }

    // 잔고를 충전해주는 함수로, 충전한 만큼 money에 더해줌
    public void chargeMoney(int charging) {
        this.money += charging;
    }


}
