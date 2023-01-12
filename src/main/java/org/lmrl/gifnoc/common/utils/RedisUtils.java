package org.lmrl.gifnoc.common.utils;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Setter
@Component
@RequiredArgsConstructor
public class RedisUtils {

    private final StringRedisTemplate redisTemplate;

    @Value("${gifnoc.cache.default-expire}")
    private int expire;


    public <T> void set(final String key, T value) {
        set(key, value, 0, TimeUnit.SECONDS);
    }

    public <T> void set(final String key, T value, long timeout) {
        set(key, value, timeout, TimeUnit.SECONDS);
    }

    public <T> void set(final String key, T value, long timeout, TimeUnit timeUnit) {
        String json = JsonUtil.toJson(value);
        if (json == null) {
            return;
        }
        if (timeout <= 0) {
            redisTemplate.opsForValue().set(key, json);
        } else {
            redisTemplate.opsForValue().set(key, json, timeout, timeUnit);
        }
    }

    public String get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public <T> T get(final String key, Class<T> valueType) {
        String json = redisTemplate.opsForValue().get(key);
        return JsonUtil.fromJson(json, valueType);
    }
}
