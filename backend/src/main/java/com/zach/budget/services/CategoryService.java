package com.zach.budget.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zach.budget.entities.CategoryEntity;
import com.zach.budget.models.Category;
import com.zach.budget.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryEntity save(Category category) {
        return categoryRepository.save(new CategoryEntity(category));
    }

    // Other CRUD methods
}