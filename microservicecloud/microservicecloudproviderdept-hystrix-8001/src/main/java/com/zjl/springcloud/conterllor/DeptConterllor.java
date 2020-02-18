package com.zjl.springcloud.conterllor;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
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

    /**
     * 模拟服务出现问题
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "textHystrix_Get")  //调用hystrix诺此方法出现异常则返回textHystrix_Get方法定义的返回数据
    public Dept get(@PathVariable("id") Long id){
       Dept dept = servie.get(id);
       if(null==dept){
           throw new RuntimeException("查询数据出现异常");
       }
        return dept;
    }

    /**
     *  在HystrixCommand定义自定义返回方法但
     * （一般情况下会将其在FallbackFactory 中定义，不单独定义在此）
     * @param id
     * @return
     */
    public Dept textHystrix_Get(@PathVariable("id") Long id){
        Dept dept = new Dept(1l,"xxxx","找不到该数据");
        return dept;
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
