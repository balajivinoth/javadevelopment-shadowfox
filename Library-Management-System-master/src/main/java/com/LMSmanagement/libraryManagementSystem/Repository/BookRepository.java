package com.LMSmanagement.libraryManagementSystem.Repository;

import com.LMSmanagement.libraryManagementSystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}