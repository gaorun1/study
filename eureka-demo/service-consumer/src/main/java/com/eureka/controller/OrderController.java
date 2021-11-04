package com.eureka.controller;

import com.eureka.entity.Order;
import com.eureka.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

	@GetMapping("/{id}")
	public Order selectOrderByDis(@PathVariable Integer id) {
		return orderService.selectOrderById(id);
	}
}
