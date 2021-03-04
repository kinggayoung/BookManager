import java.util.Scanner;
import java.util.TreeMap;

public class Utill {
    Scanner scanner = new Scanner(System.in);

    void startTitle(String msg){
        System.out.println("[" + msg + "]=====================================");
    }

   int startSentence3(String msg1, String msg2, String msg3){
       System.out.print("1. " + msg1 + " 2. " + msg2 + " 3. " + msg3 + "\n숫자 입력 : ");

       int i = scanner.nextInt();

       System.out.print("\n");

       return i;
   }

    int startSentence4(String msg1, String msg2, String msg3, String msg4){
        System.out.print("1. " + msg1 + " 2. " + msg2 + " 3. " + msg3 + " 4. " + msg4 + "\n숫자 입력 : ");

        int i = scanner.nextInt();

        System.out.print("\n");

        return i;
    }


    boolean loop(String msg){
        System.out.print("\n"+ msg + " 없으면 -1, 있으면 아무 숫자 누르시오. : ");
        if (scanner.nextInt() == -1)
            return false;
        return true;
    }


}
