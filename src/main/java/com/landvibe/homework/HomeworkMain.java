package com.landvibe.homework;

import java.util.Scanner;
import java.util.Vector;

import com.landvibe.homework.Human;
import com.landvibe.homework.Menu;

public class HomeworkMain {
    public static void main(String[] args) {
        Menu m1 = new Menu(1, "짜장면", 6000);
        Menu m2 = new Menu(2, "간짜장", 6500);
        Menu m3 = new Menu(3, "짬뽕", 7000);
        Menu m4 = new Menu(4, "짬뽕밥", 7000);
        Menu[] menu = new Menu[]{m1, m2, m3, m4};

        Human human = new Human("함석원", 100000);

        Scanner sc = new Scanner(System.in);

        String cas = "";
        String OrderNum = "0";

        Vector<Menu> v = new Vector<Menu>();
        /////////////////////////////////////////////
        System.out.println("1. 메뉴판 보기\n2. 주문하기\n" +
                "3. 주문 내역 보기\n4. 내 잔고 보기\n5. 끝내기\n");
        while (cas != "끝내기") {

            System.out.println("\n무엇을 할까요?");

            cas = sc.nextLine();

            if (cas.equals("메뉴판 보기")) {
                for (int i = 0; i < menu.length; i++) {
                    System.out.println(menu[i].getOrderNum() + ". " +
                            menu[i].getName() + " " + menu[i].getCost()
                            + "원");
                }
            } else if (cas.equals("주문하기")) {
                boolean flag = false;
                System.out.println("어떤 메뉴를 주문하시겠습니까? 주문번호 혹은 " +
                        "메뉴명을 적어주세요");
                OrderNum = sc.next();
                sc.nextLine();
                for (int i = 0; i < menu.length; i++) {
                    if (OrderNum.equals(Integer.toString((i + 1))) || OrderNum.equals(menu[i].getName())) {
                        if (human.getBalance() >= menu[i].getCost()) {
                            human.calBalance(menu[i].getCost());
                            v.add(menu[i]);
                            flag = true;
                            System.out.println("주문이 완료되었습니다");
                        } else {
                            flag = true;
                            System.out.println("잔액이 부족합니다\n");
                        }
                    }
                }
                if (!flag) {
                    System.out.println("해당 메뉴가 없습니다.");
                }
            } else if (cas.equals("주문 내역 보기")) {
                for (var i : v) {
                    System.out.println("이름 : " + human.getName() + "\n메뉴 : "
                            + i.getName() + ", 가격 : " + i.getCost() + "원");
                }
            } else if (cas.equals("내 잔고 보기")) {
                System.out.println(human.getBalance() + "원");
            } else if (cas.equals("끝내기")) {
                break;
            }
        }
    }
}
