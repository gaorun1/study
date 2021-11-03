package com.consul.controller;

import com.consul.entity.Order;
import com.consul.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderService orderService;

	@GetMapping("/dis/{id}")
	public Order selectOrderByDis(@PathVariable Integer id) {
		return orderService.selectOrderByDis(id);
	}

	@GetMapping("/ld/{id}")
	public Order selectOrderByLd(@PathVariable Integer id) {
		return orderService.selectOrderByLd(id);
	}

	@GetMapping("/lda/{id}")
	public Order selectOrderByLda(@PathVariable Integer id) {
		return orderService.selectOrderByLda(id);
	}
}