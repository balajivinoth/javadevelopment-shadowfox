package com.LMSmanagement.libraryManagementSystem.Service;

import com.LMSmanagement.libraryManagementSystem.DTO.IssueBookRequestDto;
import com.LMSmanagement.libraryManagementSystem.DTO.IssueBookResponseDto;
import com.LMSmanagement.libraryManagementSystem.Entity.Book;
import com.LMSmanagement.libraryManagementSystem.Entity.LibraryCard;
import com.LMSmanagement.libraryManagementSystem.Entity.Transaction;
import com.LMSmanagement.libraryManagementSystem.Enum.CardStatus;
import com.LMSmanagement.libraryManagementSystem.Enum.TransactionStatus;
import com.LMSmanagement.libraryManagementSystem.Repository.BookRepository;
import com.LMSmanagement.libraryManagementSystem.Repository.CardRepository;
import com.LMSmanagement.libraryManagementSystem.Repository.TransactionRepository;
import com.LMSmanagement.libraryManagementSystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    TransactionRepository transactionRespository;
    public IssueBookResponseDto issuebook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction = new Transaction();
        transaction.setTransactionumber(String.valueOf(UUID.randomUUID()));
        transaction.setIsissuedOperation(true);

        LibraryCard libraryCard;
        try {
            libraryCard = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Card not found");
            transactionRespository.save(transaction);
            throw new Exception("Card not present");
        }
        Book book;
        try {
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Book not found");
            transactionRespository.save(transaction);
            throw new Exception("Book not found");
        }
        transaction.setBook(book);
        transaction.setCard(libraryCard);
        if(libraryCard.getStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Your card is not activated");
            transactionRespository.save(transaction);
            throw new Exception("Your card is not activated");
        }
        if(book.isIsissued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Sorry book is already issue");
            transactionRespository.save(transaction);
            throw new Exception("Sorry book is already issue");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transaction was successful");
        book.setIsissued(true);
        book.setCard(libraryCard);
        book.getTransaction().add(transaction);
        libraryCard.getTransaction().add(transaction);
        libraryCard.getBookIssued().add(book);

        cardRepository.save(libraryCard);

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setTransactionId(transaction.getTransactionumber());
        issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        issueBookResponseDto.setBookName(book.getTitle());

        return issueBookResponseDto;


    }

}