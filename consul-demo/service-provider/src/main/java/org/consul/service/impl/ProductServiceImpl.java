package org.consul.service.impl;

import org.consul.entity.Product;
import org.consul.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-03 17:05
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> selectProductList() {
		return Arrays.asList(new Product(1, "华为手机", 1, 5800D),
		                     new Product(2, "联想笔记本", 2, 6800D),
		                     new Product(3, "小米平板", 3, 6700D));
	}
}
