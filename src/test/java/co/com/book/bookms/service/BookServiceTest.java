package co.com.book.bookms.service;

import co.com.book.bookms.domain.Book;
import co.com.book.bookms.repository.IBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private IBookService bookService;

    @MockitoBean
    private IBookRepository bookRepository;

    @Test
    void shouldReturnAllBooks(){
        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        List<Book> books = bookService.findAll();
        Assertions.assertEquals( 0, books.size());
    }

    @Test
    void shouldReturnBookById(){
        Book book = new Book();
        book.setId(1L);
        book.setTittle("Test");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        Book bookAux = bookService.findById(1L);
        Assertions.assertEquals( book.getId(), bookAux.getId());
        Assertions.assertEquals( book.getTittle(), bookAux.getTittle());
    }

    @Test
    void shouldReturnBookSaved(){
        Book book = new Book();
        book.setTittle("Test");
        when(bookRepository.save(book)).thenReturn(book);
        Book bookAux = bookService.save(book);
        Assertions.assertEquals( book.getTittle(), bookAux.getTittle());
    }

    @Test
    void shouldDeleteABookById(){
        bookService.deleteById(1L);
        verify(bookRepository, times(1)).deleteById(1L);
    }

    @Test
    void shouldReturnBookUpdated(){
        Book book = new Book();
        book.setId(1L);
        book.setTittle("Test");

        Book updatedBook = new Book();
        updatedBook.setId(1L);
        updatedBook.setTittle("Updated");

        when(bookRepository.findById(1L)).thenReturn(Optional.of(updatedBook));
        Book bookAux = bookService.update(book);
        Assertions.assertEquals( book.getTittle(), bookAux.getTittle());
    }

    @Test
    void shouldReturnNullWhenBookNotUpdated(){
        Book book = new Book();
        book.setId(1L);
        book.setTittle("Test");

        Book updatedBook = new Book();
        updatedBook.setId(1L);
        updatedBook.setTittle("Updated");

        when(bookRepository.findById(1L)).thenReturn(Optional.empty());
        Book bookAux = bookService.update(book);
        Assertions.assertNull(bookAux);
    }
}
