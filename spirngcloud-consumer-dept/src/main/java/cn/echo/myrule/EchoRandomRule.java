package cn.echo.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 源代码来自官方随机算法类RandomRule ，相当于重写此类
 */
public class EchoRandomRule extends AbstractLoadBalancerRule {

    /**
     * 每个机器访问五次，五次之后换下一个服务(3个服务)
     * 指针，访问次数：total = 0 ，如果等于5，就指向下一个服务节点
     * 服务节点：index = 0，如果total = 5，index++；
     */

    private int total = 0;  //被调用的次数
    private int currentIndex = 0;   //当前谁在提供服务

//    @edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
//        默认随机算法
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
//            判断线程是否中断
            if (Thread.interrupted()) {
                return null;
            }
//            获取活着的服务
            List<Server> upList = lb.getReachableServers();
//            获取所有的服务
            List<Server> allList = lb.getAllServers();


            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            /*
             //原有算法
//            生成区间随机数
            int index = chooseRandomInt(serverCount);
//            从活着的服务中，随机获取一个
            server = upList.get(index);
             */

            /*======  自定义代码  ======*/
            if (total < 5) {
//                如果调用的服务节点大于可用节点数则将服务节点置0
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
//                从活着的服务中，获取指定的服务来进行操作
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
            }

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		
	}
}
