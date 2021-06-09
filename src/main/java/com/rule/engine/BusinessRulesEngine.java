package com.rule.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rule.engine.model.Product;
import com.rule.engine.service.ProductOperations;
import com.rule.engine.serviceImpl.BookRuleEngine;
import com.rule.engine.serviceImpl.MemberRuleEngine;
import com.rule.engine.serviceImpl.PysicalProductRuleEngine;
import com.rule.engine.serviceImpl.VideoRuleEngine;

@Component
public class BusinessRulesEngine {
	Logger logger = LoggerFactory.getLogger(BusinessRulesEngine.class);

	public <T> T getRuleEngine(Product product) {

		if (product == null) {
			return null;
		}

		if (product.equals(Product.PHYSICAL_PRODUCT)) {
			return (T) new PysicalProductRuleEngine();
		}

		else if (product.equals(Product.BOOK)) {
			return (T) new BookRuleEngine();
		}

		else if (product.equals(Product.VIDEO)) {
			return (T) new VideoRuleEngine();
		}

		else if (product.equals(Product.MEMBERSHIP)) {
			return (T) new MemberRuleEngine();
		}

		return null;
	}

	public void sendPhysicalProduct(Product product) {
		ProductOperations productOperations = getRuleEngine(product);
		if (productOperations != null) {
			double commissionPayment = productOperations.getCommissionPayment();
			String shippmentDetails = productOperations.sendShipping();
			logger.info("Physical Product :::::::[product={}, commissionPayment={}, shippmentDetails={}]", product,
					commissionPayment, shippmentDetails);
		}
	}

	public void sendPhysicalBook(Product product) {
		BookRuleEngine bookRuleEngine = getRuleEngine(product);
		if (bookRuleEngine != null) {
			double commissionPayment = bookRuleEngine.getCommissionPayment();
			String royaltyDepartment = bookRuleEngine.sendRoyaltyDepartment();
			logger.info("Book Product :::::::[product={}, commissionPayment={}, royaltyDepartment={}]", product,
					commissionPayment, royaltyDepartment);
		}
	}

	public void sendVideo(Product product) {
		VideoRuleEngine videoRuleEngine = getRuleEngine(product);
		if (videoRuleEngine != null) {
			String learningToSki = videoRuleEngine.LearningToSki();
			logger.info("Video Product :::::::[product={}, learningToSki={}]", product, learningToSki);
		}
	}

	public void sendMember(Product product, boolean isActive, boolean upgrade) {
		MemberRuleEngine memberRuleEngine = getRuleEngine(product);
		if (memberRuleEngine != null) {
			if (isActive) {
				boolean activated = memberRuleEngine.activate();
				logger.info("Member :::::::[member={}, activated={}]", product, activated);
			}

			if (upgrade) {
				boolean upgraded = memberRuleEngine.upgrade();
				logger.info("Member :::::::[member={} upgraded={}]", product, upgraded);
			}

			boolean isEmailSend = memberRuleEngine.sendEmail();
			logger.info("Member activated/upgraded email send :::::::[member={}, isEmailSend={}]", product,
					isEmailSend);
		}
	}

}
