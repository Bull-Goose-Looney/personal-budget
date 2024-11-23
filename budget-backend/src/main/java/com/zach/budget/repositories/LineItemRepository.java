
package com.zach.budget.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zach.budget.entities.AccountEntity;
import com.zach.budget.entities.LineItemEntity;

public interface LineItemRepository extends JpaRepository<LineItemEntity, Long> {
    List<LineItemEntity> getAllByAccount(AccountEntity account);
    List<LineItemEntity> getAllByCategoryId(Long categoryId);
    Optional<LineItemEntity> findByName(String name);
}
