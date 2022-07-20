package com.landvibe.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeworkMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice, myName;
        int initAccount;
        List<Menu> menus = new ArrayList<>();
        List<Menu> orderedList = new ArrayList<>();
        menus.add(new Menu(1, "짜장면", 6000));
        menus.add(new Menu(2, "간짜장", 6500));
        menus.add(new Menu(3, "설원", 15000));
        menus.add(new Menu(4, "짬뽕", 7000));
        menus.add(new Menu(5, "짬뽕밥", 7500));

        System.out.println("이름을 입력해 주세요");
        myName = sc.nextLine();
        System.out.println("얼마를 가지고 있나요? (숫자만 입력)");
        initAccount = Integer.parseInt(sc.nextLine());
        Account myAccount = new Account(myName, initAccount);

        while (true) {
            System.out.println(
                    "\n1. 메뉴판 보기\n" +
                            "2. 주문 하기\n" +
                            "3. 주문 내역 보기\n" +
                            "4. 내 잔고 보기\n" +
                            "5. 끝내기\n\n" +
                            "무엇을 할까요?"
            );

            choice = sc.nextLine();

            switch (choice) {
                case "1":
                case "메뉴판 보기":
                    for (Menu i : menus) {
                        System.out.println(i.getMenuNumber() + " " + i.getName() + " " + i.getPrice());
                    }
                    break;

                case "2":
                case "주문하기":
                    System.out.println("어떤 메뉴를 주문하시겠습니까? 주문번호 혹은 메뉴명을 적어주세요");
                    String c = sc.nextLine();
                    for (Menu menu : menus) {
                        if (!menu.isSameMenu(c))
                            continue;
                        if (myAccount.isPossibleToWithdraw(menu.getPrice())) {
                            myAccount.withdraw(menu.getPrice());
                            orderedList.add(menu);
                            System.out.println("주문이 완료되었습니다.");
                        } else {
                            System.out.println("잔액이 부족합니다.");
                        }
                        break;
                    }
                    break;
                case "3":
                case "주문 내역 보기":
                    if (orderedList.isEmpty()) {
                        System.out.println("주문 내역이 없습니다.");
                        break;
                    }
                    for (Menu menu : orderedList) {
                        System.out.println("이름 : " + myName);
                        System.out.println("메뉴 : " + menu.getName() + " 가격 : " + menu.getPrice() + "원");
                    }
                    break;
                case "4":
                case "내 잔고 보기":
                    myAccount.printAccount();
                    break;
                case "5":
                case "끝내기":
                    return;
                default:
                    break;
            }
        }
    }

}

