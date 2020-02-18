package com.zjl.springcloud.service.impl;

import com.zjl.springcloud.dao.DeptDao;
import com.zjl.springcloud.entity.Dept;
import com.zjl.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao dao;

    @Override
    public List<Dept> getlist() {
        return dao.selectAll();
    }

    @Override
    public Dept get(Long id) {
        return dao.selectBydeptno(id);
    }
}
