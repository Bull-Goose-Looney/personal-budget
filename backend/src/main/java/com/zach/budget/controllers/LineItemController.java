package com.zach.budget.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zach.budget.entities.LineItemEntity;
import com.zach.budget.models.Category;
import com.zach.budget.models.LineItem;
import com.zach.budget.services.CategoryService;
import com.zach.budget.services.LineItemService;

@RestController
@RequestMapping("api/lineitem")
public class LineItemController {

    @Autowired
    private LineItemService lineItemService;

    @Autowired
    private CategoryService categoryService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LineItemController.class);

    @GetMapping
    public ResponseEntity<List<LineItem>> getLineItemsByCategory(@RequestParam(name = "categoryName") String categoryName) {
        LOGGER.info("Recieved getLineItemsByCategory request at api/lineitem/{}", categoryName);
        Optional<Category> category = categoryService.getCategoryByName(categoryName);
        List<LineItem> lineItems = lineItemService.getLineItemsByCategory(category.get());
        return ResponseEntity.ok(lineItems);
    }

    @GetMapping("/getbyname")
    public ResponseEntity<LineItem> getLineItemByName(@RequestBody String name) {
        Optional<LineItem> lineItem = lineItemService.getLineItemByName(name);
        if(lineItem.isPresent()) {
            return ResponseEntity.ok(lineItem.get());
        }
        LOGGER.error("Could not find line item with name={}", name);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLineItem(@RequestBody LineItemEntity lineItem) {
        LOGGER.info("Recieved addLineItem request at api/lineitem/add={}");
        lineItemService.save(lineItem);
        return new ResponseEntity<>("Line Item Added: " + lineItem.getName(), HttpStatus.OK);
    }

}
