package com.zach.budget.repositories;

import com.zach.budget.enums.DateEnums;
import com.zach.budget.enums.FrequencyEnums;
import com.zach.budget.models.Category;
import com.zach.budget.models.LineItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class LineItemRepositoryTest {

	@Autowired
	LineItemRepository lineItemRepository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	void givenNewLineItem_whenSave_thenSuccess() {
		LineItem expected = new LineItem("LTEST-1", 22.2, 11.1, DateEnums.DAY_2, FrequencyEnums.MONTHLY);
		LineItem actual = lineItemRepository.save(expected);
		assertThat(entityManager.find(LineItem.class, actual.getId())).isEqualTo(expected);
	}

	@Test
	void givenCategory_whenFind_thenSuccess() {
		Category cat = new Category("TESTCAT-1");
		entityManager.persist(cat);

		LineItem expected = new LineItem("LTEST-1", 22.2, 11.1, DateEnums.DAY_2, FrequencyEnums.MONTHLY);
		expected.setCategory(cat);
		entityManager.persist(expected);

		List<LineItem> lineItemsList = lineItemRepository.getAllByCategory(cat);
		LineItem actual = lineItemsList.get(0);

		assertThat(entityManager.find(LineItem.class, actual.getId())).isEqualTo(expected);
	}

	@Test
	void givenLineItemName_whenFindByName_thenSuccess() {
		String name = "LTEST-2";
		LineItem expected = new LineItem(name, 22.2, 11.1, DateEnums.DAY_2, FrequencyEnums.MONTHLY);
		entityManager.persist(expected);

		LineItem actual = lineItemRepository.getByName(name);
		assertThat(entityManager.find(LineItem.class, actual.getId())).isEqualTo(expected);
	}
}
