package com.faustofan.dubboprovider.service.impl;

import com.faustofan.dubbointerface.service.StudentService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @author: fausto
 * @date: 2021/6/11 18:02
 * @description:
 */
@Component
@DubboService(interfaceClass = StudentService.class , version = "1.0.0" , timeout = 15000)
public class StudentServiceImpl implements StudentService {
	@Override
	public Object queryStudents() {
		return "faustofan";
	}
}
