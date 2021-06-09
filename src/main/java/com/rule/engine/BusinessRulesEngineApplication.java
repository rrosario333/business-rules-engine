package com.rule.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rule.engine.model.Product;

@SpringBootApplication
public class BusinessRulesEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessRulesEngineApplication.class, args);

		BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
		businessRulesEngine.sendMember(Product.MEMBERSHIP, true, false);
		businessRulesEngine.sendPhysicalBook(Product.BOOK);
		businessRulesEngine.sendPhysicalProduct(Product.PHYSICAL_PRODUCT);
		businessRulesEngine.sendVideo(Product.VIDEO);

	}

}
