package com.example.bookmanager.dao;

import com.example.bookmanager.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {
}
