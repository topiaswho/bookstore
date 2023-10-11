package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.demo.domain.Book;
import com.example.demo.domain.BookstoreRepo;
import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepo;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepo;






@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
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
    public CommandLineRunner bookdemo(
        BookstoreRepo repository,
        CategoryRepo categoryRepo,
        UserRepo userRepository) {
        return (args) -> {
            
            Category c1 = categoryRepo.findByName("Scifi");
            Category c2 = categoryRepo.findByName("Horror");

            Book b1 = new Book("Homo Deus", "Yuval Noah Harari", 2019, "1223566789", 20, c1);
            Book b2 = new Book("Vapahtaja", "Arttu Tuominen", 2023, "124567767", 30.99, c2);

            repository.save(b1);
            repository.save(b2);
        
          
            User user1 = new User("user", "$2a$10$UGmi5XfZpDgJc1J0vAplR.b6PswOUioi3uMzipaeqUuTS9WaGJhmy", "USER");
            User user2 = new User("admin", "$2a$10$RrF51aLGltbRSkjaaIyYPuC/X34ByyG8IhOQVpyQkfP6XJW.ogaU.", "ADMIN");
            userRepository.save(user1);
            userRepository.save(user2);
            
            log.info("fetch all users");
			for (User user : userRepository.findAll()) {
				log.info(user.toString());
			}

    };
 
}
}