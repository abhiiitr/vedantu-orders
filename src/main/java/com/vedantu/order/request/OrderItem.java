package com.vedantu.order.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class OrderItem {

	@NotEmpty(message="sku cannot be empty")
	private String sku;
	@NotNull(message="quantity cannot be empty")
	private Integer quantity;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
