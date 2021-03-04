import java.util.Scanner;
import java.util.TreeMap;

public class UserManager {
    Scanner scanner;
    TreeMap<Integer, User> map = new TreeMap<Integer, User>();

    public void start() {
        scanner = new Scanner(System.in);
        System.out.println("[사용자 관리]=====================================\n");

        while (true) {
            System.out.print("1. 사용자 등록   2. 사용자 수정  3. 사용자 삭제  4. 사용자 검색\n숫자 입력 : ");

            int i = scanner.nextInt();

            System.out.print("\n");

            map.put(1, new User("김가영", 21, 'W'));
            move(i);

            showValue();

            if(loop("추가로 사용자 관리하겠습니까?") == false)
                return;
        }


    }

    private void showValue() {
        System.out.println("사용자DB");
        for (int key : map.keySet()) {
            String name = map.get(key).name;
            int age = map.get(key).age;
            char gender = map.get(key).gender;

            System.out.println("\n번호\t\t이름\t\t나이\t\t성별");
            System.out.println(key + "\t\t" + name + "\t\t" + age + "\t\t" + gender );
        }
    }

    private void move(int i) {
        switch (i) {
            case 1:
                userInsert();
                break;
            case 2:
                userUpdate();
                break;
            case 3:
                userDelete();
                break;
            case 4:
                userSearch();
                break;
        }
    }


    private void userInsert() {


        while (true) {

            System.out.print("이름 : ");
            String name = scanner.next();

            System.out.print("나이 : ");
            int age = scanner.nextInt();

            System.out.print("성별 : ");
            char gender = scanner.next().charAt(0);

            map.put(map.lastKey() + 1, new User(name, age, gender));

            if (loop("더 등록할 사용자가 있습니까?") == false)
                return;
        }
    }

    private void userUpdate() {
        while (true) {

            showValue();
            System.out.print("수정할 사용자 번호를 입력하시오. : ");
            int key = scanner.nextInt();

            System.out.println("\n정보를 입력하시오.");

            System.out.print("이름 : ");
            map.get(key).name = scanner.next();

            System.out.print("나이 : ");
            map.get(key).age = scanner.nextInt();

            System.out.print("성별 : ");
            map.get(key).gender = scanner.next().charAt(0);



            if (loop("추가로 수정할 사용자가 있습니까?") == false)
                return;

        }

    }

    private void userDelete() {
        while (true){
            showValue();
            System.out.print("삭제할 사용자 번호를 입력하시오. : ");
            int key = scanner.nextInt();

            map.remove(key);


            if (loop("추가로 삭제할 사용자가 있습니까?") == false)
                return;
        }
    }

    private void userSearch() {
        while (true){
            System.out.print("검색할 사용자 이름을 입력하시오. : ");
            String name = scanner.next();

            for (int key : map.keySet()) {
                if (name.equals(map.get(key).name)) {
                    System.out.println("\n번호\t\t이름\t\t나이\t\t성별");
                    System.out.println(key + "\t\t" + map.get(key).name + "\t\t" + map.get(key).age + "\t\t" + map.get(key).gender );
                }
            }

            if (loop("추가로 검색할 사용자가 있습니까?") == false)
                return;
        }
    }

    private boolean loop(String msg){
        System.out.print("\n"+ msg + " 없으면 -1, 있으면 아무 키나 누르시오. : ");
        if (scanner.nextInt() == -1)
            return false;
        return true;
    }

}
