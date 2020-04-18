package warsztat.spring;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
W odróżnieniu do MVC dodaliśmy adnotację @RestController - jest to połączenie znanych nam
adnotacji: @ResponseBody i @Controller.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private final List<Book> bookList;

    public BookController(List<Book> bookList) {
        this.bookList = bookList;
    }

    @GetMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "123213",
                "Thinking in Java", "Bruce Eckel", "Helion", "programing");
    }

    @RequestMapping("/allBooks")
    public List<Book> book(MemoryBookService memoryBookService) {
        return memoryBookService.getBookList();
    }

    @RequestMapping("/getBookById/{id}")
    public Book getBook(MemoryBookService memoryBookService,@PathVariable Long id) {
        return memoryBookService.getBookFromList(id);
    }


    @PostMapping
    public void addBook(@RequestBody Book book) {
       bookList.add(book);
    }
}
