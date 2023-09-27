package com.example.demo.web;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookstoreRepo;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookstoreRepo bookStoreRepo;

    @Autowired
    private CategoryRepo categoryRepo; 

    @GetMapping("/bookstore")
    public String bookList(Model model) {
        List<Book> books = (List<Book>) bookStoreRepo.findAll();
        model.addAttribute("books", books);
        return "bookstore";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryRepo.findAll());

        return "addbook";
    }

    @PostMapping("/save")
    public String addBookSubmit(@ModelAttribute Book book) {
        bookStoreRepo.save(book);
        return "redirect:/bookstore";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookStoreRepo.deleteById(id);
        return "redirect:/bookstore";
    }
}


