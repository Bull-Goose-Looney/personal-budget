package com.zach.budget.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.zach.budget.entities.CategoryEntity;
import com.zach.budget.models.Category;
import com.zach.budget.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

        @Autowired
        private CategoryService categoryService;

        private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

        @GetMapping
        public List<CategoryEntity> getAllCategories() {
            return categoryService.findAll();
        }

        @PostMapping
        public CategoryEntity createCategory(@RequestBody Category category) {
            LOGGER.info("Created new category", category.getName());
            return categoryService.save(category);
        }

        // Other endpoints
}
