package com.LMSmanagement.libraryManagementSystem.Controller;

import com.LMSmanagement.libraryManagementSystem.DTO.BookRequestDto;
import com.LMSmanagement.libraryManagementSystem.DTO.BookResponseDto;
import com.LMSmanagement.libraryManagementSystem.Entity.Book;
import com.LMSmanagement.libraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto){
        return bookService.addBook(bookRequestDto);
    }
}