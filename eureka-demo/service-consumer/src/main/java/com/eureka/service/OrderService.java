package com.eureka.service;

import com.eureka.entity.Order;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-02 16:11
 */
public interface OrderService {

	Order selectOrderByDis(Integer id);
	Order selectOrderByLd(Integer id);
	Order selectOrderByLda(Integer id);
}
