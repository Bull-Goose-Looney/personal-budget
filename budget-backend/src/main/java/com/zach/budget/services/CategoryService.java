package com.zach.budget.services;

import com.zach.budget.controllers.LineItemController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zach.budget.models.Category;
import com.zach.budget.repositories.CategoryRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        LOGGER.info("Loading Categories");
        try {
            List<Category> result = categoryRepository.findAll();
            LOGGER.info("loaded {} categories", result.size());
            return result;
        } catch (Exception e) {
            LOGGER.error("There was a problem loading the categories");
        }
        return null;
    }

    @Transactional
    public Category save(Category category) {
        try {
            Category result = categoryRepository.save(category);
            LOGGER.info("Saved category={}", result.getDescription());
            return result;

        } catch(Exception e) {
            LOGGER.error("There was a problem saving the category");
        }
        return null;
    }

}
