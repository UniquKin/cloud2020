package com.atguigu.springcloud.lb;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinRule_ZRC extends AbstractLoadBalancerRule {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    public Server choose(ILoadBalancer lb,Object key){
        if (lb == null) {
            return null;
        } else {
            Server server = null;
            int count = 0;
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            int upCount = reachableServers.size();
            int serverCount = allServers.size();
            int nextServerIndex = getAndIncrement() % serverCount;
            server = (Server) allServers.get(nextServerIndex);
            return server;
        }
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current+1;
        }while (!atomicInteger.compareAndSet(current, next));
        System.out.println("*****第几次访问，次数next："+next);
        return next;
    }
}
