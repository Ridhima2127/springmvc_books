package com.rungroup.web.service.impl;

import com.rungroup.web.dto.BookDto;
import com.rungroup.web.dto.StoryDto;
import com.rungroup.web.models.Book;
import com.rungroup.web.models.Story;
import com.rungroup.web.models.UserEntity;
import com.rungroup.web.repository.BookRepository;
import com.rungroup.web.repository.StoryRepository;
import com.rungroup.web.repository.UserRepository;
import com.rungroup.web.security.SecurityUtil;
import com.rungroup.web.service.BookService;
import com.rungroup.web.service.StoryService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import static com.rungroup.web.mapper.BookMapper.mapToBook;
import static com.rungroup.web.mapper.BookMapper.mapToBookDto;
import static com.rungroup.web.mapper.StoryMapper.mapToStory;
import static com.rungroup.web.mapper.StoryMapper.mapToStoryDto;

@Service
@Builder
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private UserRepository userRepository;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<BookDto> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map((book) -> mapToBookDto(book)).collect(Collectors.toList());
    }


    @Override
    public Book saveBook(BookDto bookDto) {
        String username = SecurityUtil.getSessionUser();
        UserEntity user= userRepository.findByUsername(username);
        Book book = mapToBook(bookDto);
        book.setCreatedBy(user);
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
        String username = SecurityUtil.getSessionUser();
        UserEntity user= userRepository.findByUsername(username);
        Book book = mapToBook(bookDto);
        book.setCreatedBy(user);
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



