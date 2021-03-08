import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;

public class BookManager {

    Scanner scanner = new Scanner(System.in);
    TreeMap<Integer, Book> map = new TreeMap<Integer, Book>();

    Utill utill = new Utill();
    public void start() {

        utill.startTitle("도서 관리");

        map.put(1, new Book("830.72ㅇ","연금술사", "파울로 코엘료", "소설", "1987-01-01" ));

        while (true) {
            int i = utill.startSentence4("도서 등록", "도서 수정", "도서 삭제","도서 검색");

            move(i);

            showValue();

            if(utill.loop("추가로 도서 관리하겠습니까?") == false)
                return;
        }


    }

    private void showValue() {

        System.out.println("도서DB");
        System.out.println("\n번호\t\t분류코드\t\t제목\t\t저자\t\t장르\t\t출판일");

        for (int key : map.keySet()) {
            String code = map.get(key).code;
            String title = map.get(key).title;
            String author = map.get(key).author;
            String genre = map.get(key).genre;
            String date = map.get(key).date;

            System.out.println(key + "\t\t" + code + "\t\t" + title + "\t\t" + author + "\t\t" + genre + "\t\t" + date);

        }
    }

    private void move(int i) {
        switch (i) {
            case 1:
                insertBook();
                break;
            case 2:
                updateBook();
                break;
            case 3:
                deleteBook();
                break;
            case 4:
                searchBook();
                break;
        }
    }

    private void insertBook() {
        while (true) {

            System.out.print("분류코드 : ");
            String code = scanner.next();

            System.out.print("제목 : ");
            String title = scanner.next();

            System.out.print("저자 : ");
            String author = scanner.next();

            System.out.print("장르 : ");
            String genre = scanner.next();

            System.out.print("출판일 : ");
            String date = scanner.next();


            int key;
            switch (map.size()){
                case 0 :
                    key = 1;
                    break;
                default:
                    key = map.lastKey() + 1;
                    break;
            }
            map.put(key, new Book(code, title, author, genre, date));

            if (utill.loop("더 등록할 도서가 있습니까?") == false)
                return;
        }

    }

    private void updateBook() {
        while (true) {

            showValue();
            System.out.print("수정할 도서 번호를 입력하시오. : ");
            int key = scanner.nextInt();

            System.out.print("수정할 도서 정보를 입력하시오. \n1. 분류코드   2. 제목   3. 저자   4. 장르   5. 출판일  : ");
            int num = scanner.nextInt();

            switch (num){
                case 1:
                    System.out.print("분류코드 : ");
                    map.get(key).code = scanner.next();
                    break;
                case 2:
                    System.out.print("제목 : ");
                    map.get(key).title = scanner.next();
                    break;
                case 3:
                    System.out.print("저자 : ");
                    map.get(key).author = scanner.next();
                    break;
                case 4:
                    System.out.print("장르 : ");
                    map.get(key).genre = scanner.next();
                    break;
                case 5:
                    System.out.print("출판일 : ");
                    map.get(key).date = scanner.next();
                    break;

            }


            if (utill.loop("추가로 수정할 도서가 있습니까?") == false)
                return;

        }
    }

    private void deleteBook() {
        while (true){
            showValue();
            System.out.print("삭제할 도서 번호를 입력하시오. : ");
            int key = scanner.nextInt();

            map.remove(key);




            if (utill.loop("추가로 삭제할 도서가 있습니까?") == false)
                return;
        }
    }

    private void searchBook() {
        while (true){
            System.out.print("검색할 도서 제목을 입력하시오. : ");
            String name = scanner.next();

            for (int key : map.keySet()) {
                if (name.equals(map.get(key).title)) {
                    System.out.println("\n번호\t\t분류코드\t\t제목\t\t저자\t\t장르\t\t출판일");
                    System.out.println(key + "\t\t" + map.get(key).code + "\t\t" + map.get(key).title + "\t\t" + map.get(key).author + "\t\t" + map.get(key).genre + "\t\t" + map.get(key).date);

                }
            }

            if (utill.loop("추가로 검색할 도서가 있습니까?") == false)
                return;
        }
    }

}
