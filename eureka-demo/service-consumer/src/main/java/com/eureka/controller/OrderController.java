package com.eureka.controller;

import com.eureka.entity.Order;
import com.eureka.entity.Product;
import com.eureka.service.OrderService;
import com.eureka.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-02 16:26
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderService orderService;
	@Resource
	private ProductService productService;

	@GetMapping("/{id}")
	public Order selectOrderByDis(@PathVariable Integer id) {
		return orderService.selectOrderById(id);
	}

	@GetMapping("/product/{id}")
	public Order selectOrderById(@PathVariable Integer id) {
		return orderService.selectOrderByProductId(id);
	}

	@PostMapping("/product/save")
	public Map<Object, Object> saveProduct(Product product) {
		return productService.saveProduct(product);
	}

	@PostMapping("/product/single")
	public Product queryProductById(Integer id) {
		return productService.queryProductById(id);
	}
}
