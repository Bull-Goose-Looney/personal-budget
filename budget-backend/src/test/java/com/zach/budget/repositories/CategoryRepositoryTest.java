package com.zach.budget.repositories;

import com.zach.budget.entities.CategoryEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	void givenNewCategory_whenSave_thenSuccess() {
		CategoryEntity expected = new CategoryEntity("TESTCAT-1");
		CategoryEntity actual = categoryRepository.save(expected);
		assertThat(entityManager.find(CategoryEntity.class, actual.getId())).isEqualTo(expected);
	}
}
