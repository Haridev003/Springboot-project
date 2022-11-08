package com.student.ust.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name="student_mappedby")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String name;
    private int age;
    private  int rollNo;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

   /** @OneToOne
    @JoinColumn(name ="book_id")
    private Book book;*/
   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "student")
   // @JoinColumn(name="book_id")
    private Set<Book> book;

}
