package com.vedantu.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedantu.account.entity.AccountEntity;
import com.vedantu.common.exceptions.OrderException;
import com.vedantu.common.exceptions.ProductNotFoundException;
import com.vedantu.order.entity.OrderEntity;
import com.vedantu.order.entity.OrderItemEntity;
import com.vedantu.order.enums.OrderStatus;
import com.vedantu.order.repository.OrderRepository;
import com.vedantu.order.request.OrderRequest;
import com.vedantu.order.util.OrderUtils;
import com.vedantu.products.entity.ProductEntity;
import com.vedantu.products.service.ProductsService;

/**
 * @author abhishek
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	// TODO: Add Logger and log messages

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductsService productsService;

	// @Transactional
	public void createOrder(OrderRequest orderRequest, AccountEntity accountEntity) throws OrderException {
		try {

			// Fetch the products from db
			List<ProductEntity> productsList = productsService.getProducts(orderRequest);

			/*
			 * FOR CONCURRENCY - Different requests can order the same item. We
			 * should take the lock on the sku of the product which ensures only
			 * one request is operating on a product OR We can set the status of
			 * the product from AVAILABLE to PROCESSING in the db and check
			 * before updating for any order.
			 */

			// Validate the quantity of the products and decrease the updated
			// quantity
			// in the product list
			List<ProductEntity> updatedProductsList = OrderUtils.validateAndUpdateProductQuantity(productsList,
					orderRequest);
			OrderEntity order = new OrderEntity();

			List<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();

			for (ProductEntity product : updatedProductsList) {

				// TODO: Get the latest product quantity for the product sku
				// and take the lock on the sku
				synchronized (product.getSku()) {

					OrderItemEntity item = new OrderItemEntity();
					item.setOrderId(order.getId());
					item.setProductId(product.getId());
					// Set other values

					orderItems.add(item);
					// Update the product collection and release the lock after
					// update
					productsService.updateProduct(product);
				}

			}
			order.setOrderItems(orderItems);
			order.setStatus(OrderStatus.PROCESSING);

			orderRepository.createOrder(order);
		} catch (ProductNotFoundException e) {
			throw new OrderException(e.getMessage());
		}
	}

}
