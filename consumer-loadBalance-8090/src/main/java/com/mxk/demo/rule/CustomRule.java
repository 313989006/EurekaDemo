package com.mxk.demo.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @ClassName CustomRule
 * @Description TODO
 * @Author ma.kangkang
 * @Date 2020/12/20 15:46
 **/
public class CustomRule implements IRule {

    private ILoadBalancer loadBalancer;

    private List<Integer> excludePorts;

    public CustomRule() {
    }

    public CustomRule(List<Integer> excludePorts) {
        this.excludePorts = excludePorts;
    }

    @Override
    public Server choose(Object o) {

        // 获取到所有可用的 Servers （UP状态）
        List<Server> servers = loadBalancer.getReachableServers();
        // 将指定端口的 Server 排除
        List<Server> availableServers = this.getAvailableServers(servers);
        // 从剩余的 Server 中随机选举一个Server
        return this.getAvailableRandomServers(availableServers);
    }

    private Server getAvailableRandomServers(List<Server> availableServers) {
        int index = new Random().nextInt(availableServers.size());
        return availableServers.get(index);

    }

    private List<Server> getAvailableServers(List<Server> servers) {
//        List<Server> aservers = new ArrayList<>();
//        for (Server server : servers) {
//            boolean isExclude = false;
//            for (Integer port : excludePorts) {
//                if (server.getPort() == port){
//                    isExclude = true;
//                    break;
//                }
//            }
//            if (!isExclude){
//                aservers.add(server);
//            }
//        }
        List<Server> aservers = servers.stream()
                .filter(server -> excludePorts.stream().noneMatch(port -> port == server.getPort()))
                .collect(Collectors.toList());
        return aservers;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer iLoadBalancer) {
        this.loadBalancer = iLoadBalancer;

    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return loadBalancer;
    }
}
