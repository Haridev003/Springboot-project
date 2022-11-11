package com.student.ust.controller;

import com.student.ust.entity.Student;
import com.student.ust.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;
   @GetMapping("/student/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id){
    try {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    catch (NoSuchElementException e){
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);

    }

    }
    @GetMapping("/student/?")
    public ResponseEntity<Student> get2(@RequestParam Integer id){
        try {
            Student student = studentService.getStudentById(id);
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);

        }

    }
    @GetMapping("/student")
    public ResponseEntity<List<Student>> get2( ){
        try {
            List <Student> studentList = studentService.getStudentAll();
            return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);

        }

        }

      @DeleteMapping("/student/{id}")
      public void delete(@PathVariable  Integer id)
      {
          studentService.removeById(id);
      }


    @PostMapping("/student")
    public void add (  @RequestBody Student student){
      try {
           studentService.emailVaild(student.getEmail());
          studentService.saveStudent(student);
      } catch (Exception e) {

      }
    }

    @PutMapping("/student")
      public void update(@RequestBody Student student){
       Student updatedStudent = studentService.updateStudent(student);

    }

}
