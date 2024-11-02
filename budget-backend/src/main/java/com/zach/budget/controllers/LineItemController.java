package com.zach.budget.controllers;

import java.util.List;

import com.zach.budget.models.Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getallbycategory")
    public List<LineItem> getLineItemsByCategory(@PathVariable String categoryDescription) {
        Category category = categoryService.getCategoryByDescription(categoryDescription);
        return lineItemService.getLineItemsByCategory(category);
    }

    @GetMapping("/getbyname")
    public LineItem getLineItemByName(@RequestBody String name) {
        return lineItemService.getLineItemByName(name);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLineItem(@RequestBody LineItem lineItem) {
        // Your logic to handle the category
        LOGGER.info("Recieved addLineItem request at api/lineitem/add={}");

        try {
          lineItemService.save(lineItem);
        } catch (Exception e) {
            return new ResponseEntity<>("Line item added: " + lineItem.getDescription(), HttpStatus.NOT_FOUND);
        }



        LOGGER.info("LineItem {} stored in database", lineItem.toString());
        return new ResponseEntity<>("Category added: " + lineItem.getDescription(), HttpStatus.OK);
    }

        // Other endpoints
}
