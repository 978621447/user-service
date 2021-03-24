package com.nantian.user.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author WangJinYi 2021/3/24
 */
@Component
public class JedisPoolUtil {

    @Autowired
    private JedisPool jedisPool;

    private JedisPoolUtil() {
    }

    public Jedis getJedis(){
        return jedisPool.getResource();//从连接池中取一个Jedis对象
    }

    public static void release(Jedis jedis){
        if(jedis != null){
            jedis.close();//将jedis放回连接池
        }
    }

}
