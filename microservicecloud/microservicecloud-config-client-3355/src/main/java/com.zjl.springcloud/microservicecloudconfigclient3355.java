package com.zjl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class microservicecloudconfigclient3355 {

        public static void main(String[] args) {

            SpringApplication.run(microservicecloudconfigclient3355.class, args);
        }
}
