package com.xcl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RedisConfig {

    @Bean
    JedisCluster jedisCluster(){

       JedisCluster jedisCluster;
        // 添加集群的服务节点Set集合
        Set<HostAndPort> hostAndPortsSet = new HashSet<HostAndPort>();
        // 添加节点
        hostAndPortsSet.add(new HostAndPort("192.168.6.140", 7001));
        hostAndPortsSet.add(new HostAndPort("192.168.6.140", 7002));
        hostAndPortsSet.add(new HostAndPort("192.168.6.140", 7003));
        hostAndPortsSet.add(new HostAndPort("192.168.6.140", 7007));

        // Jedis连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxIdle(20);
        // 最大连接数, 默认8个
        jedisPoolConfig.setMaxTotal(100);
        //最小空闲连接数, 默认0
        jedisPoolConfig.setMinIdle(8);
        // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        jedisPoolConfig.setMaxWaitMillis(10000); // 设置10秒
        //对拿到的connection进行validateObject校验
        jedisPoolConfig.setTestOnBorrow(true);
        jedisCluster = new JedisCluster(hostAndPortsSet, jedisPoolConfig);
        return jedisCluster;
    }
}
