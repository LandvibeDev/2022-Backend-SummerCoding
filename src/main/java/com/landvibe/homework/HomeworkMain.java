package com.landvibe.homework;

import java.util.Scanner;

import com.landvibe.homework.Customer;
import com.landvibe.homework.Kiosk;

public class HomeworkMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("어서오세요. 주문자명을 입력해주세요.");
        String name = scanner.nextLine();

        System.out.println("초기 잔액을 입력해주세요. ex) 10000 ");
        int money = scanner.nextInt();
        String line = scanner.nextLine(); // 남아있는 \n를 없애주기 위함

        // customer, kiosk 객체 생성
        Customer customer = new Customer(name, money);
        Kiosk kiosk = new Kiosk(customer);

        // 여기서부터 시작
        kiosk.printOption();

        while(true) {
            System.out.println("무엇을 할까요?");
            String choice = scanner.nextLine();

            if(choice.equals("0") || choice.equals("옵션 보기")) {
                kiosk.printOption();
            }
            else if(choice.equals("1") || choice.equals("메뉴판 보기")) {
                kiosk.printMenu();
            }
            else if(choice.equals("2") || choice.equals("주문 하기")) {
                System.out.println("어떤 메뉴를 주문하시겠습니까? 주문 번호 혹은 메뉴명을 적어주세요.");

                String order = scanner.next();
                line = scanner.nextLine();

                kiosk.orderMenu(order);
            }
            else if(choice.equals("3") || choice.equals("주문 내역 보기")) {
                kiosk.printOrderHistory();
            }
            else if(choice.equals("4") || choice.equals("내 잔고 보기")) {
                customer.printMoney();
            }
            else if(choice.equals("5") || choice.equals("잔고 충전하기")) {
                System.out.println("충전하실 금액을 적어주세요. ex) 10000 ");

                int charging = scanner.nextInt();
                line = scanner.nextLine();

                customer.chargeMoney(charging);

                System.out.println("충전이 완료되었습니다.");
            }
            else if(choice.equals("6") || choice.equals("끝내기")){
                System.out.println("이용해주셔서 감사합니다. 또 오세요!");
                break;
            }
            else {
                System.out.println("다시 입력해주세요.");

            }
        }

        scanner.close();
    }

}
