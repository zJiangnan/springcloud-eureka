package cn.echo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Package: cn.echo.springcloud
 * @Author: pluto
 * @CreateTime: 2021/9/15 5:52 下午
 * @Description: Zuul启动类
 **/
@SpringBootApplication
@EnableZuulProxy    //开启 Zuul 代理，并不是开启 @EnableZuulServer 服务
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }
}
