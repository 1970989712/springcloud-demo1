package com.zjl.springcloud.conterllor;

import com.zjl.springcloud.entity.Dept;
import com.zjl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dept")
public class DeptConterllor {

    @Autowired
    private DeptService servie;
    //服务发现（查询注册的微服务信息）
    @Autowired
    private DiscoveryClient client;


    @RequestMapping(value = "/list",method = RequestMethod.GET )
    public List<Dept> getlist(){
       return servie.getlist();
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
       return servie.get(id);
    }

    @RequestMapping(value = "discovery")
    public Object discovery(){
       List<String> list = client.getServices(); //得到所有注册服务
       System.out.println("-----"+list);

       List<ServiceInstance> srvlist = client.getInstances("microservicecloud-dept");
       for(ServiceInstance se:srvlist){
        System.out.println(se.getServiceId()+"\t"+se.getHost()+"\t"+se.getUri());
       }
     return this.client;
    }
}
