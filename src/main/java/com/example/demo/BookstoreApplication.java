package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookstoreRepo;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepo;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner categorydemo(CategoryRepo repository) {
        return (args) -> {
            Category c1 = new Category("Scifi");
            Category c2 = new Category("Horror");

            repository.save(c1);
            repository.save(c2);
        };
    }

    @Bean
    public CommandLineRunner bookdemo(BookstoreRepo repository, CategoryRepo categoryRepo) {
        return (args) -> {
            Category c1 = categoryRepo.findByName("Scifi");
            Category c2 = categoryRepo.findByName("Horror");

            Book b1 = new Book("Homo Deus", "Yuval Noah Harari", 2019, "1223566789", 20, c1);
            Book b2 = new Book("Vapahtaja", "Arttu Tuominen", 2023, "124567767", 30.99, c2);

            repository.save(b1);
            repository.save(b2);
        };
    }
}
