package com.zjl.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //服务注册
@EnableDiscoveryClient //服务发现
public class microservicecloud8001Application {
        public static void main(String[] args) {
            SpringApplication.run(microservicecloud8001Application.class, args);
        }
}