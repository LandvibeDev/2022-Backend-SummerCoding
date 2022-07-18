package com.landvibe.homework;
import java.util.Scanner;
import java.util.Vector;

class Menu {

    private int _Or;
    private int _co;
    private String _na;
    Menu(int OrderNum,
         String name,
         int cost){
        _Or=OrderNum;
        _co=cost;
        _na=name;
    }

    public int getOrderNum(){
        return _Or;
    }
    public int getCost(){
        return _co;
    }
    public String getName(){
        return _na;
    }
}

class Human{

    private String _na;
    private int _ba;
    Human(String name,int balance){
        _na=name;
        _ba=balance;
    }

    public void setBalance(int cost){
        _ba-=cost;
    }
    public int getBalance(){
        return _ba;
    }
    public String getName(){
        return _na;
    }
}
public class HomeworkMain {
    static Menu m1=new Menu(1,"짜장면",6000);
    static Menu m2=new Menu(2,"간짜장",6500);
    static Menu m3=new Menu(3,"짬뽕",7000);
    static Menu m4=new Menu(4,"짬뽕밥",7000);
    static Menu[] menu =new Menu[]{m1,m2,m3,m4};
    static Human human=new Human("함석원",100000);

    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args)
    {
        String cas = "";
        String OrderNum="0";
        Vector<Menu> v=new Vector<Menu>();
        System.out.println("1. 메뉴판 보기\n2. 주문하기\n" +
                "3. 주문 내역 보기\n4. 내 잔고 보기\n5. 끝내기\n" );
        while(cas!="끝내기"){

            System.out.println("\n무엇을 할까요?");

            cas=sc.nextLine();

            if(cas.equals("메뉴판 보기")){
                for (int i = 0; i< menu.length; i++){
                    System.out.println(menu[i].getOrderNum()+". "+
                            menu[i].getName()+" "+ menu[i].getCost()
                            +"원");
                }
                continue;
            }
            else if(cas.equals("주문하기")){
                boolean flag=false;
                System.out.println("어떤 메뉴를 주문하시겠습니까? 주문번호 혹은 " +
                        "메뉴명을 적어주세요");
                OrderNum=sc.next();
                sc.nextLine();
                for (int i = 0; i< menu.length; i++){
                    if(OrderNum.equals(Integer.toString((i+1)))||OrderNum.equals(menu[i].getName())){
                        if(human.getBalance()>= menu[i].getCost()) {
                            human.setBalance(menu[i].getCost());
                            v.add(menu[i]);
                            flag=true;
                            System.out.println("주문이 완료되었습니다");
                        }
                        else{
                            flag=true;
                            System.out.println("잔액이 부족합니다\n");
                        }
                        continue;
                    }
                }
                if(!flag){
                    System.out.println("해당 메뉴가 없습니다.");
                }
                continue;
            }
            else if(cas.equals("주문 내역 보기")){
                for(var i:v){
                    System.out.println("이름 : "+human.getName()+"\n메뉴 : "
                            +i.getName()+", 가격 : "+i.getCost()+"원");
                }
                continue;
            }
            else if(cas.equals("내 잔고 보기")){
                System.out.println(human.getBalance()+"원");
                continue;
            }
            else if(cas.equals("끝내기")){
                break;
            }
        }
    }
}
