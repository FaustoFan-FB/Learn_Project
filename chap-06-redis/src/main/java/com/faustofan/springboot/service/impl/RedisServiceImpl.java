package com.faustofan.springboot.service.impl;

import com.faustofan.springboot.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisServiceImpl implements RedisService {
	@Resource
	private RedisTemplate<Object,Object> redisTemplate;
	
	@Override
	public int put(String key, String value) {
		redisTemplate.opsForValue().set(key,value);
		return 1;
	}
	
	@Override
	public Object get(String key) {
		Object value = redisTemplate.opsForValue().get(key);
		return value;
	}
}
