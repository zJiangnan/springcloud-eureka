package cn.echo.springcloud.controller;

import cn.echo.springcloud.pojo.Dept;
import cn.echo.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Package: cn.echo.springcloud.controller
 * @Author: pluto
 * @CreateTime: 2021/8/28 3:29 下午
 * @Description: 消费者控制层
 **/
@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping("/consumer/dept/queryById/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.queryById(id);
    }

    @RequestMapping("/consumer/dept/add")
    public int add(@RequestBody Dept dept) {
        return deptClientService.add(dept);
    }

    @RequestMapping("/consumer/dept/query")
    public List<Dept> list() {
        return deptClientService.all();
    }

}
