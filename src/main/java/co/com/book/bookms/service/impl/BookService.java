package co.com.book.bookms.service.impl;

import co.com.book.bookms.domain.Book;
import co.com.book.bookms.repository.IBookRepository;
import co.com.book.bookms.service.IBookService;
import io.sentry.Sentry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService implements IBookService {

    private final IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book update(Book book) throws Exception {
        Book updatedBook = bookRepository.findById(book.getId()).orElse(null);

        if (updatedBook == null) {
            Exception exception = new Exception("Error, no existe el book con el id: " + book.getId());
            Sentry.captureException(exception);
            throw exception;
        }

        updatedBook.setTittle(book.getTittle());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setAvailability(book.isAvailability());
        bookRepository.save(updatedBook);
        return updatedBook;
    }


}
