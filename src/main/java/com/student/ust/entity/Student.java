package com.student.ust.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name="student_mappedby")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int studentId;
    private String name;
    private int age;
    private  int rollNo;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    //@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",flags = Pattern.Flag.CASE_INSENSITIVE)
    private String  email;
    @NonNull
    private String password;

   /** @OneToOne
    @JoinColumn(name ="book_id")
    private Book book;*/
   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "student")
   // @JoinColumn(name="book_id")
    private Set<Book> book;

}
