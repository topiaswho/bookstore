package com.example.demo.web;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookstoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookstoreRepo bookstorerepo;

    @GetMapping("/bookstore")
    public String bookList(Model model) {
        List<Book> books = (List<Book>) bookstorerepo.findAll();
        model.addAttribute("books", books);
        return "bookstore";
    }
    @GetMapping("/addbook")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/addbook")
    public String addBookSubmit(@ModelAttribute Book book) {
        bookstorerepo.save(book);
        return "redirect:/bookstore";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookstorerepo.deleteById(id);
        return "redirect:/bookstore";
    }
}
