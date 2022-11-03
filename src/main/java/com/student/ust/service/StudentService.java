package com.student.ust.service;

import com.student.ust.entity.Student;
import com.student.ust.respository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
      @Autowired
    StudentRespository studentRespository;
    public Student getStudentById(Integer id) {

        return studentRespository.findById(id).orElse(null);
    }
}
