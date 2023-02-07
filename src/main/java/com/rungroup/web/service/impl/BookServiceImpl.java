package com.rungroup.web.service.impl;

import com.rungroup.web.dto.BookDto;
import com.rungroup.web.models.Book;
import com.rungroup.web.repository.BookRepository;
import com.rungroup.web.service.BookService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static com.rungroup.web.mapper.BookMapper.mapToBook;
import static com.rungroup.web.mapper.BookMapper.mapToBookDto;

@Service
@Builder
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDto> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map((book) -> mapToBookDto(book)).collect(Collectors.toList());
    }


    @Override
    public Book saveBook(BookDto bookDto){
        Book book = mapToBook(bookDto);
        return bookRepository.save(book);
    }



    @Override
    public BookDto findBookById(long bookId) {
        Book book = bookRepository.findById(bookId).get();
        return mapToBookDto(book);
    }

    @Override
    public BookDto findBookById() {
        return null;
    }

    @Override
    public void updateBook(BookDto bookDto) {
        Book book = mapToBook(bookDto);
        bookRepository.save(book);
    }

    @Override
    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public List<BookDto> searchBooks(String query) {
        List<Book> books = bookRepository.searchBooks(query);
        return books.stream().map(book -> mapToBookDto(book)).collect(Collectors.toList());
    }


}
