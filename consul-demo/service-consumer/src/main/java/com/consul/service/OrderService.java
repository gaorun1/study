package com.consul.service;

import com.consul.entity.Order;

public interface OrderService {

	Order selectOrderByDis(Integer id);
	Order selectOrderByLd(Integer id);
	Order selectOrderByLda(Integer id);
}