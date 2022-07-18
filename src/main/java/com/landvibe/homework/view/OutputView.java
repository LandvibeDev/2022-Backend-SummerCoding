package com.landvibe.homework.view;

import com.landvibe.homework.model.Customer;
import com.landvibe.homework.model.History;
import com.landvibe.homework.model.Menu;
import com.landvibe.homework.model.MenuBoard;

public class OutputView {
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String FIVE = "5";

    private static final String DOT = ".";

    private static final String SHOW_MENU_BOARD = "메뉴판 보기";
    private static final String ORDER = "주문하기";
    private static final String SHOW_ORDER_HISTORY = "주문 내역 보기";
    private static final String SHOW_BALANCE = "내 잔고 보기";
    private static final String QUIT = "끝내기";

    private static final String NO_MENU = "해당메뉴가 없습니다.";
    private static final String NO_MONEY = "잔액이 부족합니다.";


    public static void printStartScreen() {
        System.out.println();
        System.out.println(ONE + DOT + SHOW_MENU_BOARD);
        System.out.println(TWO + DOT + ORDER);
        System.out.println(THREE + DOT + SHOW_ORDER_HISTORY);
        System.out.println(FOUR + DOT + SHOW_BALANCE);
        System.out.println(FIVE + DOT + QUIT);
        System.out.println();
    }

    public static void printNoMenu() {
        System.out.println(NO_MENU);
    }

    public static void printNoMoney() {
        System.out.println(NO_MONEY);
    }

    public static void printMenuBoard(MenuBoard menuBoard) {
        for (Menu menu : menuBoard.getMenuBoard()) {
            System.out.println(String.format("%d. %s, %d원", menu.getNumber(), menu.getName(), menu.getPrice()));
        }
    }

    public static void printOrderHistory(Customer customer) {
        for (History history : customer.getOrderHistory()) {
            System.out.println(String.format("이름: %s\n메뉴: %s, 가격 %d원", history.getOrdererName(), history.getMenu().getName(), history.getMenu().getPrice()));
        }
    }

    public static void printBalance(Customer customer) {
        System.out.println(String.format("%d원", customer.getBalance()));
    }
}