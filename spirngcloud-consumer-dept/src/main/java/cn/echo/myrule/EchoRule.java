package cn.echo.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package: cn.echo.myrule
 * @Author: pluto
 * @CreateTime: 2021/9/8 3:33 下午
 * @Description: 自定义负载均衡算法
 **/
@Configuration  //表示这是一个配置类
public class EchoRule {

    @Bean
    public IRule myRule() {
//        return new RandomRule();  //修改自定义的随机算法
        return new EchoRandomRule();    //使用自定义的算法
    }

}
