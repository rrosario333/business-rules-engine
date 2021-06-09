package com.rule.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.rule.engine.model.Product.PHYSICAL_PRODUCT;
import static com.rule.engine.model.Product.BOOK;
import static com.rule.engine.model.Product.MEMBERSHIP;
import static com.rule.engine.model.Product.VIDEO;

@SpringBootApplication
public class BusinessRulesEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessRulesEngineApplication.class, args);

		BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
		businessRulesEngine.sendMember(MEMBERSHIP, true, false);
		businessRulesEngine.sendPhysicalBook(BOOK);
		businessRulesEngine.sendPhysicalProduct(PHYSICAL_PRODUCT);
		businessRulesEngine.sendVideo(VIDEO);

	}

}
