# 项目说明 #
- 本项目在Ribbon的基础上学习OpenFeign的使用，项目代码也是基于Ribbon分支做增减

```
eureka-server       eureka注册中心
eureka-server02     eureka注册中心
service-provider    服务提供端
service-provider    服务提供端
service-consumer    服务消费端 OpenFeign方式
```
- 使用步骤
1. 服务消费端添加Feign依赖
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```
2. 创建业务接口，添加 `@FeignClient` 注解，声明需要调用的服务，使用Spring注解`@GetMapping`注解配置服务地址及参数
```java
@FeignClient("service-provider")
public interface ProductService {

	@GetMapping("/product/list")
	List<Product> selectProductList();
}
```
3. 启动类添加`@EnableFeignClients`注解，激活Feign组件
```java
@SpringBootApplication
@EnableFeignClients
public class ServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerApplication.class);
	}
}
```
## 全局设置负载均衡策略
- 服务消费者配置负载均衡策略，在启动类中添加策略Bean
```java
    @Bean
    public RandomRule randomRule() {
        return new RandomRule();
    }
```
## 指定服务使用何种负载均衡策略
```yml
service-provider-服务名称:
  ribbon:
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
```