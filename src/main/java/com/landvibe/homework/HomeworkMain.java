package com.landvibe.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import com.landvibe.homework.Customer;
import com.landvibe.homework.Menu;

public class HomeworkMain {
    public static void main(String[] args) {
        List<Menu> menu = new ArrayList<>();
        List<Menu> menuOrder = new ArrayList<>();
        menu.add(new Menu(1, "짜장면", 6000));
        menu.add(new Menu(2, "간짜장", 6500));
        menu.add(new Menu(3, "짬뽕", 7000));
        menu.add(new Menu(4, "짬뽕밥", 7000));

        Customer customer = new Customer("함석원", 100000, menu);

        Scanner sc = new Scanner(System.in);

        String cas = "";
        String orderNum = "0";
        
        /////////////////////////////////////////////
        System.out.println("1. 메뉴판 보기\n2. 주문하기\n" +
                "3. 주문 내역 보기\n4. 내 잔고 보기\n5. 끝내기\n");
        while (cas != "끝내기") {

            System.out.println("\n무엇을 할까요?");

            cas = sc.nextLine();

            if (cas.equals("메뉴판 보기")) {
                for (int i = 0; i < menu.size(); i++) {
                    System.out.println(menu.get(i).getOrderNum() + ". " +
                            menu.get(i).getName() + " " + menu.get(i).getCost()
                            + "원");
                }
            } else if (cas.equals("주문하기")) {
                boolean existMenu = false;
                System.out.println("어떤 메뉴를 주문하시겠습니까? 주문번호 혹은 " +
                        "메뉴명을 적어주세요");
                orderNum = sc.next();
                sc.nextLine();
                for (int i = 0; i < menu.size(); i++) {
                    if (customer.checkMenu(orderNum,Integer.toString((i + 1)),menu.get(i).getName())) { //메뉴 검색
                        if (customer.checkBalance(menu.get(i).getCost())) { //잔고확인
                            customer.calBalance(menu.get(i).getCost()); //결제
                            menuOrder.add(menu.get(i));
                            existMenu = true;
                            System.out.println("주문이 완료되었습니다");
                        } else {
                            existMenu = true;
                            System.out.println("잔액이 부족합니다\n");
                        }
                    }
                }
                if (!existMenu) {
                    System.out.println("해당 메뉴가 없습니다.");
                }
            } else if (cas.equals("주문 내역 보기")) {
                for(int i=0;i<menuOrder.size();i++) {
                    System.out.println("이름 : " + customer.getName() + "\n메뉴 : "
                            + menuOrder.get(i).getName() + ", 가격 : " + menuOrder.get(i).getCost() + "원");
                }
            } else if (cas.equals("내 잔고 보기")) {
                System.out.println(customer.getBalance() + "원");
            } else if (cas.equals("끝내기")) {
                break;
            }
        }
    }
}
