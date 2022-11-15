package com.student.ust.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The type Book.
 */
@Entity
@Data
@Table(name="book_mappedby")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
     private int bookId;
    private String bookName;
    private  String authorName;
    private  int isbNo;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    /**
     * The Student.
     */
    @ManyToOne
    @JoinColumn(name = "student_id")
     Student student;
}
