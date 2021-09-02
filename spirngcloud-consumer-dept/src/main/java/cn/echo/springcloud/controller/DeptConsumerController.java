package cn.echo.springcloud.controller;

import cn.echo.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Package: cn.echo.springcloud.controller
 * @Author: pluto
 * @CreateTime: 2021/8/28 3:29 下午
 * @Description: 消费者控制层
 **/
@RestController
public class DeptConsumerController {

    /**
     * 消费者，不应该有Service层
     * Spring Boot 支持 RestFul 就有 RestTemplate
     *  RestTemplate ... 供直接调用，只要注册到Spring中
     */

    @Autowired
    private RestTemplate restTemplate;      //提供多种便捷访问远程HTTP服务的方法，简单的RestFul服务模版

    private static final String REST_URL_PREFIX = "http://localhost:8081";

    @RequestMapping("/consumer/dept/queryById/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/queryById/" + id, Dept.class);
    }

    @RequestMapping("consumer/dept/add")
    public int add(@RequestBody Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Integer.class);
    }

    @RequestMapping("consumer/dept/query")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/query", List.class);
    }

}
