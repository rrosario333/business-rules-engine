package com.rule.engine;

import static com.rule.engine.model.Product.BOOK;
import static com.rule.engine.model.Product.MEMBERSHIP;
import static com.rule.engine.model.Product.PHYSICAL_PRODUCT;
import static com.rule.engine.model.Product.VIDEO;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rule.engine.serviceImpl.BookRuleEngine;
import com.rule.engine.serviceImpl.MemberRuleEngine;
import com.rule.engine.serviceImpl.PysicalProductRuleEngine;
import com.rule.engine.serviceImpl.VideoRuleEngine;

public class BusinessRulesEngineTest {
	BusinessRulesEngine businessRulesEngine;
	
	@Test
	void getPhysicalBookRuleEngine() {
		Object obj = businessRulesEngine.getRuleEngine(BOOK);

		assertTrue(obj instanceof BookRuleEngine);
	}

	@Test
	void getPhysicalMemberRuleEngine() {
		Object obj = businessRulesEngine.getRuleEngine(MEMBERSHIP);

		assertTrue(obj instanceof MemberRuleEngine);
	}

	@Test
	void getPhysicalProductRuleEngine() {
		Object obj = businessRulesEngine.getRuleEngine(PHYSICAL_PRODUCT);

		assertTrue(obj instanceof PysicalProductRuleEngine);
	}

	@Test
	void getPhysicalVideoRuleEngine() {
		Object obj = businessRulesEngine.getRuleEngine(VIDEO);

		assertTrue(obj instanceof VideoRuleEngine);
	}

	@Test
	void givenBook_whenSendBook_thenShouldCallCommissionPaymentAndRoyalDepartment() {
		boolean actualResult = businessRulesEngine.sendPhysicalBook(BOOK);
		assertTrue(actualResult);
	}

	@Test
	void givenMember_whenSendMember_thenShouldActive() {
		boolean actualResult = businessRulesEngine.sendMember(MEMBERSHIP, true, false);
		assertTrue(actualResult);
	}

	@Test
	void givenMember_whenSendMember_thenShouldUpgrade() {
		boolean actualResult = businessRulesEngine.sendMember(MEMBERSHIP, false, true);
		assertTrue(actualResult);
	}

	@Test
	void givenPhysicalProduct_whenSendPhysicalProduct_thenShouldCallCommissionPaymentAndShipment() {
		boolean actualResult = businessRulesEngine.sendPhysicalProduct(PHYSICAL_PRODUCT);
		assertTrue(actualResult);
	}

	@Test
	void givenVideo_whenSendVideo_thenShouldCallLearningToSki() {
		boolean actualResult = businessRulesEngine.sendVideo(VIDEO);
		assertTrue(actualResult);
	}

	@BeforeEach
    public void init() {
		businessRulesEngine = new BusinessRulesEngine();
    }

}
