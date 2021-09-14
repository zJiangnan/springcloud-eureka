package cn.echo.springcloud.controller;

import cn.echo.springcloud.pojo.Dept;
import cn.echo.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Package: cn.echo.springcloud.controller
 * @Author: pluto
 * @CreateTime: 2021/8/27 6:30 下午
 * @Description: 部门后端控制器
 **/
@RestController
@Api(tags = "部门管理", description = "部门管理")
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService service;

    @ApiOperation(value = "查询指定部门")
    @GetMapping("/queryById/{id}")
    @HystrixCommand(fallbackMethod = "hystrixQueryById")
    public Dept queryById(@PathVariable("id") Long id) {
        Dept dept = service.querById(id);
        if (dept == null) {
            throw new RuntimeException("未找到指定信息");
        }
        return dept;
    }

//    备选方法
    public Dept hystrixQueryById(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("未找到指定信息")
                .setDbSource("no this database in MySQL!");
    }

}
