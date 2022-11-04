package com.student.ust.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String name;
    private int age;
    private  int rollNo;

   /** @OneToOne
    @JoinColumn(name ="book_id")
    private Book book;*/
   @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

}
