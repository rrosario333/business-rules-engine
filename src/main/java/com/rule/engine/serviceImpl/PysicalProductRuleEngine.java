package com.rule.engine.serviceImpl;

import org.springframework.stereotype.Service;

import com.rule.engine.service.ProductOperations;

@Service
public class PysicalProductRuleEngine implements ProductOperations {

	@Override
	public double getCommissionPayment() {
		// TODO CommissionPayment logic implementations
		return 200;
	}

	@Override
	public String sendShipping() {
		// TODO generate a packing slip for shipping logic implementations
		return "generate a packing slip for shipping";
	}

}
