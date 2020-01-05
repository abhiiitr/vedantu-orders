package com.vedantu.order.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

public class OrderRequest {

	@Valid
	@NotEmpty(message="Order items must not be empty")
	private List<OrderItem> orderItems;

	@NotEmpty(message="Session id cannot be empty")
	private String sessionId;

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
