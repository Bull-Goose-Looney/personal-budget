package com.zach.budget.conversion;

import org.mapstruct.Mapper;

import com.zach.budget.entities.CategoryEntity;
import com.zach.budget.models.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toModel(CategoryEntity entity);
    CategoryEntity toEntity(Category category); 
}
