import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
    String code;
    String title;
    String author;
    String genre;
    String date;

    public Book(String code, String title, String author, String genre, String date) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.date = date;

    }
}
