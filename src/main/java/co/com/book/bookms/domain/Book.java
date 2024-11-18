package co.com.book.bookms.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "book_book_id_seq", sequenceName = "book_book_id_seq", allocationSize = 1)
    private Long id;

    @Column
    private String tittle;

    @Column
    private String author;

    @Column
    private boolean availability;

}
