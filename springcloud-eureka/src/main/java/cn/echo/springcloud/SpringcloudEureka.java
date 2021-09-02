package cn.echo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Package: cn.echo.springcloud
 * @Author: pluto
 * @CreateTime: 2021/8/28 5:27 下午
 * @Description: Eureka服务配置端
 **/
@SpringBootApplication
@EnableEurekaServer //启动 Eureka 服务端启动类，可以接收别人注册进来
public class SpringcloudEureka {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEureka.class, args);
    }

}


