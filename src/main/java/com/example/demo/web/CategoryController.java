package com.example.demo.web;

import com.example.demo.domain.CategoryRepo;
import com.example.demo.domain.Book;
import com.example.demo.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepository;

    @GetMapping("/categorylist")
    public String categoryList(Model model) {
        List<Category> categories = (List<Category>) categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categorylist";
    }
    @GetMapping("/addcategory")
    public String addcategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }
    @PostMapping("/addcategory")
    public String addCategorySubmit(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }

}