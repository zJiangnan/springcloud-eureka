package cn.echo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Package: cn.echo.springcloud
 * @Author: pluto
 * @CreateTime: 2021/9/17 4:19 下午
 * @Description: 客户端配置中心启动类
 **/
@SpringBootApplication
public class ConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }
}
