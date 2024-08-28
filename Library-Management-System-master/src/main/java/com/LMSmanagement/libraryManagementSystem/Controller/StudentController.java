package com.LMSmanagement.libraryManagementSystem.Controller;

import com.LMSmanagement.libraryManagementSystem.DTO.StudentRequestDto;
import com.LMSmanagement.libraryManagementSystem.DTO.StudentResponseDto;
import com.LMSmanagement.libraryManagementSystem.DTO.StudentUpdateEmailRequestDto;
import com.LMSmanagement.libraryManagementSystem.Entity.Student;
import com.LMSmanagement.libraryManagementSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        studentService.addStudent(studentRequestDto);
        return "Student Added";
    }


    @PutMapping("/update_email")
    public StudentResponseDto updateEmail(@RequestBody StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        return studentService.updateEmail(studentUpdateEmailRequestDto);
    }

}