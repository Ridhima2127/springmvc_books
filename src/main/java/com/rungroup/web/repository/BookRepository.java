package com.rungroup.web.repository;

import com.rungroup.web.models.book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.Optional;

public interface BookRepository extends JpaRepository<book, Long> {
Optional<book> findByTitle(String url);



    Book saveBook(Book book);
}
