# 项目说明 #

## Consul
注册中心使用Consul
- 运行命令
`consul.exe agent -dev -client=0.0.0.0`

## 模块说明
```
service-provider  服务提供端
service-consumer  服务消费端
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