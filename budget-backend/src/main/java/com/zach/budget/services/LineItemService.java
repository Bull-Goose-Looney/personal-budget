package com.zach.budget.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zach.budget.conversion.AccountMapper;
import com.zach.budget.conversion.CategoryMapper;
import com.zach.budget.conversion.LineItemMapper;
import com.zach.budget.entities.AccountEntity;
import com.zach.budget.entities.LineItemEntity;
import com.zach.budget.models.Account;
import com.zach.budget.models.Category;
import com.zach.budget.models.LineItem;
import com.zach.budget.repositories.LineItemRepository;

@Service
public class LineItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LineItemService.class);

    @Autowired
    private LineItemRepository lineItemRepository;

    @Autowired
    private LineItemMapper lineItemMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private AccountMapper accountMapper;


    @Transactional
    public LineItemEntity save(LineItemEntity lineItem) {
        return lineItemRepository.save(lineItem);
    }

    public List<LineItem> findAll() {
        return lineItemRepository.findAll().stream()
            .map(e -> lineItemMapper.toModel(e))
            .collect(Collectors.toList());
    }

    public List<LineItem> getLineItemsByCategory(Category category) {
        LOGGER.info("CATEGORYID: {}", category.getId());
        List<LineItemEntity> entities = lineItemRepository.getAllByCategoryId(category.getId());

        // LOGGER.info("Loading Line Items for Category={}", category.getName());
        return entities.stream()
            .map(e -> lineItemMapper.toModel(e))
            .collect(Collectors.toList());
    }

    public List<LineItem> getLineItemsByAccount(Account account) {

        AccountEntity accountEntity = accountMapper.toEntity(account);
        List<LineItemEntity> entities = lineItemRepository.getAllByAccount(accountEntity);
        return entities.stream()
            .map(e -> lineItemMapper.toModel(e))
            .collect(Collectors.toList());
    }

    public Optional<LineItem> getLineItemByName(String name) {
        Optional<LineItemEntity> entity = lineItemRepository.findByName(name);
        return entity.map(lineItemMapper::toModel);
    }


}
