package cn.echo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Package: cn.echo.springcloud
 * @Author: pluto
 * @CreateTime: 2021/8/27 6:39 下午
 * @Description: 提供者启动类
 **/
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient //开启客户端的服务注册，在服务启动后自动注册到eureka中
@EnableDiscoveryClient  //服务发现：服务注册
public class SpringcloudProviderDept {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderDept.class, args);
    }

}
