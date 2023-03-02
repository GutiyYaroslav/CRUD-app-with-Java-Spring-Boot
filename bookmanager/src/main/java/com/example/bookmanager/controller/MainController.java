package com.example.bookmanager.controller;

import com.example.bookmanager.model.Book;
import com.example.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private BookService bookService;


//    @GetMapping("/")
//    public String responseWelcome(){
//        return "welcome";
//    }

    @GetMapping("/books")
    public String listBooks(Model model){
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("book", new Book("","", 0));
        model.addAttribute("listBooks", books);
        return "books";
    }


    @PostMapping("/books/add")
    public String addBook(@ModelAttribute("book") Book book){
        bookService.addOrUpdateBook(book);
        return "redirect:/books";
    }

    @RequestMapping("remove/{id}")
    public String removeBook(@PathVariable("id")int id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookService.getBook(id));
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "books";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookService.getBook(id));
        return "bookdata";
    }

    //****************************************************************
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
