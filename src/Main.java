import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static UserManager userManager = new UserManager();
    static BookManager bookManager = new BookManager();
    static RentOrReturn rentOrReturn = new RentOrReturn();
    static Utill utill = new Utill();

    public static void main(String[] args)  {
        while (true) {
            utill.startTitle("Main");

            int i = utill.startSentence3("사용자 관리", "도서 관리", "대여 및 반납");

            move(i);

            if (utill.loop("추가로 관리할 항목이 있습니까?") == false)
                System.out.println("프로그램을 종료합니다. 빠빠이~★");
                return;
        }

    }

    private static void move(int i) {
        switch (i){
            case 1:
                userManager.start();
                break;
            case 2:
                bookManager.start();
                break;
            case 3:
                rentOrReturn.start();
                break;
        }
    }


}
