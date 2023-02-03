package com.rungroup.web.service;

import com.rungroup.web.dto.BookDto;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
    List<BookDto> findAllBooks();
    Book save(Book book);


    void saveBook(Book book);
}