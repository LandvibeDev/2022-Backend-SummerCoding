package com.landvibe.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import com.landvibe.homework.Menu;
import com.landvibe.homework.Customer;

public class ChineseRestaurant {
    List<Menu> menus = new ArrayList<Menu>();
    Scanner scanner = new Scanner(System.in);

    public void open(Customer customer) {
        //메뉴 정보
        menus.add(new Menu("1", "짜장면", 6000));
        menus.add(new Menu("2", "간짜장", 6500));
        menus.add(new Menu("3", "짬뽕", 7000));
        menus.add(new Menu("4", "짬뽕밥", 7000));
        //무엇을 할까요
        System.out.println("1. 메뉴판 보기");
        System.out.println("2. 주문하기");
        System.out.println("3. 주문 내역 보기");
        System.out.println("4. 내 잔고 보기");
        System.out.println("5. 끝내기");
        System.out.println("\n무엇을 할까요?");
        String what;
        what = scanner.nextLine();
        while (!what.equals("끝내기")) {
            if (what.equals("메뉴판 보기")) {
                printMenuList();
            } else if (what.equals("주문하기")) {
                order(customer);
            } else if (what.equals("주문 내역 보기")) {
                orderList(customer);
            } else if (what.equals("내 잔고 보기")) {
                System.out.println(customer.getBalance() + "원");
            }
            System.out.println("\n무엇을 할까요?");
            what = scanner.nextLine();
        }
        scanner.close();

    }

    void printMenuList() {
        for (int i = 0; i < menus.size(); i++) {
            System.out.println(menus.get(i).getMenuId() + ". " + menus.get(i).getMenuName() + " " + menus.get(i).getPrice() + "원");
        }
    }

    void order(Customer customer) {
        String order;
        System.out.println("어떤 메뉴를 주문하시겠습니까? 주문번호 혹은 메뉴명을 적어주세요");
        order = scanner.next();
        scanner.nextLine();
        boolean yesOrder = false; // 주문 완료 되었는지 확인(메뉴의 존재 유무 확인)
        for (int i = 0; i < menus.size(); i++) {
            if (order.equals(menus.get(i).getMenuId()) || order.equals(menus.get(i).getMenuName())) {
                int menuPrice = menus.get(i).getPrice();
                if (customer.checkBalance(menuPrice)) {//잔고 확인
                    customer.expenditure(menuPrice);// 잔고에서 금액 소비
                    System.out.println("주문이 완료되었습니다.");
                    customer.setOrderList(i);//주문 완료 후 고객의 주문 내역에 추가
                } else {
                    System.out.println("잔고가 부족합니다");
                }
                yesOrder = true;
                break;
            }
        }
        if (!yesOrder) {
            System.out.println("해당메뉴가 없습니다.");
        }
    }

    void orderList(Customer customer) {
        ArrayList orderList = customer.getOrderList(); // 고객의 주문 내역 가져오기
        for (Object i : orderList) {
            System.out.println("이름 : " + customer.getName());
            System.out.println("메뉴 : " + menus.get((int) i).getMenuName() + ", 가격 : " + menus.get((int) i).getPrice() + "원");
        }
    }


}

