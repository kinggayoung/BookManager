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

        map.put(1, new Book("연금술사", "파울로 코엘료", "소설", "1987-01-01" ));

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
        System.out.println("\n번호\t\t제목\t\t저자\t\t장르\t\t출판일");

        for (int key : map.keySet()) {
            String name = map.get(key).bookTitle;
            String author = map.get(key).author;
            String genre = map.get(key).genre;
            String date = map.get(key).date;

            System.out.println(key + "\t\t" + name + "\t\t" + author + "\t\t" + genre + "\t\t" + date);

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
    }

    private void updateBook() {
    }

    private void deleteBook() {
    }

    private void searchBook() {
    }

}
