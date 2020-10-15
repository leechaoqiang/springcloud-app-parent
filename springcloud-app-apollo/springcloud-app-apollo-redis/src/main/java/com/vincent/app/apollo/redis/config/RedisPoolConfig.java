package com.vincent.app.apollo.redis.config;

import com.alibaba.fastjson.JSON;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

@Configuration
public class RedisPoolConfig {

    private static final Logger logger = LoggerFactory.getLogger(LoggerConfig.class);


    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.database}")
    private Integer dataBase;

    @Value("${spring.redis.timeout}")
    private Integer timeout;

    @Value("${spring.redis.maxTotal}")
    private Integer maxTotal;

    @Value("${spring.redis.maxIdle}")
    private Integer maxIdle;

    @Value("${spring.redis.minIdle}")
    private Integer minIdle;

    @Value("${spring.redis.blockWhenExhausted}")
    private Boolean blockWhenExhausted;

    @Value("${spring.redis.maxWaitMillis}")
    private Integer maxWaitMillis;

    @Value("${spring.redis.testOnBorrow}")
    private Boolean testOnBorrow;



    private JedisPool jedisPool;

    @Bean
    public JedisPool initPool() {

        return buildJedisPool();
    }

    private  JedisPool buildJedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置最大连接数
        jedisPoolConfig.setMaxTotal(maxTotal);
        //设置空闲的连接数
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        //设置最大的等待时间
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        //是否要进行链接测试，以保证返回的链接为可用链接
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        if (password != null && !"".equals(password)) {
            // redis 设置了密码
            jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password,dataBase);
        } else {
            // redis 未设置密码
            jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
        }
        logger.info("com.vincent.app.apollo.redis.config.RedisPoolConfig.buildJedisPool:{}", JSON.toJSONString(jedisPool));
        return jedisPool;
    }


    @Autowired
    ApplicationContext context;

    /**
     *  Apollo监听配置是否修改
     */
    @ApolloConfigChangeListener
    public void onConfigChangeEvent(ConfigChangeEvent changeEvent) {
        Set changedKeys = changeEvent.changedKeys();
        logger.info("com.vincent.app.apollo.redis.config.RedisPoolConfig.onConfigChangeEvent:{}", JSON.toJSONString(changedKeys));
        if (changedKeys.contains("spring.redis.host")) {
            JedisPool pool = context.getBean(JedisPool.class);
            try {
                pool = initPool();
            } catch (Exception e) {
                logger.error("jedisPool initPool again exception:{}", e.getMessage());
            }

        }
    }
}
