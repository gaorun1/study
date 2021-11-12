package com.eureka.controller;

import com.eureka.entiy.Product;
import com.eureka.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

	@GetMapping("/{id}")
	public Product selectProductById(@PathVariable int id) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return productService.selectProductById(id);
	}

	@PostMapping("/save")
	public Map<Object, Object> saveProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PostMapping("/single")
	public Product queryProductById(@RequestBody Integer id) {
		return productService.queryProductById(id);
	}
}
