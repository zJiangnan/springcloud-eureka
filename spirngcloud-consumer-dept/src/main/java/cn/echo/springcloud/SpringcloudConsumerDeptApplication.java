package cn.echo.springcloud;

import cn.echo.myrule.EchoRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Package: cn.echo.springcloud
 * @Author: pluto
 * @CreateTime: 2021/8/28 3:51 下午
 * @Description: 消费者启动器
 **/
@SpringBootApplication
@EnableEurekaClient //Ribbon 和 Eureka 整合后，客户端可以直接调用方法，不再关心IP和port了，Ribbon会自动选择
//在微服务启动的时候就能去加载自定义Ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT", configuration = EchoRule.class)
public class SpringcloudConsumerDeptApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerDeptApplication.class, args);
    }

}
