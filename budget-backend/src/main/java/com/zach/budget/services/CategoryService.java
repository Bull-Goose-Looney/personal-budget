package com.zach.budget.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zach.budget.conversion.CategoryMapper;
import com.zach.budget.entities.CategoryEntity;
import com.zach.budget.models.Category;
import com.zach.budget.repositories.CategoryRepository;

@Service
public class CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional
    public Category save(CategoryEntity category) {
        return categoryMapper.toModel(categoryRepository.save(category));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll().stream()
                .map(categoryEntity -> categoryMapper.toModel(categoryEntity))
                .collect(Collectors.toList());
    }

    public Optional<Category> getCategoryByName(String name) {
        Optional<CategoryEntity> categoryEntity = categoryRepository.findByName(name);
        return categoryEntity.map(categoryMapper::toModel);

    }

}
