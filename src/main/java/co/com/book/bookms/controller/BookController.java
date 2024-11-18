package co.com.book.bookms.controller;

import co.com.book.bookms.domain.Book;
import co.com.book.bookms.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
