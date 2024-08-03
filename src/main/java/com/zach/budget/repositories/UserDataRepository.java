package com.zach.budget.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zach.budget.entities.UserDataEntity;

public interface UserDataRepository extends JpaRepository<UserDataEntity, Long> {
    // Additional query methods can be defined here
}
