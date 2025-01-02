package com.zach.budget.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.zach.budget.entities.AccountEntity;
import com.zach.budget.entities.CategoryEntity;
import com.zach.budget.entities.LineItemEntity;
import com.zach.budget.enums.AccountTypeEnums;
import com.zach.budget.enums.FrequencyEnums;

@DataJpaTest
public class LineItemRepositoryTest {

	@Autowired
	LineItemRepository lineItemRepository;

	@Autowired
	TestEntityManager entityManager;

	@Test
	void givenNewLineItem_whenSave_thenSuccess() {
		LineItemEntity expected = new LineItemEntity("LTEST-1", 22.2, LocalDate.now(), FrequencyEnums.MONTHLY, false, new AccountEntity(), new CategoryEntity("ass"));
		LineItemEntity actual = lineItemRepository.save(expected);
		assertThat(entityManager.find(LineItemEntity.class, actual.getId())).isEqualTo(expected);
	}

	@Test
	void givenCategory_whenFindByCategoryId_thenSuccess() {
		CategoryEntity cat = entityManager.persist(new CategoryEntity("TESTCAT-1"));
		AccountEntity account = entityManager.persist(new AccountEntity("USAA Checking", AccountTypeEnums.CHECKING));

		LineItemEntity expected = new LineItemEntity("LTEST-1", 22.2, LocalDate.now(), FrequencyEnums.MONTHLY, false, account, cat);
		entityManager.persist(expected);


		List<LineItemEntity> lineItemsList = lineItemRepository.getAllByCategoryId(cat.getId());
		LineItemEntity actual = lineItemsList.get(0);

		assertThat(entityManager.find(LineItemEntity.class, actual.getId())).isEqualTo(expected);
	}

	@Test
	void givenLineItemName_whenFindByDescription_thenSuccess() {
		String name = "LTEST-1";

		LineItemEntity expected = new LineItemEntity("LTEST-1", 22.2, LocalDate.now(), FrequencyEnums.MONTHLY, false, null, null);
		entityManager.persist(expected);

		Optional<LineItemEntity> actual = lineItemRepository.findByName(name);
		assertNotEquals(Optional.empty(), actual);
		assertThat(entityManager.find(LineItemEntity.class, actual.get().getId())).isEqualTo(expected);
	}

}
