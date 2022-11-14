package com.student.ust.service;

import com.student.ust.exception.InvalidException;
import com.student.ust.entity.Student;
import com.student.ust.respository.StudentRespository;
import com.student.ust.util.UstUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Student service.
 */
@Service
@Slf4j
public class StudentService {
    /**
     * The Student respository.
     */
    @Autowired
    StudentRespository studentRespository;

    /**
     * Gets student by id.
     *
     * @param id the id
     * @return the student by id
     */
//PasswordEncoder passwordEncoder;
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

    /**
     * Save student.
     *
     * @param student the student
     */
    public void saveStudent(Student student) {
        int  result= UstUtil.emailVaild(student.getEmail());
        int result2 = UstUtil.passwordValid(student.getPassword());
        if(result== 1 && result2==1){
            studentRespository.save(student);
        }
        else{
            throw  new InvalidException();
        }
        student.setCreatedDate(LocalDateTime.now());
        student.setModifiedDate(LocalDateTime.now());
        String enPass = null;
        try {
            enPass = UstUtil.toHexString(UstUtil.getSHA(student.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        student.setPassword(enPass);
        studentRespository.save(student);
    }

    /**
     * Gets student all.
     *
     * @return the student all
     */
    public List<Student> getStudentAll() {
        return studentRespository.findAll();
    }

    /**
     * Remove by id.
     *
     * @param id the id
     */
    public void removeById(Integer id) {
        studentRespository.deleteById(id);
    }

    /**
     * Update student student.
     *
     * @param student the student
     * @return the student
     */
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

    /**
     * Email vaild int.
     *
     * @param email the email
     * @return the int
     */






    /**
     * Password valid int.
     *
     * @param password the password
     * @return the int
     */

    // Criteria Criteria cr = session.createCriteria(Student.class);

}
