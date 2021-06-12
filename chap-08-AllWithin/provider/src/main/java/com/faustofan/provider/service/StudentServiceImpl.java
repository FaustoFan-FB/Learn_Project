package com.faustofan.provider.service;

import com.faustofan.interfaceDubbo.model.Student;
import com.faustofan.interfaceDubbo.service.StudentService;
import com.faustofan.provider.mapper.StudentMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
	
	@Override
	public Student queryStudent(Integer id) {
		return studentMapper.selectByPrimaryKey(id);
	}
}
