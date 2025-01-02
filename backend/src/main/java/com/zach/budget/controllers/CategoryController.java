package com.zach.budget.controllers;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zach.budget.conversion.CategoryMapper;
import com.zach.budget.entities.CategoryEntity;
import com.zach.budget.models.Category;
import com.zach.budget.services.CategoryService;

@RestController
@RequestMapping("api/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper mapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        LOGGER.info("received getAllCategories request at api/category/categories");
        List<Category> categories = categoryService.findAll();
        if(categories.isEmpty()) {
            LOGGER.warn("No categories found");
            return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody Category category) {
        // Your logic to handle the category
        LOGGER.info("Recieved addCategory request at api/category/add");

        try {
          categoryService.save(mapper.toEntity(category));
        } catch (Exception e) {
            return new ResponseEntity<>("Category added: " + category.getName(), HttpStatus.NOT_FOUND);
        }

        LOGGER.info("Category {} stored in database", category.getName());
        return new ResponseEntity<>("Category added: " + category.getName(), HttpStatus.OK);
    }

        // Other endpoints
}
