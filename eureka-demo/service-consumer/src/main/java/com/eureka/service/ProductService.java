package com.eureka.service;

import com.eureka.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-04 16:54
 */
@FeignClient("service-provider")
public interface ProductService {

	@GetMapping("/product/list")
	List<Product> selectProductList();

	@GetMapping("/product/{id}")
	Product selectProductById(@PathVariable Integer id);
}
