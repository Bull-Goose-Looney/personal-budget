
package com.zach.budget.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zach.budget.entities.LineItemEntity;
import com.zach.budget.models.Account;
import com.zach.budget.models.Category;

import java.util.List;
import java.util.Optional;

public interface LineItemRepository extends JpaRepository<LineItemEntity, Long> {
    List<LineItemEntity> getAllByAccount(Account account);
    List<LineItemEntity> getAllByCategory(Category category);
    Optional<LineItemEntity> findByName(String name);
}
