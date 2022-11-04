package com.student.ust.service;

import com.student.ust.entity.Student;
import com.student.ust.respository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
      @Autowired
    StudentRespository studentRespository;
    public Student getStudentById(Integer id) {

        return studentRespository.findById(id).orElse(null);
    }

    public void saveStudent(Student student) {
        studentRespository.save(student);
    }

    public List<Student> getStudentAll() {
        return studentRespository.findAll();
    }

    public void removeById(Integer id) {
        studentRespository.deleteById(id);
    }
}
