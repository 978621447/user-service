package com.nantian.user.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @author WangJinYi 2021/3/9
 */
@Component
public class RedisUtil {

    private final Logger log = LoggerFactory.getLogger(RedisUtil.class);

    @Autowired
    private JedisPoolUtil jedisPoolUtil;
    
    /**
     * 删除指定的key
     * @param key
     * @return
     */
    public long del(String key){
        Jedis jedis =null;
        long res = -1;
        try {
            jedis = jedisPoolUtil.getJedis();
            res = jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("strSet {} error:{}",key ,e);
        } finally {
            JedisPoolUtil.release(jedis);
        }
        return  res;
    }

    /**
     * 字符串设置key-value-expire
     * @param key
     * @param value
     * @param expire 过期时间，值为-1时永不过期
     * @return 成功返回OK
     */
    public  String strSet(String key ,String value,int expire){
        Jedis jedis =null;
        String res = null;
        try {
            jedis = jedisPoolUtil.getJedis();
            res = jedis.set(key, value);
            if(expire != -1){
                jedis.expire(key ,expire);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("strSet {} error:{}",key ,e);
        } finally {
            JedisPoolUtil.release(jedis);
        }
        return  res;
    }

    ///string操作
    /**
     * 字符串设置key-value
     * @param key
     * @param value
     * @return 成功返回OK
     */
    public  String strSet(String key ,String value){
        return strSet(key,value,-1);
    }

    /**
     * 根据key获取字符串的值
     * @param key
     * @return
     */
    public String strGet(String key){
        Jedis jedis =null;
        String res = null;
        try {
            jedis = jedisPoolUtil.getJedis();
            res = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("strSet {} error:{}",key ,e);
        } finally {
            JedisPoolUtil.release(jedis);
        }
        return  res;
    }
    public String strMset(String... keyValues){
        String res = null;
        Jedis jedis = null;
        try {
            jedis = jedisPoolUtil.getJedis();
            res = jedis.mset(keyValues);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("strMset {} error:{}",keyValues ,e);
        } finally {
            JedisPoolUtil.release(jedis);
        }
        return  res;
    }
    public List<String> strMget(String... keys){
        List<String> res = null;
        Jedis jedis = null;
        try {
            jedis = jedisPoolUtil.getJedis();
            res = jedis.mget(keys);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("strMget {} error:{}",keys ,e);
        } finally {
            JedisPoolUtil.release(jedis);
        }
        return res;
    }

    /**
     * 从右边开始往List中添加数据
     * @param key
     * @param values
     * @return 返回值为添加到List中元素的个数
     */
    public long listRpush(String key , String ... values){
        long res = -1;
        Jedis jedis = null;
        try {
            jedis = jedisPoolUtil.getJedis();
            res = jedis.rpush(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("listRpush(): {} {}，error：{}",key ,values,e);
        } finally {
            JedisPoolUtil.release(jedis);
        }
        return res;
    }
    /**
     * 返回key中从start到end之间的元素
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> listLrange(String key,int start ,int end){
        List<String> res = null;
        Jedis jedis = null;
        try {
            jedis = jedisPoolUtil.getJedis();
            res = jedis.lrange(key,start,end);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("listRpush(): {} {} {}，error：{}",key ,start,end,e);
        } finally {
            JedisPoolUtil.release(jedis);
        }
        return res;
    }

    public long mapHset(String key, String field, String value) {
        long res = -1;
        Jedis jedis = null;
        try {
            jedis = jedisPoolUtil.getJedis();
            res = jedis.hset(key, field, value);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("mapHset() {} {} {} , errors {}",key,field,value,e);
        } finally {
            JedisPoolUtil.release(jedis);
        }
        return res;
    }
    public String mapHget(String key, String field) {
        String res = null;
        Jedis jedis = null;
        try {
            jedis = jedisPoolUtil.getJedis();
            res = jedis.hget(key, field);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("mapHget() {} {} , errors {}",key,field,e);
        } finally {
            JedisPoolUtil.release(jedis);
        }
        return res;
    }
    public String mapHmset(String key, Map<String, String> map) {
        String res = null;
        Jedis jedis = null;
        try {
            jedis = jedisPoolUtil.getJedis();
            res = jedis.hmset(key, map);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("mapHmset() {} {} , errors {}",key,map,e);
        } finally {
            JedisPoolUtil.release(jedis);
        }
        return res;
    }
    public List<String> mapHmget(String key, String... fields) {
        List<String> res = null;
        Jedis jedis = null;
        try {
            jedis = jedisPoolUtil.getJedis();
            res = jedis.hmget(key, fields);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("mapHmget() {} {} , errors {}",key,fields,e);
        } finally {
            JedisPoolUtil.release(jedis);
        }
        return res;
    }

}
