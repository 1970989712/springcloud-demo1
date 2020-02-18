package com.zjl.myrule;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 自定义负载均衡算法
 */
public class MyRandomRule extends AbstractLoadBalancerRule {

    private int total = 0; //计数
    private int myserveindex = 0; //第几台服务

        /**
         * 满足五次再进行跳转
         */
        public Server choose(ILoadBalancer lb, Object key) {
            if (lb == null) {
                return null;
            }
            Server server = null;

            while (server == null) {
                if (Thread.interrupted()) {
                    return null;
                }
                List<Server> upList = lb.getReachableServers();  //活着的微服务
                List<Server> allList = lb.getAllServers();

                int serverCount = allList.size();
                if (serverCount == 0) {
                    /*
                     * No servers. End regardless of pass, because subsequent passes
                     * only get more restrictive.
                     */
                    return null;
                }

//                int index = chooseRandomInt(serverCount);
//                server = upList.get(index);

                if(total<5){
                    server = upList.get(myserveindex);
                    total++;
                }else{
                    total = 0;
                    myserveindex++;
                    if(myserveindex>=upList.size()){
                        myserveindex = 0;
                    }
                }

                if (server == null) {
                    /*
                     * The only time this should happen is if the server list were
                     * somehow trimmed. This is a transient condition. Retry after
                     * yielding.
                     */
                    Thread.yield();
                    continue;
                }

                if (server.isAlive()) {
                    return (server);
                }

                // Shouldn't actually happen.. but must be transient or a bug.
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
        public void initWithNiwsConfig(IClientConfig iClientConfig) {
        }
}



