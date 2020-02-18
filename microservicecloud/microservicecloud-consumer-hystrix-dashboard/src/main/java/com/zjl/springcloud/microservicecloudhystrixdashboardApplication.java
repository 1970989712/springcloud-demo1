package com.zjl.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

//(exclude= {DataSourceAutoConfiguration.class}) 声明不配置数据连接
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableHystrixDashboard
public class microservicecloudhystrixdashboardApplication {
        public static void main(String[] args) {
            SpringApplication.run(microservicecloudhystrixdashboardApplication.class, args);
        }
}