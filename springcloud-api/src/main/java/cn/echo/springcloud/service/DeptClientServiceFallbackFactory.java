package cn.echo.springcloud.service;

import cn.echo.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Package: cn.echo.springcloud.service
 * @Author: pluto
 * @CreateTime: 2021/9/14 5:51 下午
 * @Description: 服务降级
 **/
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("此服务已关闭，请稍后重试")
                        .setDbSource("无数据源");
            }

            @Override
            public List<Dept> all() {
                return null;
            }

            @Override
            public int add(Dept dept) {
                return 0;
            }
        };
    }
}
