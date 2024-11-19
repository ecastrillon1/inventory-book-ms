package co.com.book.bookms.controller;

import co.com.book.bookms.domain.Book;
import co.com.book.bookms.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
@AllArgsConstructor
public class BookController {

    private final IBookService bookService;

    @GetMapping
    List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    Book findById(@PathVariable Long id){
        return bookService.findById(id);
    }

    @PostMapping
    Book save(@RequestBody Book book){
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
        bookService.deleteById(id);
    }
}
