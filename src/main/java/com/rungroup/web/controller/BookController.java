package com.rungroup.web.controller;


import com.rungroup.web.dto.BookDto;
import com.rungroup.web.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.awt.print.Book;
import java.util.List;

@Controller
public class BookController {
    private  BookService bookService;

    @Autowired
    public BookController(BookService bookService){
          this.bookService = bookService;
    }

    @GetMapping("/books")
    public String listBooks(Model model){
       List<BookDto> books = bookService.findAllBooks();
       model.addAttribute( "books", books);
       return "books-list";

    }


    @GetMapping("/books/new")
    public String createBookForm(Model model){
        Book book= new Book();
        model.addAttribute("book", book);
        return "books-create";
    }


    @PostMapping("/books/new")
    public String saveBook(@ModelAttribute("book") Book book){
    bookService.saveBook(book);
    return "redirect:/books";
    }
}
