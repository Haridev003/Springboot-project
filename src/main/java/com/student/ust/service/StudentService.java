package com.student.ust.service;

import com.student.ust.entity.Student;
import com.student.ust.respository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {
      @Autowired
    StudentRespository studentRespository;
    public Student getStudentById(Integer id) {

        return studentRespository.findById(id).orElse(null);
    }

    public void saveStudent(Student student) {
        student.setCreatedDate(LocalDate.now());
        student.setModifiedDate(LocalDate.now());
        studentRespository.save(student);
    }

    public List<Student> getStudentAll() {
        return studentRespository.findAll();
    }

    public void removeById(Integer id) {
        studentRespository.deleteById(id);
    }
     public Student updateStudent(Student student){
        Student updateStudent = studentRespository.findById(student.getStudentId()).orElseThrow(()->
                new NoSuchElementException());
        updateStudent.setName(student.getName());
        updateStudent.setAge(student.getAge());
        updateStudent.setRollNo(student.getRollNo());
         updateStudent.setModifiedDate(LocalDate.now());
        studentRespository.save(updateStudent);

        return updateStudent;


     }
}
