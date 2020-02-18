package com.zjl.springcloud.dao;

import com.zjl.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    public List<Dept> selectAll();

    public Dept selectBydeptno(Long id);
}
