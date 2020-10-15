package com.vincent.app.apollo.redis.service;

public interface RedisService {

    void setStringToRedis(String k, String v);

    void setStringToRedis(String k, String v, int l);

    String getStringFromRedis(String k);
}
