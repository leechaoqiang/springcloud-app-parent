package com.vincent.app.apollo.redis.service.impl;

import com.vincent.app.apollo.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisServiceImpl implements RedisService {

    private static final Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    private JedisPool jedisPool;

    @Override
    public void setStringToRedis(String k, String v) {
        Jedis jedis = null;
        try {
            if(jedis == null){
                jedis = jedisPool.getResource();
            }
            jedis.set(k,v);
        } catch (Exception e) {
            logger.error("redis设置值失败",e);
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    @Override
    public void setStringToRedis(String k, String v, int i) {
        Jedis jedis = null;
        try {
            if(jedis == null){
                jedis = jedisPool.getResource();
            }
            jedis.setex(k,i,v);
        } catch (Exception e) {
            logger.error("redis设置值失败",e);
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    @Override
    public String getStringFromRedis(String k) {
        Jedis jedis = null;
        try {
            if(jedis == null){
                jedis = jedisPool.getResource();
            }
            return jedis.get(k);
        } catch (Exception e) {
            logger.error("redis获取值失败",e);
        } finally {
            if(jedis!=null){
                jedis.close();
            }
        }
        return null;
    }
}
