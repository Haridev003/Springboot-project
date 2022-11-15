package com.student.ust.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class StudentDTO {
    private int studentId;
    private String name;
    private int age;
    private  int rollNo;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
