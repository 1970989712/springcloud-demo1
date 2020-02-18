package com.zjl.springcloud.conterllor;


import com.zjl.springcloud.entity.Dept;


import com.zjl.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("feign")
public class DeptConterllor {

    @Autowired
    private DeptClientService service;


    @RequestMapping(value = "/list",method = RequestMethod.GET )
    public List<Dept> getlist(){
        return service.getlist();
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return service.get(id);
    }

}
