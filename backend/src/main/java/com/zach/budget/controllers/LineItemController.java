package com.zach.budget.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zach.budget.models.LineItem;
import com.zach.budget.services.LineItemService;

@RestController
@RequestMapping("api/lineitem")
public class LineItemController {

    @Autowired
    private LineItemService lineItemService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @GetMapping
    public List<LineItem> getAllCategories() {
        return lineItemService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLineItem(@RequestBody LineItem lineItem) {
        // Your logic to handle the category
        LOGGER.info("Recieved addCategory request at api/category/add");

        try {
          lineItemService.save(lineItem);
        } catch (Exception e) {
            return new ResponseEntity<>("Line item added: " + lineItem.getName(), HttpStatus.NOT_FOUND);
        }

        LOGGER.info("Category {} stored in database", lineItem.getName());
        return new ResponseEntity<>("Category added: " + lineItem.getName(), HttpStatus.OK);
    }

        // Other endpoints
}
