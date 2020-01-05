package com.vedantu.products.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.vedantu.common.exceptions.ProductNotFoundException;
import com.vedantu.order.request.OrderRequest;
import com.vedantu.products.entity.ProductEntity;
import com.vedantu.products.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService{

	// TODO: Add Logger and log messages
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Override
	public List<ProductEntity> getProducts(OrderRequest orderRequest) throws ProductNotFoundException {
		List<ProductEntity> productEntityList = new ArrayList<ProductEntity>();
		List<String> skuList = orderRequest.getOrderItems().stream().map(o -> o.getSku()).collect(Collectors.toList());
		productEntityList = productsRepository.findProductsBySku(skuList);
		
		if(CollectionUtils.isEmpty(productEntityList))
			throw new ProductNotFoundException("There are no products found for the skus");
		
		return productEntityList;
	}

	@Override
	public void updateProductsQuantity(List<ProductEntity> updatedProductsList) {
		productsRepository.updateProductsQuantity(updatedProductsList);
	}

	@Override
	public void updateProduct(ProductEntity updatedProduct) {
		productsRepository.updateProductQuantity(updatedProduct);
	}

}
