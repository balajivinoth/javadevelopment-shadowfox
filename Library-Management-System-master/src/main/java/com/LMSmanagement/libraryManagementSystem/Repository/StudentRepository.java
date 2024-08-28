package com.LMSmanagement.libraryManagementSystem.Repository;

import com.LMSmanagement.libraryManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

}