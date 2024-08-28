package com.LMSmanagement.libraryManagementSystem.Service;

import com.LMSmanagement.libraryManagementSystem.DTO.StudentRequestDto;
import com.LMSmanagement.libraryManagementSystem.DTO.StudentResponseDto;
import com.LMSmanagement.libraryManagementSystem.DTO.StudentUpdateEmailRequestDto;
import com.LMSmanagement.libraryManagementSystem.Entity.LibraryCard;
import com.LMSmanagement.libraryManagementSystem.Entity.Student;
import com.LMSmanagement.libraryManagementSystem.Enum.CardStatus;
import com.LMSmanagement.libraryManagementSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(StudentRequestDto studentRequestDto){
        // create student object;
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setEmail(studentRequestDto.getEmail());

        // create a card object;
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setStatus(CardStatus.ACTIVATED);
        libraryCard.setStudent(student) ;
        student.setCard(libraryCard);

        studentRepository.save(student);
    }

    public StudentResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){

        Student student = studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();
        student.setEmail(studentUpdateEmailRequestDto.getEmail());

        Student updatestudent = studentRepository.save(student);

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(updatestudent.getId());
        studentResponseDto.setName(updatestudent.getName());
        studentResponseDto.setEmail(updatestudent.getEmail());

        return studentResponseDto;
    }
}