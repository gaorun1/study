# Ribbon项目说明 #
- 本项目在eureka的基础上学习Ribbon的使用，项目代码也是基于eureka分支做增减

```
eureka-server       eureka注册中心
eureka-server02     eureka注册中心
service-provider    服务提供端
service-consumer    服务消费端
service-consumer02  服务消费端
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

## 点对点方式访问服务提供
- 绕过注册中心，一般开发时使用

1. 注释eureka引用，添加ribbon引用
```xml
<!--		<dependency>-->
<!--			<groupId>org.springframework.cloud</groupId>-->
<!--			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>-->
<!--		</dependency>-->
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>
```
2. 修改项目配置application.yml
```yml
#指定服务使用何种负载均衡策略
service-provider:
  ribbon:
    #指定具体服务提供者列表
    listOfServers: http://localhost:7070,http://localhost:7071

#关闭eureka
ribbon:
  eureka:
    enabled: false
```