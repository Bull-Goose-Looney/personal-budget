package com.zach.budget.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zach.budget.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByName(String name);
}
