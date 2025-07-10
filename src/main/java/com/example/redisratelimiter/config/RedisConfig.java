package com.example.redisratelimiter.config;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configurable
public class RedisConfig {

    @Bean
    public RedisTemplate<String, String> RedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setKeySerializer(
                new StringRedisSerializer() {
                }
        );
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
