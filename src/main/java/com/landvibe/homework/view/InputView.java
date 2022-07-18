package com.landvibe.homework.view;

public class InputView {

    private static final String WHAT_TO_DO = "무엇을 할까요?";
    private static final String SELECT_MENU = "어떤 메뉴를 주문하시겠습니까? 주문 번호 혹은 메뉴명을 입력해주세요.";
    private static final String INPUT_AGAIN = "다시 입력하세요.";

    public static void askWhatToDo() {
        System.out.println(WHAT_TO_DO);
    }

    public static void askOrderMenu() {
        System.out.println(SELECT_MENU);
    }

    public static void askInputAgain() {
        System.out.println(INPUT_AGAIN);
    }
}