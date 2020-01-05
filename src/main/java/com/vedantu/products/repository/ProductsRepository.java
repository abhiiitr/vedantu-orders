package com.vedantu.products.repository;

import java.util.List;

import com.vedantu.products.entity.ProductEntity;

public interface ProductsRepository {

	List<ProductEntity> findProductsBySku(List<String> skuList);

	void updateProductsQuantity(List<ProductEntity> updatedProductsList);

	void updateProductQuantity(ProductEntity updatedProduct);

}
