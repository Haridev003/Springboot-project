package com.student.ust.entity;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tutorId;
    private String tutorName;
    //private  String subjectName;

    @ManyToMany(cascade =  CascadeType.ALL)
    List<Student> student;

}
