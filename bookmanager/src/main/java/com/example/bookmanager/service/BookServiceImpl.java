package com.example.bookmanager.service;

import com.example.bookmanager.dao.BookRepository;
import com.example.bookmanager.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    @Override
    public Book getBook(int id) {
        Book book = null;
        Optional<Book> bookAsOptional = bookRepository.findById(id);
        if(bookAsOptional.isPresent()){
            book = bookAsOptional.get();
        }
        return book;

    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);

    }


    @Override
    public void addOrUpdateBook(Book book) {
        bookRepository.save(book);
    }
}
