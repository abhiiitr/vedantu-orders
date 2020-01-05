package com.vedantu.order.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vedantu.account.entity.AccountEntity;
import com.vedantu.account.service.AccountService;
import com.vedantu.common.ApplicationConstants;
import com.vedantu.common.beans.MessageBean;
import com.vedantu.order.request.OrderRequest;
import com.vedantu.order.response.OrderResponse;
import com.vedantu.order.service.OrderService;

@RestController
public class OrderController {

	// TODO: Add Logger and log messages
	@Autowired
	private OrderService orderService;

	@Autowired
	private AccountService accountService;

	@PostMapping("/order/create")
	public OrderResponse createOrder(@Valid @RequestBody OrderRequest orderRequest) {
		MessageBean message = new MessageBean();
		OrderResponse response = new OrderResponse();
		try {
			AccountEntity accountEntity = accountService.validateUserSession(orderRequest.getSessionId());
			orderService.createOrder(orderRequest, accountEntity);
			message.setMessage(ApplicationConstants.ORDER_CREATED);
			message.setStatus(ApplicationConstants.SUCCESS);
		} catch (Exception e) {
			message.setMessage(e.getMessage());
			message.setStatus(ApplicationConstants.FAILURE);
		}
		response.setMessage(message);
		return response;
	}

}
