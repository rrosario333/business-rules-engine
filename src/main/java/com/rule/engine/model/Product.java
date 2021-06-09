package com.rule.engine.model;

public enum Product {

	PHYSICAL_PRODUCT("physical product"), BOOK("Book"), VIDEO("video"), MEMBERSHIP("membership");

	private final String product;

	Product(String product) {
		this.product = product;

	}

	public String getProduct() {
		return product;
	}

}
