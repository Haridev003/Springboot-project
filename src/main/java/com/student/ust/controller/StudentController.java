package com.student.ust.controller;

import com.student.ust.entity.Student;
import com.student.ust.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    public ResponseEntity<Student> get(@PathVariable Integer id){
    try {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    catch (NoSuchElementException e){
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);

    }
    }

}
