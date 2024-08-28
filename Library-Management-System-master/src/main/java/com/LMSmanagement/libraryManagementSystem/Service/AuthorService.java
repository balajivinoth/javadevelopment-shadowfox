package com.LMSmanagement.libraryManagementSystem.Service;

import com.LMSmanagement.libraryManagementSystem.Entity.Author;
import com.LMSmanagement.libraryManagementSystem.Entity.Book;
import com.LMSmanagement.libraryManagementSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void addAuthor(Author author){
        authorRepository.save(author);
    }
    public List<Author> getAuthor(){
        return authorRepository.findAll();
    }


}