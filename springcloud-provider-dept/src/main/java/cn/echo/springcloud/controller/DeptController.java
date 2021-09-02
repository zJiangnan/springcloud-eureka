package cn.echo.springcloud.controller;

import cn.echo.springcloud.pojo.Dept;
import cn.echo.springcloud.service.DeptService;
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
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService service;

    /* 获取一些配置信息，得到具体的微服务 */
    @Autowired
    private DiscoveryClient client;

    @ApiOperation(value = "新增部门")
    @PostMapping("/add")
    public int add(@RequestBody Dept dept) {
        return service.addDept(dept);
    }

    @ApiOperation(value = "查询指定部门")
    @GetMapping("/queryById/{id}")
    public Dept queryById(@PathVariable("id") Long id) {
        return service.querById(id);
    }

    @ApiOperation(value = "查询所有部门")
    @GetMapping("/query")
    public List<Dept> query() {
        return service.queryAll();
    }

//    注册进来的微服务，获取一些消息
    @GetMapping("/discovery")
    public Object discovery() {
//        获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);

//        得到一个具体的微服务信息，通过具体的微服务ID：applicationName；
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId()
            );
        }
        return this.client;
    }

}
