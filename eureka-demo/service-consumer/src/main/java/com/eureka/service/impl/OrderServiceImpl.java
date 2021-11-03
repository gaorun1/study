package com.eureka.service.impl;

import com.eureka.entity.Order;
import com.eureka.entity.Product;
import com.eureka.service.OrderService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gaorun
 * @Description
 * @create 2021-11-02 16:12
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private RestTemplate restTemplate;
	@Resource
	private RestTemplate restTemplateLb;

	@Resource
	private DiscoveryClient discoveryClient;

	@Resource
	private LoadBalancerClient loadBalancerClient;

	//元数据方式请求
	@Override
	public Order selectOrderByDis(Integer id) {
		return new Order(id, "order-001", "中国", 212121D, selectProductListByDiscoveryClient());
	}

	//loadBalancer方式请求
	@Override
	public Order selectOrderByLd(Integer id) {
		return new Order(id, "order-001", "中国", 212121D, selectProductListByLoadBalancer());
	}

	//loadBalancer注解方式请求
	@Override
	public Order selectOrderByLda(Integer id) {
		return new Order(id, "order-001", "中国", 212121D, selectProductListByLoadBalancerAnnotation());
	}

	private List<Product> selectProductListByDiscoveryClient() {
		StringBuffer sb = null;
		//获取服务列表
		List<String> serviceIds = discoveryClient.getServices();
		if (CollectionUtils.isEmpty(serviceIds)) {
			return null;
		}
		//根据服务名称获取服务
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("service-provider");
		if (CollectionUtils.isEmpty(serviceInstances)) {
			return null;
		}
		ServiceInstance si = serviceInstances.get(0);
		sb = new StringBuffer();
		sb.append("http://" + si.getHost() + ":" + si.getPort() + "/product/list");
		ResponseEntity<List<Product>> response = restTemplate.exchange(sb.toString(),
		                                                               HttpMethod.GET,
		                                                               null,
		                                                               new ParameterizedTypeReference<List<Product>>() {});
		return response.getBody();
	}


	private List<Product> selectProductListByLoadBalancer() {
		StringBuffer sb = null;

		//根据服务名称获取服务
		ServiceInstance si = loadBalancerClient.choose("service-provider");
		if (si == null) {
			return null;
		}
		sb = new StringBuffer();
		sb.append("http://" + si.getHost() + ":" + si.getPort() + "/product/list");
		ResponseEntity<List<Product>> response = restTemplate.exchange(sb.toString(),
		                                                               HttpMethod.GET,
		                                                               null,
		                                                               new ParameterizedTypeReference<List<Product>>() {});
		return response.getBody();
	}

	private List<Product> selectProductListByLoadBalancerAnnotation() {
		ResponseEntity<List<Product>> response = restTemplateLb.exchange(
				"http://service-provider/product/list",
		        HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Product>>() {});
		return response.getBody();
	}
}
