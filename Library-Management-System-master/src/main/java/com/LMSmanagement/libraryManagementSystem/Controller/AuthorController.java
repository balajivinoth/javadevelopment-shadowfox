package com.LMSmanagement.libraryManagementSystem.Controller;

import com.LMSmanagement.libraryManagementSystem.Entity.Author;
import com.LMSmanagement.libraryManagementSystem.Entity.Book;
import com.LMSmanagement.libraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        return "Author Added";
    }
    @GetMapping()
    public List<Author> getAuthor(){
        return authorService.getAuthor();
    }
}