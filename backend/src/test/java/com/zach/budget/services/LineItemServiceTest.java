package com.zach.budget.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import com.zach.budget.repositories.LineItemRepository;

@ExtendWith(MockitoExtension.class)
public class LineItemServiceTest {

    @Mock
    LineItemRepository repo;

    @InjectMocks
    LineItemService service;

    @Test
    public void testSaveLineItem() {
        // service.save(new Category("Some", "Category"));
    }

}
