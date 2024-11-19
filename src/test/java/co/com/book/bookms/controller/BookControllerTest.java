package co.com.book.bookms.controller;

import co.com.book.bookms.domain.Book;
import co.com.book.bookms.service.IBookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IBookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnBooksStatus() throws Exception {
        when(bookService.findAll()).thenReturn(new ArrayList<Book>());
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void shouldReturnBookByIdStatus() throws Exception {
        when(bookService.findById(1L)).thenReturn(new Book());
        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void shouldReturnBookSaved() throws Exception {
        Book book = new Book();
        book.setTittle("Test");
        book.setAuthor("Test");
        book.setAvailability(true);
        when(bookService.save(book)).thenReturn(book);
        mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void shouldReturn200WhenDeleteBook() throws Exception {
        mockMvc.perform(delete("/api/books/1"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnBookUpdated() throws Exception {
        Book book = new Book();
        book.setTittle("Test");
        book.setAuthor("Test");
        book.setAvailability(true);

        Book updatedBook = new Book();
        updatedBook.setTittle("Updated");
        when(bookService.save(book)).thenReturn(book);
        when(bookService.findById(1L)).thenReturn(updatedBook);
        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
