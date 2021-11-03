package com.eureka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-02 16:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

	private Integer id;
	private String orderNo;
	private String orderAddress;
	private Double totalPrice;
	private List<Product> productList;
}
