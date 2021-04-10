package com.example.first_time_springboot2.service;

import com.example.first_time_springboot2.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getBookList();
}
