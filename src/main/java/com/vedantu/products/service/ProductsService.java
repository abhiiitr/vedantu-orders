package com.vedantu.products.service;

import java.util.List;

import com.vedantu.common.exceptions.ProductNotFoundException;
import com.vedantu.order.request.OrderRequest;
import com.vedantu.products.entity.ProductEntity;

public interface ProductsService {

	List<ProductEntity> getProducts(OrderRequest orderRequest) throws ProductNotFoundException;

	void updateProductsQuantity(List<ProductEntity> updatedProductsList);
	
	void updateProduct(ProductEntity updatedProduct);

}
