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
  

本次测试在docker上跑的，不太好，还是推荐虚拟机去
```shell
开发时使用的命令
consul.exe agent -dev -client=0.0.0.0 -bind=169.254.220.91 -data-dir=C:\Users\Administrator\Desktop\consul_1.10.3_windows_amd64\data -node=consul-client2 -ui
pause

生产环境，consul客户端和项目放在一起
```

## Docker测试
```shell
拉取consul镜像

docker pull consul:latest

创建文件 docker-compose-consul-cluster.yml,内容如下

version: '3'
services:
  consul-server1:
    image: consul:latest
    hostname: "consul-server1"
    ports:
      - "8501:8500"
      - "8301:8301"
      - "8300:8300"
      - "53"
    volumes:
      - ./server1-data:/consul/data
    command: "agent -server -bootstrap-expect 3 -ui -disable-host-node-id -client 0.0.0.0"
  consul-server2:
    image: consul:latest
    hostname: "consul-server2"
    ports:
      - "8502:8500"
      - "53"
    volumes:
      - ./server2-data:/consul/data
    command: "agent -server -ui -join consul-server1 -disable-host-node-id -client 0.0.0.0"
    depends_on:
      - consul-server1
  consul-server3:
    image: consul:latest
    hostname: "consul-server3"
    ports:
      - "8503:8500"
      - "53"
    volumes:
      - ./server3-data:/consul/data
    command: "agent -server -ui -join consul-server1 -disable-host-node-id -client 0.0.0.0"
    depends_on:
      - consul-server1
  consul-client1:
    image: consul:latest
    hostname: "consul-client1"
    ports:
      - "8500:8500"
      - "53"
    volumes:
      - ./client1-data:/consul/data
    command: "agent -ui -join consul-server1 -disable-host-node-id -client 0.0.0.0"
    depends_on:
      - consul-server1
      
      
执行命令
docker-compose -f docker-compose-consul-cluster.yml up -d      
```