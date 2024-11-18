package co.com.book.bookms.service;

import co.com.book.bookms.domain.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAll();
    Book findById(Long id);
    Book save(Book book);
}
