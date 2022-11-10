package com.student.ust.respository;

import com.student.ust.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository extends
        JpaRepository<Student,Integer> {
Student findByName(String name);





}
