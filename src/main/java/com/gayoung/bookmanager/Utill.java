package com.gayoung.bookmanager;

import java.util.Scanner;

public class Utill {
    Scanner scanner = new Scanner(System.in);

    public void startTitle(String msg){
        System.out.println("[" + msg + "]=====================================");
    }

    public int startSentence3(String msg1, String msg2, String msg3){
       String stringBuilder =  "1. " + msg1 + "2. " + msg2 + "3. " + msg3 + "\n숫자 입력 : ";
        System.out.println(stringBuilder);

       int i = readSaftyInt();
       System.out.print("\n");
       return i;
   }

    public int startSentence4(String msg1, String msg2, String msg3, String msg4){
        String stringBuilder = "1. " + msg1 + "2. " + msg2 + "3. " + msg3 + "4. " + msg4 + "\n숫자 입력 : ";
        System.out.println(stringBuilder);
        int i = readSaftyInt();
        System.out.print("\n");
        return i;
    }

    public boolean loop(String msg){
        System.out.print("\n"+ msg + " 없으면 -1, 있으면 아무 숫자 누르시오. : ");
        return readSaftyInt() != -1;
    }

    public int readSaftyInt() {
        while (true) {
            int index;

            try {
                index = scanner.nextInt();
            } catch (Exception exception) {
                System.out.print("제대로 입력 ㄱㄱ");
                scanner.nextLine();
                continue;
            }
            return index;
        }
    }

    public String readSaftyString() {
        while (true) {
            String string;

            try {
                string = scanner.next();
            } catch (Exception exception) {
                System.out.print("제대로 입력 ㄱㄱ");
                scanner.nextLine();
                continue;
            }
            return string;
        }
    }

    public boolean IntStringGubun(String searchWord){

        boolean isNumber = true;


        for(char c : searchWord.toCharArray()){
            if (c >= 48 && c <= 57){
                System.out.println(c);
                continue;

            }else{
                isNumber = false;
                break;
            }
        }

        return isNumber;
    }

}
