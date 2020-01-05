package com.vedantu.order.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.vedantu.common.exceptions.ProductNotFoundException;
import com.vedantu.order.request.OrderItem;
import com.vedantu.order.request.OrderRequest;
import com.vedantu.products.entity.ProductEntity;

public class OrderUtils {

	// TODO : Add logger

	public static List<ProductEntity> validateAndUpdateProductQuantity(List<ProductEntity> productsList,
			OrderRequest orderRequest) throws ProductNotFoundException {
		// TODO : log messages
		List<ProductEntity> updatedProductsList = new ArrayList<>();
		StringBuilder invalidSkuList = new StringBuilder();
		Map<String, ProductEntity> productQuantityMap = productsList.stream()
				.collect(Collectors.toMap(p -> p.getSku(), p -> p));

		// Find skus for which the quantity is not available
		for (OrderItem orderItem : orderRequest.getOrderItems()) {
			ProductEntity product = productQuantityMap.get(orderItem.getSku());
			if (product != null) {
				// Check if the available quantity is <= ordered qty
				if (orderItem.getQuantity() > product.getQuantity()) {
					invalidSkuList.append(orderItem.getSku()).append(",");
				} else {
					// Update the quantity of the product
					int updatedQuantity = (int) product.getQuantity() - (int) orderItem.getQuantity();
					product.setQuantity(updatedQuantity);
					updatedProductsList.add(product);
				}
			}
		}

		if (!StringUtils.isEmpty(invalidSkuList.toString())) {
			throw new ProductNotFoundException("The following items are not available:" + invalidSkuList);
		}

		return updatedProductsList;
	}

}
