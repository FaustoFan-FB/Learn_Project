package com.example.chap03mybatis.web;

import com.example.chap03mybatis.model.Student;
import com.example.chap03mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: fausto
 * @date: 2021/6/5 17:21
 * @description:
 */
@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/queryStudent")
	public @ResponseBody Student queryStudent(Integer id){
		return studentService.queryStudent(id);
		
	}
}
