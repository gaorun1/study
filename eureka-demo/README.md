# 项目说明 #

```
eureka-server    eureka注册中心
eureka-server02  eureka注册中心
eureka-provider  服务提供端
umner 服务消费端
```

## 所有项目跑起来之后测试地址

服务提供端，查询API
`http://localhost:7070/product/list`

服务消费端，查询API

- 基于元数据方式(DiscoveryClient)
  `http://localhost:9090/dis/1`

- 基于LoadBalancerClient方式请求
  `http://localhost:9090/ld/1`

- 基于loadBalancer注解方式请求
  `http://localhost:9090/lda/1`


## 优雅停服

服务提供者添加pom配置
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
添加项目配置application.yml
```yml
management:
  endpoints:
    web:
      exposure:
        include: shutdown #开启 shutdown 端点访问
  endpoint:
    shutdown:
      enabled: true #开启shutdown 实现优雅停服
```
查看地址
`http://localhost:7070/actuator`

使用POST方式调用停服接口`http://localhost:7070/actuator/shutdown`

## 安全认证

注册中心添加pom配置
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

添加项目配置application.yml
```yml
spring:
  security:
    user:
      name: root
      password: 123456
```

修改注册链接，所有项目都要改
`http://root:123456@localhost:8762/eureka/`

过滤CSRF
```java
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		http.csrf().ignoringAntMatchers("/eureka/**"); //忽略eureka/**所有请求安全控制
	}


	//关闭项目csrf验证
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().anyRequest()
//				.authenticated()
//				.and().httpBasic();
//	}
}
```