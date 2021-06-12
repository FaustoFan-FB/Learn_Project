package com.faustofan.chap07testdubbo.web;

import com.faustofan.dubbointerface.service.StudentService;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: fausto
 * @date: 2021/6/11 18:18
 * @description:
 */
@RestController
public class StudentController {
	@DubboReference(interfaceClass = StudentService.class , version = "1.0.0" , check = false)
	private StudentService studentService;
	
	@RequestMapping(value = "/query")
	public Object queryAllStudents(){
		return studentService.queryStudents();
	}
}
