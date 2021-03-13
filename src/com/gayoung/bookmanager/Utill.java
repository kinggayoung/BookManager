package com.gayoung.bookmanager;

import java.util.Scanner;

public class Utill {
    Scanner scanner = new Scanner(System.in);

    public void startTitle(String msg){
        System.out.println("[" + msg + "]=====================================");
    }

    public int startSentence3(){
       System.out.print("1.사용자 관리\t2.도서 관리\t3. 대여 및 반납\n숫자 입력 : ");
       int i = scanner.nextInt();
       System.out.print("\n");
       return i;
   }

    public int startSentence4(String msg1, String msg2, String msg3, String msg4){
        String stringBuilder = "1. " + msg1 + "2. " + msg2 + "3. " + msg3 + "4. " + msg4 + "\n숫자 입력 : ";
        System.out.println(stringBuilder);
        int i = scanner.nextInt();
        System.out.print("\n");
        return i;
    }

    public boolean loop(String msg){
        System.out.print("\n"+ msg + " 없으면 -1, 있으면 아무 숫자 누르시오. : ");
        return scanner.nextInt() != -1;
    }

}
