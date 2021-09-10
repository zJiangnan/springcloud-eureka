package cn.echo.springcloud.service;

import cn.echo.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Package: cn.echo.springcloud.service
 * @Author: pluto
 * @CreateTime: 2021/9/9 11:42 上午
 * @Description: Feign服务调用
 **/
@Service
//调用指定服务，参数：value调用的服务名称；url：调用的前缀；contextId：进行多个Feign调用时取别名
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {

    @GetMapping("/dept/queryById/{id}")
    Dept queryById(@PathVariable("id") Long id);

    @GetMapping("/dept/query")
    List<Dept> all();

    @PostMapping("/dept/add")
    int add(@RequestBody Dept dept);

}
