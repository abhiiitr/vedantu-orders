package com.vedantu.order.service;

import com.vedantu.account.entity.AccountEntity;
import com.vedantu.common.exceptions.OrderException;
import com.vedantu.order.request.OrderRequest;

public interface OrderService {
	
	public void createOrder(OrderRequest orderRequest, AccountEntity accountEntity) throws OrderException;
	
}
