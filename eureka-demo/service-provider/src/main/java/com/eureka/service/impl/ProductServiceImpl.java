package com.eureka.service.impl;

import com.eureka.entiy.Product;
import com.eureka.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-02 15:28
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Override
	public List<Product> selectProductList() {
		return Arrays.asList(
				new Product(1, "华为手机 7070", 2, 58888D),
				new Product(2, "联想笔记本", 1, 68888D),
				new Product(3, "小米平板", 5, 28888D));
	}

	@Override
	public Product selectProductById(int id) {
		return new Product(1, "华为手机 7070", 2, 58888D);
	}

	@Override
	public Product queryProductById(int id) {
		return new Product(id, "测试", 2, 333D);
	}


	@Override
	public Map<Object, Object> createProduct(Product product) {
		System.out.println(product);
		return new HashMap<Object, Object>()
		{{
			put("code", 200);
			put("message", "新增成功");
		}};
	}
}
