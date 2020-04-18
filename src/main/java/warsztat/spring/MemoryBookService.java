package warsztat.spring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService {
    private List<Book> bookList;


    public MemoryBookService() {
        bookList = new ArrayList<>();
        bookList.add(new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming"));
        bookList.add(new Book(2L, "9788324627738", "Rusz głową, java",
                "Sierra kathy", "Helion", "programming"));
        bookList.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public Book getBookFromList(Long id) {
        return bookList.get(Math.toIntExact(id - 1));
    }

    public boolean addBook(Book book){
        return bookList.add(book);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void update(Book book){

        Book book1 = bookList.get(Math.toIntExact(book.getId()));

        book1.setAuthor(book.getAuthor());
        book1.setIsbn(book.getIsbn());
        book1.setPublisher(book.getPublisher());
        book1.setTitle(book.getTitle());
        book1.setType(book.getType());

    }
}
