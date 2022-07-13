package com.landvibe.homework;

import java.util.Scanner;

public class HomeworkMain {
    public static void main(String[] args) {
        System.out.println("hello world");

        Scanner scanner = new Scanner(System.in);


        System.out.println("이름을 입력해주세요.");
        String name = scanner.nextLine();

        System.out.println(name+" 님 안녕하세요!");
    }
}
