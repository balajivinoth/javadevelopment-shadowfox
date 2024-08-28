package com.LMSmanagement.libraryManagementSystem.DTO;

import com.LMSmanagement.libraryManagementSystem.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDto {
    private String title;
    private int price;
    private Genre genre;
    private int authorId;

}