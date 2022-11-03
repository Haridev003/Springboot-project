package com.student.ust.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private int age;

}
