package com.zach.budget.repositories;

import com.zach.budget.enums.AccountTypeEnums;
import com.zach.budget.enums.FrequencyEnums;
import com.zach.budget.models.Account;
import com.zach.budget.models.Category;
import com.zach.budget.models.LineItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
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
		LineItem expected = new LineItem("LTEST-1", 22.2, LocalDateTime.now(), FrequencyEnums.MONTHLY, false, new Account(), new Category("ass"));
		LineItem actual = lineItemRepository.save(expected);
		assertThat(entityManager.find(LineItem.class, actual.getId())).isEqualTo(expected);
	}

	@Test
	void givenCategory_whenFind_thenSuccess() {
		Category cat = new Category("TESTCAT-1");
		entityManager.persist(cat);

		Account acct = new Account("usaa checking", AccountTypeEnums.CHECKING);
		entityManager.persist(acct);

		LineItem expected = new LineItem("LTEST-1", 22.2, LocalDateTime.now(), FrequencyEnums.MONTHLY, false, acct, cat);
		entityManager.persist(expected);

		List<LineItem> lineItemsList = lineItemRepository.getAllByCategory(cat);
		LineItem actual = lineItemsList.get(0);

		assertThat(entityManager.find(LineItem.class, actual.getId())).isEqualTo(expected);
	}

	@Test
	void givenLineItemName_whenFindByDescription_thenSuccess() {
		String description = "LTEST-1";

		LineItem expected = new LineItem("LTEST-1", 22.2, LocalDateTime.now(), FrequencyEnums.MONTHLY, false, null, null);
		entityManager.persist(expected);

		LineItem actual = lineItemRepository.getByDescription(description);
		assertThat(entityManager.find(LineItem.class, actual.getId())).isEqualTo(expected);
	}

	@Test
	void givenLineItem_whenFindByAccount_thenSuccess() {
		Account acct = new Account("usaa checking", AccountTypeEnums.CHECKING);
		entityManager.persist(acct);

		LineItem expected = new LineItem("LTEST-1", 22.2, LocalDateTime.now(), FrequencyEnums.MONTHLY, false, acct, null);
		entityManager.persist(expected);

		List<LineItem> returnedList = lineItemRepository.getAllByAccount(acct);
		LineItem actual = returnedList.get(0);
		assertThat(entityManager.find(LineItem.class, actual.getId())).isEqualTo(expected);
	}
}
