package com.zjl.springcloud.configbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  //配置
public class ConfigBean {

    @Bean //注入sprigboot自带的RestTemplate（rest请求调用）
    @LoadBalanced  //启动负载均衡客户端
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean   //修改负载均衡算法
//    public IRule myRule(){
//       //return new RandomRule(); //用ribbon自带的随机替换默认的轮询
//        return new RetryRule(); //先用轮询,若微服务出现问题在访问几次后就会自动跳过此服务
//    }

}
