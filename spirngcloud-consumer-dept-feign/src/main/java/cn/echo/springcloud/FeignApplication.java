package cn.echo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Package: cn.echo.springcloud
 * @Author: pluto
 * @CreateTime: 2021/8/28 3:51 下午
 * @Description: 消费者启动器
 **/
@SpringBootApplication
@EnableEurekaClient //Ribbon 和 Eureka 整合后，客户端可以直接调用方法，不再关心IP和port了，Ribbon会自动选择
@EnableFeignClients(basePackages = {"cn.echo.springcloud"})
//@ComponentScan("cn.echo.springcloud") //开启包扫描
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

}
