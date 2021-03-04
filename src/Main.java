import java.util.Scanner;

public class Main {
    static UserManager userManager = new UserManager();
    static BookManager bookManager = new BookManager();
    static RentOrReturn rentOrReturn = new RentOrReturn();

    static Scanner scanner;

    public static void main(String[] args){
        scanner = new Scanner(System.in);

        System.out.println("[Main]=====================================\n");
        System.out.print("1. 사용자 관리   2. 도서 관리  3. 대여 및 반납\n숫자 입력 : ");

        int i = scanner.nextInt();

        System.out.print("\n");

        move(i);


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
