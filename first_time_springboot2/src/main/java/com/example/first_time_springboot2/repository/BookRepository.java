package com.example.first_time_springboot2.repository;

import com.example.first_time_springboot2.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
