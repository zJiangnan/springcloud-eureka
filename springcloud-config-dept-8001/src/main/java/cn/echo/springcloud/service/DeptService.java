package cn.echo.springcloud.service;

import cn.echo.springcloud.pojo.Dept;

import java.util.List;

/**
 * @Package: cn.echo.springcloud.service
 * @Author: pluto
 * @CreateTime: 2021/8/27 6:26 下午
 * @Description: 部门业务接口层
 **/
public interface DeptService {

    int addDept(Dept dept);

    Dept querById(Long deptno);

    List<Dept> queryAll();

}
