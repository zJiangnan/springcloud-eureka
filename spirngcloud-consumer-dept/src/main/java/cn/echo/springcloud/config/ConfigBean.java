package cn.echo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Package: cn.echo.springcloud.config
 * @Author: pluto
 * @CreateTime: 2021/8/28 3:35 下午
 * @Description: 配置RestTemplate的bean对象
 **/
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced // Ribbon 配置负载均衡实现 RestTemplate
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
