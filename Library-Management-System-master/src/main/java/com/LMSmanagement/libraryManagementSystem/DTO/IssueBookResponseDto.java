package com.LMSmanagement.libraryManagementSystem.DTO;

import com.LMSmanagement.libraryManagementSystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {
    private String transactionId;
    private String bookName;
    private TransactionStatus transactionStatus;
}