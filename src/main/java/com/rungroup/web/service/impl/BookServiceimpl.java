package com.rungroup.web.service.impl;

import com.rungroup.web.dto.BookDto;
import com.rungroup.web.models.book;
import com.rungroup.web.repository.BookRepository;
import com.rungroup.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

import com.rungroup.web.models.book;
@Service
public class BookServiceimpl implements BookService {

    private BookRepository bookRepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public BookServiceimpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> findAllBooks() {
        List<book> books = bookRepository.findAll();
        return books.stream().map((book) -> mapToBookDto(book)).collect(Collectors.toList());
    }

    @Override
    public Book save(Book book) {
        return bookRepository.saveBook(book);
    }

    @Override
    public void saveBook(Book book) {
        return bookRepository.save(book);

    }

//    @Override
//    public Book saveBook(Book book) {
//        return bookRepository.save(book);
//    }

    private BookDto mapToBookDto(book books){
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
