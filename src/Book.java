import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
    String bookTitle;
    String author;
    String genre;
    String date;

    public Book(String bookTitle, String author, String genre, String date) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.date = date;

    }
}
