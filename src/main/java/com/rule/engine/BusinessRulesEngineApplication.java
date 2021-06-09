package com.rule.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.rule.engine.model.Product.PHYSICAL_PRODUCT;
import static com.rule.engine.model.Product.BOOK;
import static com.rule.engine.model.Product.MEMBERSHIP;
import static com.rule.engine.model.Product.VIDEO;

@SpringBootApplication
public class BusinessRulesEngineApplication {
	public static Logger logger = LoggerFactory.getLogger(BusinessRulesEngineApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BusinessRulesEngineApplication.class, args);
		
		logger.info(":::::::::::::::::::::::::::::Bussiness Rule Engine Started:::::::::::::::::::::::::::::::");

		BusinessRulesEngine businessRulesEngine = new BusinessRulesEngine();
		boolean memberCompleted = businessRulesEngine.sendMember(MEMBERSHIP, true, false);
		logger.info("Member isCompleted [{}]", memberCompleted);
		boolean bookCompleted = businessRulesEngine.sendPhysicalBook(BOOK);
		logger.info("Book isCompleted [{}]", bookCompleted);
		boolean physicalProductCompleted = businessRulesEngine.sendPhysicalProduct(PHYSICAL_PRODUCT);
		logger.info("Physical Product isCompleted [{}]", physicalProductCompleted);
		boolean videoCompleted = businessRulesEngine.sendVideo(VIDEO);
		logger.info("Video isCompleted [{}]", videoCompleted);
		
		logger.info(":::::::::::::::::::::::::::::Bussiness Rule Engine Completed:::::::::::::::::::::::::::::::");

	}

}
