package com.example.demo.domain;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {

	Category findByName(String string);

}
