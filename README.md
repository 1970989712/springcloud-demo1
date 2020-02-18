# springcloud-demo1

microservicecloud：父类组件维护版本信息

microservicecloud-api：公用文件，实体类放置于此

microservicecloud-config-3344：springcloudconfig服务端用于访问云端配置文件信息

microservicecloud-config-client-3355：访问3344并通过其读取云端配置文件信息使其在microservicecloud-config-client-3355配置中生效

microservicecloud-consumer-80：使用ribbon负载均衡调用微服务

microservicecloud-consumer-feign：fegn接口调用demo

microservicecloud-consumer-hystrix-dashboard: hystrix-dashboard 豪猪监控微服务请求

microservicecloud-eureka-7001(7002,7003): eureka 服务注册中心管理微服务注册（服务发现discovery 在微服务中查询）

microservicecloud-providerdept-8001(8002,8003)：部门查询微服务

microservicecloudproviderdept-hystrix-8001：添加了熔断器的微服务（--一般不在此定义hystrix（一般通过aop在服务调用端定义））

microservicecloud-zuul-gateway-9527：zuul 路由网关demo








