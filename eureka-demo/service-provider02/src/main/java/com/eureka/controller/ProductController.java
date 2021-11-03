package com.eureka.controller;

import com.eureka.entiy.Product;
import com.eureka.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-02 15:32
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Resource
	private ProductService productService;

	@GetMapping("/list")
	public List<Product> selectProductList() {
		return productService.selectProductList();
	}
}
