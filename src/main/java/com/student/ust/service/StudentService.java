package com.student.ust.service;

import com.student.ust.entity.Student;
import com.student.ust.respository.StudentRespository;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StudentService {
      @Autowired
    StudentRespository studentRespository;
    public Student getStudentById(Integer id) {
        Student studentById = studentRespository.findById(id).orElseThrow(()-> new NoSuchElementException());
       // getByName(studentById.getName());
        return studentById;
        //return studentRespository.findById(id).orElse(null);
    }

    private void getByName(String name) {
        Student studentByName = studentRespository.findByName(name);
        System.out.printf(" Student Name is>>>    "+studentByName.getName());
        System.out.printf(" Student roll number >>>  "+studentByName.getRollNo());
    }

    public void saveStudent(Student student) {
        student.setCreatedDate(LocalDateTime.now());
        student.setModifiedDate(LocalDateTime.now());
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
         updateStudent.setModifiedDate(LocalDateTime.now());
        studentRespository.save(updateStudent);

        return updateStudent;


     }

    public void emailVaild(String email) {
        String regex = "\"^([A-Z a-z 0-9+_.-]+)@([A-Z a-z 0-9]+)\\\\.([a-z]+)$\"";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        matcher.matches();


    }
    // Criteria Criteria cr = session.createCriteria(Student.class);

}
