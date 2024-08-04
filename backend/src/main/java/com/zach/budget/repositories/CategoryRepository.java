package com.zach.budget.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zach.budget.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    // Additional query methods can be defined here
}
