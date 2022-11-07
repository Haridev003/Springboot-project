package com.student.ust.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private int bookId;
    private String bookName;
    private  String authorName;
    private  int isbNo;
    private LocalDate createdDate;
    private LocalDate ModifiedDate;
 /**  @OneToMany
    @JoinColumn(name = "student_id")
    private Student1 student;*/
}
