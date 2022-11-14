package com.student.ust.controller;

import com.student.ust.exception.BussinessException;
import com.student.ust.entity.Student;
import com.student.ust.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Student controller.
 */
@RestController
public class StudentController {

    /**
     * The Student service.
     */
    @Autowired
    StudentService studentService;


    /**
     * Get response entity.
     *
     * @param id the id
     * @return the response entity
     */
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

    /**
     * Get 2 response entity.
     *
     * @param id the id
     * @return the response entity
     */
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

    /**
     * Get 2 response entity.
     *
     * @return the response entity
     */
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

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/student/{id}")
      public void delete(@PathVariable  Integer id)
      {
          studentService.removeById(id);
      }


    /**
     * Add response entity.
     *
     * @param student the student
     * @return the response entity
     */
    @PostMapping("/student")
    public ResponseEntity<Student> add (  @RequestBody Student student){
      try {

          studentService.saveStudent(student);


           return  new ResponseEntity<Student>(student,HttpStatus.OK);

      } catch (BussinessException e) {
          return  new ResponseEntity<Student>(student,HttpStatus.PRECONDITION_FAILED);
      }
    }

    /**
     * Update.
     *
     * @param student the student
     */
    @PutMapping("/student")
      public void update(@RequestBody Student student){
       Student updatedStudent = studentService.updateStudent(student);

    }

}
