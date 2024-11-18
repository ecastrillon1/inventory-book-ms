package co.com.book.bookms.repository;

import co.com.book.bookms.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();
}
