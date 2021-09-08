package cn.echo.springcloud.service.impl;

import cn.echo.springcloud.mapper.DeptMapper;
import cn.echo.springcloud.pojo.Dept;
import cn.echo.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Package: cn.echo.springcloud.service.impl
 * @Author: pluto
 * @CreateTime: 2021/8/27 6:27 下午
 * @Description: 部门业务实现层
 **/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper mapper;

    @Override
    public int addDept(Dept dept) {
        return mapper.addDept(dept);
    }

    @Override
    public Dept querById(Long deptno) {
        return mapper.querById(deptno);
    }

    @Override
    public List<Dept> queryAll() {
        return mapper.queryAll();
    }
}
