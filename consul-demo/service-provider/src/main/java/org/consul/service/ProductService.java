package org.consul.service;

import org.consul.entity.Product;

import java.util.List;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-03 17:04
 */
public interface ProductService {

	List<Product> selectProductList();
}
