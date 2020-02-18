package com.zjl.springcloud.service;

import com.zjl.springcloud.entity.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeptService {

    public List<Dept> getlist();

    public Dept get(Long id);

}
