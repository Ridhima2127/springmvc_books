package com.rungroup.web.mapper;

import com.rungroup.web.dto.BookDto;
import com.rungroup.web.models.Book;
import com.rungroup.web.models.Story;

import java.util.stream.Collectors;

import static com.rungroup.web.mapper.StoryMapper.mapToStoryDto;

public class BookMapper {
    public static Book mapToBook(BookDto book) {
        Book bookDto = Book.builder()
                .id(book.getId())
                .title(book.getTitle())
                .photoURL(book.getPhotoURL())
                .content(book.getContent())
                .createdOn(book.getCreatedOn())
                .updatedOn(book.getUpdatedOn())
                .build();
        return bookDto;
    }

    public static BookDto mapToBookDto(Book book){
        BookDto bookDto = BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .photoURL(book.getPhotoURL())
                .content(book.getContent())
                .createdBy(book.getCreatedBy())
                .createdOn(book.getCreatedOn())
                .updatedOn(book.getUpdatedOn())
                .build();
        return bookDto;
    }


}
