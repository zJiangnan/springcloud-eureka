package cn.echo.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
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
@EnableCircuitBreaker   //添加对熔断的支持
public class SpringcloudProviderDeptHystrix {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderDeptHystrix.class, args);
    }

    /**
     * 增加一个Servlet，为了配合监控使用
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        servletRegistrationBean.addUrlMappings("/actuator/hystrix.stream");
        return servletRegistrationBean;
    }

}
