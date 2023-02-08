package com.rungroup.web.controller;


import com.rungroup.web.dto.BookDto;
import com.rungroup.web.models.UserEntity;
import com.rungroup.web.security.SecurityUtil;
import com.rungroup.web.service.BookService;
import com.rungroup.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;

@Controller
public class BookController {
    private  BookService bookService;

    private UserService userService;
    @Autowired
    public BookController(BookService bookService, UserService userService){
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String listBooks(Model model){
        UserEntity user = new UserEntity();
       List<BookDto> books = bookService.findAllBooks();
       String username = SecurityUtil.getSessionUser();
       if(username != null){
           user = userService.findByUsername(username);
           model.addAttribute("user",user);
       }
        model.addAttribute("user",user);
       model.addAttribute( "books", books);
       return "books-list";

    }

    @GetMapping("/books/{bookId}")
    public String bookDetail(@PathVariable("bookId") long bookId, Model model){
        UserEntity user = new UserEntity();
        BookDto bookDto = bookService.findBookById(bookId);
        model.addAttribute("book", bookDto);
        String username = SecurityUtil.getSessionUser();
        if(username != null){
            user = userService.findByUsername(username);
            model.addAttribute("user",user);
        }
        model.addAttribute("user",user);
        return "books-detail";
    }



    @GetMapping("/books/new")
    public String createBookForm(Model model){
        Book book= new Book();
        model.addAttribute("book", book);
        return "books-create";
    }

    @GetMapping("/books/{bookId}/delete")
    public String deleteBook(@PathVariable("bookId") Long bookId){
        bookService.delete(bookId);
        return "redirect:/books";
    }

    @GetMapping("/books/search")
    public String searchBook(@RequestParam(value="query") String query, Model model){
        List<BookDto> books = bookService.searchBooks(query);
        model.addAttribute("books", books);
        return "books-list";
    }

    @PostMapping("/books/new")
    public String saveBook(@Valid @ModelAttribute("book") BookDto bookDto, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("book", bookDto);
            return "books-create";
        }

        bookService.saveBook(bookDto);
    return "redirect:/books";
    }


    @GetMapping("/books/{bookId}/edit")
    public String editBookForm(@PathVariable("bookId")long bookId, Model model){
        BookDto book = bookService.findBookById(bookId);
        model.addAttribute("book", book );
        return "books-edit";
    }

    @PostMapping("/books/{bookId}/edit")
    public String updateBook(@PathVariable("bookId") Long bookId, @Valid @ModelAttribute("book") BookDto Book, BindingResult result){
        if(result.hasErrors()){
            return "books-create";
        }

        Book.setId(bookId);
        bookService.updateBook(Book);
        return "redirect:/books";
    }





}
