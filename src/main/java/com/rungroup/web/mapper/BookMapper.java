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
                .createdBy(book.getCreatedBy())
                .createdOn(book.getCreatedOn())
                .updatedOn(book.getUpdatedOn())
                .build();
        return bookDto;
    }

    public static BookDto mapToBookDto(Book books){
        BookDto bookDto = BookDto.builder()
                .id(books.getId())
                .title(books.getTitle())
                .category(books.getCategory())
                .description(books.getDescription())
                .createdBy(books.getCreatedBy())
                .createdOn(books.getCreatedOn())
                .updatedOn(books.getUpdatedOn())
                .stories(books.getStories().stream().map(story -> mapToStoryDto(story)).collect(Collectors.toList()))
                .build();
        return bookDto;
    }


}
