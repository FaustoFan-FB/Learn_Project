package com.faustofan.springboot.service;

import org.springframework.stereotype.Service;

/**
 * @author: fausto
 * @date: 2021/6/11 16:15
 * @description:
 */

public interface RedisService {
	int put(String key , String value);
	
	Object get(String key);
}
