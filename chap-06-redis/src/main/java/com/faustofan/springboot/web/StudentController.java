package com.faustofan.springboot.web;

import com.faustofan.springboot.service.RedisService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: fausto
 * @date: 2021/6/11 16:11
 * @description:
 */
@RestController
public class StudentController {
	@Resource
	private RedisService redisService;
	
	@RequestMapping(value = "/put/{key}/{value}")
	public Object putRedis(@PathVariable("key") String key, @PathVariable("value") String value){
		int count = redisService.put(key,value);
		if(count == 1) return "successful";
		return "defeat";
	}
	
	@RequestMapping(value = "/get/{key}")
	public Object getRedis(@PathVariable("key") String key){
		
		return redisService.get(key);
	}
}
