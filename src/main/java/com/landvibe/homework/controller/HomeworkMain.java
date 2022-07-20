package com.landvibe.homework.controller;

import com.landvibe.homework.model.Customer;
import com.landvibe.homework.model.Menu;
import com.landvibe.homework.model.MenuBoard;
import com.landvibe.homework.view.InputView;
import com.landvibe.homework.view.OutputView;

import java.util.Scanner;

public class HomeworkMain {

    public static void main(String[] args) {
        Customer customer = makeCustomer();
        MenuBoard menuBoard = makeMenuAndMenuBoard();
        buyFood(customer, menuBoard);
    }

    private static Customer makeCustomer() {
        Customer customer = new Customer("곽지원", 30000);
        return customer;
    }

    private static MenuBoard makeMenuAndMenuBoard() {
        MenuBoard menuBoard = new MenuBoard();
        menuBoard.setMenuBoard(new Menu(1, "짜장면", 6000));
        menuBoard.setMenuBoard(new Menu(2, "간짜장", 6500));
        menuBoard.setMenuBoard(new Menu(3, "짬뽕", 7000));
        menuBoard.setMenuBoard(new Menu(4, "짬뽕밥", 7000));

        return menuBoard;
    }

    private static void buyFood(Customer customer, MenuBoard menuBoard) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            OutputView.printStartScreen();
            InputView.askWhatToDo();
            String command = scanner.nextLine();
            if (command.equals("끝내기")) {
                break;
            } else if (command.equals("메뉴판 보기")) {
                OutputView.printMenuBoard(menuBoard);
            } else if (command.equals("주문하기")) {
                InputView.askOrderMenu();
                command = scanner.nextLine();
                Menu menu = menuBoard.isExistMenu(command); // 메뉴판에 있는 메뉴인지 확인
                if (menu == null) {
                    OutputView.printNoMenu();
                } else {
                    OrderMenu(customer, menu);
                }
            } else if (command.equals("주문 내역 보기")) {
                OutputView.printOrderHistory(customer);
            } else if (command.equals("내 잔고 보기")) {
                OutputView.printBalance(customer);
            } else {
                InputView.askInputAgain();
            }
        }
    }

    private static boolean checkBalance(Customer customer, Menu menu) {
        return customer.getBalance() >= menu.getPrice();
    } // 주문하기 전 잔고 확인

    private static void withdrawBalance(Customer customer, Menu menu) {
        customer.setBalance(customer.getBalance() - menu.getPrice());
    } // 잔액 인출

    private static void OrderMenu(Customer customer, Menu menu) {
        if (checkBalance(customer, menu)) {
            withdrawBalance(customer, menu);
            customer.setOrderHistory(menu);
        } else {
            OutputView.printNoMoney();
        }
    } // 메뉴 주문이 가능한 경우 주문
}