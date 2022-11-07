package com.student.ust.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int bookId;
    private String bookName;
    private  String authorName;
    private  int isbNo;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
  @ManyToOne
    @JoinColumn(name = "student_id")
     Student student;
}
