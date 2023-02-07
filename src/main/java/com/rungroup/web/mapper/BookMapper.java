package com.rungroup.web.mapper;

import com.rungroup.web.dto.BookDto;
import com.rungroup.web.models.Book;

public class BookMapper {
    public static Book mapToBook(BookDto book) {
        Book bookDto = Book.builder().id(book.getId()).title(book.getTitle()).build();
        return bookDto;
    }

    public static BookDto mapToBookDto(Book books){
        BookDto bookDto = BookDto.builder()
                .id(books.getId())
                .title(books.getTitle())
                .category(books.getCategory())
                .description(books.getDescription())
                .createdOn(books.getCreatedOn())
                .updatedOn(books.getUpdatedOn())

                .build();
        return bookDto;
    }

}
