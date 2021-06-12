package com.faustofan.provider.service;

import com.faustofan.interfaceDubbo.model.Student;
import com.faustofan.interfaceDubbo.service.StudentService;
import com.faustofan.provider.mapper.StudentMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author: fausto
 * @date: 2021/6/12 16:32
 * @description:
 */
@Component
@DubboService(interfaceClass = StudentService.class , version = "1.0.0" , timeout = 15000)
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentMapper studentMapper;
	
	@Resource
	private RedisTemplate<Object,Object> redisTemplate;
	
	@Override
	public Student queryStudent(Integer id) {
		return studentMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public Integer queryStudentsCount() {
		//首先去redis中查询,若有便取出;若没有,便从数据库中查询,并保存到redis中
		Integer count = (Integer) redisTemplate.opsForValue().get("studentCount");
		System.out.println("==============="+count+"================");
		//判断是否有值
		if(null == count){
			//从数据库中查询并并保存到redis中
			Integer studentCount = studentMapper.selectStudentsCount();
			redisTemplate.opsForValue().set("studentCount",studentCount,20, TimeUnit.SECONDS);
			return studentCount;
		}
		//运行到此处说明redis中有值,直接从redis中取值
		System.out.println("==============="+count+"================");
		return count;
	}
}
