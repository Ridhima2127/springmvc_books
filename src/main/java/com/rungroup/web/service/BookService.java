package com.rungroup.web.service;

import com.rungroup.web.dto.BookDto;
import com.rungroup.web.models.Book;

import java.util.List;

public interface BookService {
    List<BookDto> findAllBooks();


    Book saveBook(BookDto bookDto);

    BookDto findBookById(long bookId);



    void updateBook(BookDto book);

    void delete(Long bookId);

    List<BookDto> searchBooks(String query);
}
