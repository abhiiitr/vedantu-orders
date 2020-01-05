package com.vedantu.order.repository;

import org.springframework.stereotype.Component;

import com.vedantu.order.entity.OrderEntity;

@Component
public interface OrderRepository {

	void createOrder(OrderEntity order);

}
