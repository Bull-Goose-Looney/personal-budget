package com.zach.budget.conversion;

import org.springframework.stereotype.Component;

import com.zach.budget.entities.CategoryEntity;
import com.zach.budget.models.Category;

@Component
public class CategoryMapper {

    public Category toModel(CategoryEntity entity) {
        Category model = new Category(entity.getName());
        model.setId(entity.getId());
        return model;
    }

    public CategoryEntity toEntity(Category model) {
        CategoryEntity entity = new CategoryEntity(model.getName());
        return entity;
    } 
}
