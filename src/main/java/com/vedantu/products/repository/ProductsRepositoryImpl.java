package com.vedantu.products.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.vedantu.products.entity.ProductEntity;

@Component
public class ProductsRepositoryImpl implements ProductsRepository {

	static Map<String, ProductEntity> productsMap = new HashMap<String, ProductEntity>();

	static {
		ProductEntity product1 = new ProductEntity();
		product1.setId(1);
		product1.setSku("1234-8-9");
		product1.setName("New Product 1");
		product1.setQuantity(5);
		ProductEntity product2 = new ProductEntity();
		product1.setId(2);
		product1.setSku("1234-5-7");
		product1.setName("New Product 2");
		product1.setQuantity(2);
		// Initialise other fields
		productsMap.put(product1.getSku(), product1);
		productsMap.put(product2.getSku(), product2);
	}

	// Query to find the products from Mongo db by sku
	@Override
	public List<ProductEntity> findProductsBySku(List<String> skuList) {
		List<ProductEntity> productEntityList = new ArrayList<ProductEntity>();
		for (String sku : skuList) {
			if (productsMap.containsKey(sku))
				productEntityList.add(productsMap.get(sku));
		}
		return productEntityList;
	}

	@Override
	public void updateProductsQuantity(List<ProductEntity> updatedProductsList) {
		updatedProductsList.stream().forEach(p -> {
			productsMap.get(p.getSku()).setQuantity(p.getQuantity());
		});
	}

	@Override
	public void updateProductQuantity(ProductEntity updatedProduct) {
		productsMap.get(updatedProduct.getSku()).setQuantity(updatedProduct.getQuantity());
	}

}
