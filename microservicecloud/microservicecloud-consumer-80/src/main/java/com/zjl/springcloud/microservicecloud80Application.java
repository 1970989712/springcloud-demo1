package com.zjl.springcloud;


import com.zjl.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

//(exclude= {DataSourceAutoConfiguration.class}) 声明不配置数据连接
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@RibbonClient(name="microservicecloud-dept",configuration=MyselfRule.class) //指定对应对哪个个微服务使用自定义的算法（MyselfRule不能在启动类（带有@ComponentScan注解）包及子包下）
public class microservicecloud80Application {
        public static void main(String[] args) {
            SpringApplication.run(microservicecloud80Application.class, args);
        }
}