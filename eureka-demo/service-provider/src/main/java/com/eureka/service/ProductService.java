package com.eureka.service;

import com.eureka.entiy.Product;

import java.util.List;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-02 15:27
 */
public interface ProductService {
	List<Product> selectProductList();
}
