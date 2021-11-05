package com.eureka.service;

import com.eureka.entiy.Product;

import java.util.List;
import java.util.Map;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-02 15:27
 */
public interface ProductService {
	List<Product> selectProductList();

	Product selectProductById(int id);

	Product queryProductById(int id);

	Map<Object, Object> createProduct(Product product);
}
