package com.zach.budget.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zach.budget.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByDescription(String description);

}
