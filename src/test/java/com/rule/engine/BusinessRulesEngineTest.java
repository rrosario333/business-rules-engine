package com.rule.engine;

import org.junit.jupiter.api.Test;

import com.rule.engine.serviceImpl.BookRuleEngine;
import com.rule.engine.serviceImpl.MemberRuleEngine;
import com.rule.engine.serviceImpl.PysicalProductRuleEngine;
import com.rule.engine.serviceImpl.VideoRuleEngine;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static com.rule.engine.model.Product.PHYSICAL_PRODUCT;
import static com.rule.engine.model.Product.BOOK;
import static com.rule.engine.model.Product.MEMBERSHIP;
import static com.rule.engine.model.Product.VIDEO;

public class BusinessRulesEngineTest {

	@Test
	void givenPhysicalProduct_whenSendPhysicalProduct_thenShouldCallCommissionPaymentAndShipment() {
		BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
		boolean actualResult = businessRulesEngine.sendPhysicalProduct(PHYSICAL_PRODUCT);
		assertTrue(actualResult);
	}

	@Test
	void givenBook_whenSendBook_thenShouldCallCommissionPaymentAndRoyalDepartment() {
		BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
		boolean actualResult = businessRulesEngine.sendPhysicalBook(BOOK);
		assertTrue(actualResult);
	}

	@Test
	void givenVideo_whenSendVideo_thenShouldCallLearningToSki() {
		BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
		boolean actualResult = businessRulesEngine.sendVideo(VIDEO);
		assertTrue(actualResult);
	}

	@Test
	void givenMember_whenSendMember_thenShouldActive() {
		BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
		boolean actualResult = businessRulesEngine.sendMember(MEMBERSHIP, true, false);
		assertTrue(actualResult);
	}

	@Test
	void givenMember_whenSendMember_thenShouldUpgrade() {
		BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
		boolean actualResult = businessRulesEngine.sendMember(MEMBERSHIP, false, true);
		assertTrue(actualResult);
	}

	@Test
	void getPhysicalProductRuleEngine() {
		BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
		Object obj = businessRulesEngine.getRuleEngine(PHYSICAL_PRODUCT);

		assertTrue(obj instanceof PysicalProductRuleEngine);

	}

	@Test
	void getPhysicalBookRuleEngine() {
		BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
		Object obj = businessRulesEngine.getRuleEngine(BOOK);

		assertTrue(obj instanceof BookRuleEngine);

	}

	@Test
	void getPhysicalVideoRuleEngine() {
		BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
		Object obj = businessRulesEngine.getRuleEngine(BOOK);

		assertTrue(obj instanceof VideoRuleEngine);

	}

	@Test
	void getPhysicalMemberRuleEngine() {
		BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
		Object obj = businessRulesEngine.getRuleEngine(BOOK);

		assertTrue(obj instanceof MemberRuleEngine);

	}

}
