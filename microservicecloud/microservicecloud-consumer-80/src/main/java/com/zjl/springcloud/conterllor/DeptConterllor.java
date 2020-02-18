package com.zjl.springcloud.conterllor;

import com.zjl.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("80")
public class DeptConterllor {

    //private String resturl ="http://localhost:8001";
    private String resturl ="http://microservicecloud-dept"; //通过服务名调用


    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/list",method = RequestMethod.GET )
    public List<Dept> getlist(){
       return restTemplate.getForObject(resturl+"/dept/list",List.class);
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
      return restTemplate.getForObject(resturl+"/dept/get/"+id,Dept.class);
    }


}
