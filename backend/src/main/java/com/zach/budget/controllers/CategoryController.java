package com.zach.budget.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zach.budget.entities.CategoryEntity;
import com.zach.budget.models.Category;
import com.zach.budget.services.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping
    public List<CategoryEntity> getAllCategories() {
        return categoryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@RequestBody Category category) {
        // Your logic to handle the category
        LOGGER.info("Recieved addCategory request at api/category/add");

        try {
          categoryService.save(category);
        } catch (Exception e) {
            return new ResponseEntity<>("Category added: " + category.getName(), HttpStatus.NOT_FOUND);
        }

        LOGGER.info("Category {} stored in database", category.getName());
        return new ResponseEntity<>("Category added: " + category.getName(), HttpStatus.OK);
    }

        // Other endpoints
}
