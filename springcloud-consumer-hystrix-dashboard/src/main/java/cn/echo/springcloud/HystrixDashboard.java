package cn.echo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Package: cn.echo.springcloud
 * @Author: pluto
 * @CreateTime: 2021/9/15 1:14 下午
 * @Description: 启动类
 **/
@SpringBootApplication
@EnableHystrixDashboard //开启监控页面
public class HystrixDashboard {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard.class);
    }
}
