package com.zjl.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//(exclude= {DataSourceAutoConfiguration.class}) 声明不配置数据连接
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class},scanBasePackages = "com.zjl.springcloud")
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.zjl.springcloud"})
public class microservicecloudfeignApplication {
        public static void main(String[] args) {
            SpringApplication.run(microservicecloudfeignApplication.class, args);
        }
}