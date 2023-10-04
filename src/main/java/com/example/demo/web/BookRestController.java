package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookstoreRepo;


@CrossOrigin
@Controller

public class BookRestController {

    @Autowired
    private BookstoreRepo bookstoreRepo;

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> booklistrest() {	
        return (List<Book>) bookstoreRepo.findAll();
    }  
    
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findbookrest(@PathVariable("id") Long bookId) {	
        return bookstoreRepo.findById(bookId);
    }  
    }
