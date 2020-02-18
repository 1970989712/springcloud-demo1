package com.zjl.springcloud.service;

import com.zjl.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * Hystrix 服务熔断在FallbackFactory定义使其与业务解耦
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public List<Dept> getlist() {
                List<Dept> list = new ArrayList<>();
                Dept dept = new Dept();
                dept.setDname("服务已停止").setDeptno(1L);
                list.add(dept);
                return list;
            }

            @Override
            public Dept get(Long id) {
                return new Dept(1l,"xxxx","找不到该数据");
            }
        };
    }
}
