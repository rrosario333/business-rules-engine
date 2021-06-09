package com.rule.engine;

import static com.rule.engine.model.Product.BOOK;
import static com.rule.engine.model.Product.MEMBERSHIP;
import static com.rule.engine.model.Product.PHYSICAL_PRODUCT;
import static com.rule.engine.model.Product.VIDEO;

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

		if (product.equals(PHYSICAL_PRODUCT)) {
			return (T) new PysicalProductRuleEngine();
		}

		else if (product.equals(BOOK)) {
			return (T) new BookRuleEngine();
		}

		else if (product.equals(VIDEO)) {
			return (T) new VideoRuleEngine();
		}

		else if (product.equals(MEMBERSHIP)) {
			return (T) new MemberRuleEngine();
		}

		return null;
	}

	public boolean sendMember(Product product, boolean isActive, boolean upgrade) {
		Object obj = getRuleEngine(product);
		if (obj != null && obj instanceof MemberRuleEngine) {
			MemberRuleEngine memberRuleEngine = (MemberRuleEngine) obj;
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
			return true;
		}

		return false;
	}

	public boolean sendPhysicalBook(Product product) {
		Object obj = getRuleEngine(product);
		if (obj != null && obj instanceof BookRuleEngine) {
			BookRuleEngine bookRuleEngine = (BookRuleEngine) obj;
			double commissionPayment = bookRuleEngine.getCommissionPayment();
			String royaltyDepartment = bookRuleEngine.sendRoyaltyDepartment();
			logger.info("Book Product :::::::[product={}, commissionPayment={}, royaltyDepartment={}]", product,
					commissionPayment, royaltyDepartment);
			return true;
		}
		return false;
	}

	public boolean sendPhysicalProduct(Product product) {
		Object obj = getRuleEngine(product);
		if (obj != null && obj instanceof ProductOperations) {
			ProductOperations productOperations = (ProductOperations) obj;
			double commissionPayment = productOperations.getCommissionPayment();
			String shippmentDetails = productOperations.sendShipping();
			logger.info("Physical Product :::::::[product={}, commissionPayment={}, shippmentDetails={}]", product,
					commissionPayment, shippmentDetails);
			return true;
		}
		return false;
	}

	public boolean sendVideo(Product product) {
		Object obj = getRuleEngine(product);
		if (obj != null && obj instanceof VideoRuleEngine) {
			VideoRuleEngine videoRuleEngine = (VideoRuleEngine) obj;
			String learningToSki = videoRuleEngine.LearningToSki();
			logger.info("Video Product :::::::[product={}, learningToSki={}]", product, learningToSki);
			return true;
		}
		return false;
	}

}
