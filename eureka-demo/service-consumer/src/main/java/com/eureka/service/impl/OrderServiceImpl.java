package com.eureka.service.impl;

import com.eureka.entity.Order;
import com.eureka.service.OrderService;
import com.eureka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-02 16:12
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductService productService;

	@Override
	public Order selectOrderById(Integer id) {
		return new Order(id, "order-001", "中国", 212121D,
		                 productService.selectProductList());
	}

	@Override
	public Order selectOrderByProductId(Integer id) {
		return new Order(id, "order-001", "中国", 212121D,
		                 Arrays.asList(productService.selectProductById(id)));
	}
}
