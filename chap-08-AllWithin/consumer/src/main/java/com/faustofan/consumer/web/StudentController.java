package com.faustofan.consumer.web;

import com.faustofan.interfaceDubbo.model.Student;
import com.faustofan.interfaceDubbo.service.StudentService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: fausto
 * @date: 2021/6/12 16:21
 * @description:
 */
@Controller
public class StudentController {
	@DubboReference(interfaceClass = StudentService.class , version = "1.0.0" , check = false)
	private StudentService studentService;
	
	@RequestMapping(value = "/student/detail/{id}")
	public String studentDetail(@PathVariable("id") Integer id , Model model){
		Student student = studentService.queryStudent(id);
		model.addAttribute("student" , student);
		return "studentDetail";
	}
	
	@GetMapping(value = "/student/count")
	public @ResponseBody Object studentsCount(){
		return studentService.queryStudentsCount();
	}
}
