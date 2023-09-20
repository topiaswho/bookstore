package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookstoreRepo;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
@Bean
public CommandLineRunner demo (BookstoreRepo repository) {
	return (args) -> {
		Book b1 = new Book("Homo Deus", "Yuval Noah Harari", 2019, "1223566789", 20);
		Book b2 = new Book("Vapahtaja", "Arttu Tuominen", 2023, "124567767", 30.99);
		
		repository.save(b1);
		repository.save(b2);
	};
	
}
}