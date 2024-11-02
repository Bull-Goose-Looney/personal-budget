package com.zach.budget.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zach.budget.models.Account;
import com.zach.budget.models.Category;
import com.zach.budget.models.LineItem;
import com.zach.budget.repositories.LineItemRepository;

@Service
public class LineItemService {

    @Autowired
    private LineItemRepository lineItemRepository;

    public List<LineItem> findAll() {
        return lineItemRepository.findAll();
    }

    public LineItem save(LineItem lineItem) {
        return lineItemRepository.save(lineItem);
    }

    public List<LineItem> getLineItemsByCategory(Category category) {
        return lineItemRepository.getAllByCategory(category);
    }

    public List<LineItem> getLineItemsByAccount(Account account) {
        return lineItemRepository.getAllByAccount(account);
    }

    public LineItem getLineItemByName(String description) {
        return lineItemRepository.getByDescription(description);
    }

}
