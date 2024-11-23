package com.zach.budget.controllers;

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
    public ResponseEntity<List<LineItem>> getLineItemsByCategory(@RequestParam("categoryName") String categoryName) {
        Optional<Category> category = categoryService.getCategoryByName(categoryName);
        if (category.isEmpty()) {
            LOGGER.error("Could not get list of LineItems because category=[{}] not found",categoryName);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        List<LineItem> lineItems = lineItemService.getLineItemsByCategory(category.get());
        for(LineItem l : lineItems) {
            LOGGER.info(l.toString());
        }
        if(lineItems.isEmpty()) {
            LOGGER.warn("No line items found for category=[{}]", categoryName);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().build();
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
        return new ResponseEntity<>("Category added: " + lineItem.getName(), HttpStatus.OK);
    }

}
