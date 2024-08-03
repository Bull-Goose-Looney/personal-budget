package com.zach.budget.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import org.mockito.junit.jupiter.MockitoExtension;

import com.zach.budget.entities.CategoryEntity;
import com.zach.budget.models.Category;
import com.zach.budget.repositories.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    CategoryRepository repo;

    @InjectMocks
    CategoryService service;

    @Test
    public void testSaveCategory() {
        when(repo.save(any())).thenReturn(new CategoryEntity());

        service.save(new Category("Some", "Category"));
    }

}