
package com.zach.budget.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zach.budget.entities.LineItemEntity;

public interface LineItemRepository extends JpaRepository<LineItemEntity, Long> {

}
