package com.example.first_time_springboot2.controller;

import com.example.first_time_springboot2.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getBookList(Model model) {
        System.out.println("==빈 주입======================"+bookService);
        model.addAttribute("bookList", bookService.getBookList());
        return "book";
    }


}
