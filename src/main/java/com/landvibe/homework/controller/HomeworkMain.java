package com.landvibe.homework.controller;

import com.landvibe.homework.model.Customer;
import com.landvibe.homework.model.History;
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
                boolean isDigit = command.chars().allMatch(Character::isDigit);
                if (isDigit) {
                    OrderByNumber(Integer.parseInt(command), menuBoard, customer); // 번호로 주문하는 경우
                } else {
                    OrderByName(command, menuBoard, customer); // 이름으로 주문하는 경우
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

    // OrderBy 메소드는 주문하는 동작은 같고
    // 번호로 주문하는지, 이름으로 주문하는지에 따라 다른 것이기 때문에
    // 스트림에 다른 조건을 걸어서 하나로 줄일 수 있는지 생각해보기
    private static void OrderByNumber(int number, MenuBoard menuBoard, Customer customer) {
        boolean isExist = menuBoard.isExistNumber(number, menuBoard);
        if (isExist) {
            Menu menu = menuBoard.findMenuByNumber(number, menuBoard);
            OrderMenu(customer, menu);
        } else {
            OutputView.printNoMenu();
        }
    } // 존재하는 메뉴 번호인지 찾고 주문 가능한 경우 주문

    private static void OrderByName(String name, MenuBoard menuBoard, Customer customer) {
        boolean isExist = menuBoard.isExistName(name, menuBoard);
        if (isExist) {
            Menu menu = menuBoard.findMenuByName(name, menuBoard);
            OrderMenu(customer, menu);
        } else {
            OutputView.printNoMenu();
        }
    } // 존재하는 메뉴 이름인지 찾고 주문가능한 경우 주문

    private static boolean isOrder(Customer customer, Menu menu) {
        return customer.getBalance() - menu.getPrice() >= 0;
    } // 주문하기 전 잔고 확인

    private static void calculateBalance(Customer customer, Menu menu) {
        customer.setBalance(customer.getBalance() - menu.getPrice());
    } // 잔액 인출

    private static void OrderMenu(Customer customer, Menu menu) {
        if (isOrder(customer, menu)) {
            calculateBalance(customer, menu);
            customer.getOrderHistory().add(new History(customer.getName(), menu));
        } else {
            OutputView.printNoMoney();
        }
    } // 메뉴 주문이 가능한 경우 주문
}