package com.example.redisratelimiter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RateLimiterService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private static final int MAX_REQUESTS = 5;
    private static final int SYSTEM_SECONDS = 60;

    public boolean isAllowed(String key){
        Long count  = redisTemplate.opsForValue().increment(key);

        if(count == 1){
            redisTemplate.expire(key, Duration.ofSeconds(SYSTEM_SECONDS));
        }

        return count<=MAX_REQUESTS;
    }

}
