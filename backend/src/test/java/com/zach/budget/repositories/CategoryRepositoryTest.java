package com.zach.budget.repositories;

import com.zach.budget.models.Category;
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
		Category expected = new Category("TESTCAT-1");
		Category actual = categoryRepository.save(expected);
		assertThat(entityManager.find(Category.class, actual.getId())).isEqualTo(expected);
	}
}
