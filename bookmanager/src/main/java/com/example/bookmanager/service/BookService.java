package com.example.bookmanager.service;

import com.example.bookmanager.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAllBooks();

    public Book getBook(int id);

    public void deleteBook(int id);


    public void addOrUpdateBook(Book book);

}
