package com.example.demo.web;

import com.example.demo.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/bookstore")
    public String index(Model model) {
        
        return "bookstore";
    }
}
