package com.zjl.springcloud.service;

import com.zjl.springcloud.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用feign负载均衡 提供调用接口
 * value 提供接调用口的微服务
 * fallbackFactory  自定义Hystrix 出错返回值
 */
@FeignClient(value = "microservicecloud-dept",fallbackFactory = DeptClientServiceFallbackFactory.class)
@Repository
public interface DeptClientService {

    //在此调用的地址为微服务暴露的接口
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET )
    public List<Dept> getlist();

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id")Long id);

}
