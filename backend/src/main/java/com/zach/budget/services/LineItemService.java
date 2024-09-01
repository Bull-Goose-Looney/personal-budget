package com.zach.budget.services;

import com.zach.budget.utilities.DatabaseUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zach.budget.models.LineItem;
import com.zach.budget.models.Category;
import com.zach.budget.repositories.LineItemRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class LineItemService {

    @Autowired
    private LineItemRepository lineItemRepository;

    private DatabaseUtilities dbUtil;

    public List<LineItem> findAll() {
        return lineItemRepository.findAll();
    }

    public LineItem save(LineItem lineItem) {
        return lineItemRepository.save(lineItem);
    }

    public List<LineItem> getLineItemsByCategory(Category category) {
        return lineItemRepository.getAllByCategory(category);
    }

    public LineItem getLineItemByName(String name) {
        return lineItemRepository.getByName(name);
    }

}
