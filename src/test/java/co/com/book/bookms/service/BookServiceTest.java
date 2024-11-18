package co.com.book.bookms.service;

import co.com.book.bookms.domain.Book;
import co.com.book.bookms.repository.IBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class BookServiceTest {

    @MockitoBean
    private IBookRepository bookRepository;

    @Test
    void findAll(){
        when(bookRepository.findAll()).thenReturn(new ArrayList<Book>());
        List<Book> books = bookRepository.findAll();
        Assertions.assertEquals( 0, books.size());
    }

}
