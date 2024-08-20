package com.zach.budget.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zach.budget.entities.LineItemEntity;
import com.zach.budget.models.Category;
import com.zach.budget.models.LineItem;
import com.zach.budget.repositories.LineItemRepository;

import java.util.List;

@Service
public class LineItemService {

    @Autowired
    private LineItemRepository lineItemRepository;

    public List<LineItemEntity> findAll() {
        return lineItemRepository.findAll();
    }

    public LineItemEntity save(LineItem lineItem) {
        return lineItemRepository.save(new LineItemEntity(lineItem));
    }

    // TODO create a db utility class to convert from entity to model and vice versa

    // TODO, add repo method
    public List<LineItem> getLineItemsByCategory(Category category) {
        return LineItem(lineItemRepository.getAllByCategory(category));
    }

    // TODO repo
    public LineItem getLineItemByName(String name) {
        return null;
    }








    // Other CRUD methods
}
