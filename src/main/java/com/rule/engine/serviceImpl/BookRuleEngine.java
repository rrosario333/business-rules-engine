package com.rule.engine.serviceImpl;

import org.springframework.stereotype.Service;

import com.rule.engine.service.BookOperations;

@Service
public class BookRuleEngine implements BookOperations {

	@Override
	public double getCommissionPayment() {
		// TODO CommissionPayment logic implementations
		return 100;
	}

	@Override
	public String sendRoyaltyDepartment() {
		// TODO RoyaltyDepartment logic implementations
		return "create a duplicate packing slip for the royalty department";
	}

}
