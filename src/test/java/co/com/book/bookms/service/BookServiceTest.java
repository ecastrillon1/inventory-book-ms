package co.com.book.bookms.service;

import co.com.book.bookms.domain.Book;
import co.com.book.bookms.repository.IBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {

    @MockitoBean
    private IBookRepository bookRepository;

    @Test
    void shouldReturnAllBooks(){
        when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        List<Book> books = bookRepository.findAll();
        Assertions.assertEquals( 0, books.size());
    }

    @Test
    void shouldReturnBookById(){
        Book book = new Book();
        book.setId(1L);
        book.setTittle("Test");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        Book bookAux = bookRepository.findById(1L).orElse(new Book());
        Assertions.assertEquals( book.getId(), bookAux.getId());
        Assertions.assertEquals( book.getTittle(), bookAux.getTittle());
    }

    @Test
    void shouldReturnBookSaved(){
        Book book = new Book();
        book.setTittle("Test");
        when(bookRepository.save(book)).thenReturn(book);
        Book bookAux = bookRepository.save(book);
        Assertions.assertEquals( book.getTittle(), bookAux.getTittle());
    }

}
