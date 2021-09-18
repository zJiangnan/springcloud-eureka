package cn.echo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Package: cn.echo.springcloud
 * @Author: pluto
 * @CreateTime: 2021/9/16 4:34 下午
 * @Description: 服务端配置中心启动类
 **/
@SpringBootApplication
@EnableConfigServer //开启配置服务
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class);
    }
}
