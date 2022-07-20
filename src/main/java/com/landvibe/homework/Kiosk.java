package com.landvibe.homework;

import java.util.*;
import com.landvibe.homework.Customer;
import com.landvibe.homework.Menu;

public class Kiosk {
    private Customer customer; // 주문자
    private List<Menu> menuList = new ArrayList<>(); // 메뉴 리스트

    // 생성자, customer와 menuList 초기화
    public Kiosk(Customer customer) {
        // 고객 정보 받기
        this.customer = customer;

        // Menu 리스트인 menuList를 기본 메뉴들로 초기화!
        menuList.add(new Menu("짜장면", 6000));
        menuList.add(new Menu("간짜장", 6500));
        menuList.add(new Menu("짬뽕", 7000));
        menuList.add(new Menu("짬뽕밥", 7000));
        menuList.add(new Menu("차돌짬뽕", 9000));
    }

    // 키오스크의 option을 출력하는 함수
    public void printOption() {
        System.out.println("0. 옵션 보기");
        System.out.println("1. 메뉴판 보기");
        System.out.println("2. 주문 하기");
        System.out.println("3. 주문 내역 보기");
        System.out.println("4. 내 잔고 보기");
        System.out.println("5. 잔고 충전하기");
        System.out.println("6. 끝내기");
    }

    // 메뉴 리스트를 출력하는 함수
    public void printMenu() {
        System.out.println("-------메뉴판-------");
        for(int i = 0 ; i < menuList.size() ; i++) {
            System.out.println( (i+1) + ". " + menuList.get(i).getName() + " " + menuList.get(i).getPrice() + "원" );
        }
        System.out.println("-------------------");
    }

    // 입력(주문 번호 or 메뉴 이름)이 들어오면 menuList를 돌면서 해당 메뉴를 찾는 함수
    public Menu findMenu(String order) {
        for(int i = 0 ; i < menuList.size() ; i++) {
            if(order.equals(Integer.toString(i+1)) || order.equals(menuList.get(i).getName()))
                return menuList.get(i);
        }
        return null;
    }

    // 메뉴를 주문하는 함수
    public void orderMenu(String order) {
        Menu orderedMenu = findMenu(order); // 주문된 메뉴가 무엇인지 찾기

        if(orderedMenu == null) { // 메뉴 리스트에서 찾지 못했다면
            System.out.println("해당 메뉴가 없습니다.");
            return;
        }

        if(customer.payMoney(orderedMenu.getPrice())) { // 금액만큼 결제, 결제 성공시 true 반환
            customer.addOrderHistory(orderedMenu); // 주문 내역에 메뉴 추가
        }
    }

    // 고객의 주문 내역을 출력하는 함수
    public void printOrderHistory() {
        List<Menu> orderHistory = customer.getOrderHistory();

        // 주문 내역 리스트가 비어있다면
        if(orderHistory.isEmpty()) {
            System.out.println("주문 내역이 존재하지 않습니다.");
            return;
        }

        for (int i = 0; i < orderHistory.size(); i++) {
            System.out.println("이름 : " + customer.getName());
            System.out.println("메뉴 : " + orderHistory.get(i).getName() + ", 가격 : " + orderHistory.get(i).getPrice() + "원");
        }

    }

}