
package com.zach.budget.repositories;

import com.zach.budget.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import com.zach.budget.models.LineItem;

import java.util.List;

public interface LineItemRepository extends JpaRepository<LineItem, Long> {
    List<LineItem> getAllByCategory(Category category);
    LineItem getByName(String name);
}
