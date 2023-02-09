package com.rungroup.web.repository;

import com.rungroup.web.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
Optional<Book> findByTitle(String url);
@Query("SELECT b from Book b WHERE b.title LIKE CONCAT('%', :query, '%')")
List<Book> searchBooks(String query);

}
