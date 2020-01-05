package com.vedantu.order.enums;

public enum OrderStatus {
	// PENDING - When added to cart
	// PROCESSING - When order is placed
	// COMPLETE - When payment is complete
	PENDING("Pending"), PROCESSING("Processing"), COMPLETE("Complete");

	private String status;

	OrderStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
