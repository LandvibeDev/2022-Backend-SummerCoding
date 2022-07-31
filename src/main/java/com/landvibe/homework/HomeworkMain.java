package com.landvibe.homework;

import com.landvibe.homework.entity.User;
import com.landvibe.homework.service.MenuService;
import com.landvibe.homework.service.OrderService;
import com.landvibe.homework.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeworkMain {
    private static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    private static final AppConfig appconfig = new AppConfig();
    private static final UserService userService = appconfig.getUserService();
    private static final OrderService orderService = appconfig.getOrderService();
    private static final MenuService menuService = appconfig.getMenuService();

    public static void main(String[] args) throws IOException {
        init();
        userOperation();
    }

    static void init() {
        menuService.createMenu("짜장면", 6000);
        menuService.createMenu("간짜장", 7000);
        menuService.createMenu("짬뽕", 6500);
        menuService.createMenu("볶음밥", 7000);
        menuService.createMenu("탕수육", 12000);

    }

    static void userOperation() throws IOException {
        while (true) {
            System.out.println("무엇을 할까요 ?");
            System.out.println("1. 유저 선택");
            System.out.println("2. 유저 목록");
            System.out.println("3. 유저 생성");
            System.out.println("4. 프로그램 종료");
            System.out.println("원하는 작업의 숫자를 입력해 주세요");
            int op = Integer.parseInt(bf.readLine());
            if (op == 1) {
                System.out.println("선택하실 유저의 이름을 입력해 주세요");
                String name = bf.readLine();
                User user = userService.findByName(name);
                if (user == null) {
                    System.out.println("존재하지 않는 유저입니다\n");
                } else {
                    menuOperation(user);
                }
            } else if (op == 2) {
                userService.printUserList();
            } else if (op == 3) {
                System.out.println("생성할 유저 이름을 입력해 주세요");
                String name = bf.readLine();
                System.out.println("초기 금액을 입력해 주세요");
                int credit = Integer.parseInt(bf.readLine());
                userService.createUser(name, credit);
            } else if (op == 4) {
                System.out.println("안녕히가세요 ~");
                return;
            } else {
                System.out.println("ERROR : 1에서 4사이의 수를 입력해 주세요\n");
            }
        }
    }

    static void menuOperation(User user) throws IOException {
        while (true) {
            System.out.println("무엇을 할까요 ?");
            System.out.println("1. 메뉴판 보기");
            System.out.println("2. 주문하기");
            System.out.println("3. 내 주문 내역 보기");
            System.out.println("4. 전체 주문 내역 보기");
            System.out.println("5. 내 잔고 보기");
            System.out.println("6. 돈벌기");
            System.out.println("7. 유저 선택 화면으로");

            int cmd = Integer.parseInt(bf.readLine());
            if (cmd == 1) {
                menuService.printAllMenu();
            } else if (cmd == 2) {
                System.out.println("어떤 메뉴를 주문하시겠습니까? 주문번호 혹은 메뉴명을 적어주세요");
                String menuName = bf.readLine();
                orderService.createOrder(user, menuService.findMenu(menuName));
            } else if (cmd == 3) {
                orderService.printOrderList(user);
            } else if (cmd == 4) {
                orderService.printOrderList();
            } else if (cmd == 5) {
                userService.checkCredit(user);
            } else if (cmd == 6) {
                System.out.println("얼마나 버시겠어요 ? 숫자를 입력해 주세요");
                int value = Integer.parseInt(bf.readLine());
                userService.earnCredit(user, value);
            } else if (cmd == 7) {
                System.out.println("유저 선택 화면으로 이동합니다 \n");
                return;
            } else {
                System.out.println("올바르지 않은 입력입니다");
            }
        }
    }
}

