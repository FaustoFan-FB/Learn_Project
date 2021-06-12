package com.faustofan.springboot.web;

import org.springframework.web.bind.annotation.*;

/**
 * @author: fausto
 * @date: 2021/6/11 15:01
 * @description:
 *          RESTful风格:
 *              1. 请求方式按增删改查来区分
 *              2. 路径中使用单词都是名词
 */
@RestController
public class StudentController {
	
	@GetMapping(value = "/student/select/{id}")
	public Object selectStudent(@PathVariable("id") Integer id){
		return "查询id "+id+"的学生" ;
	}
	
	@PostMapping(value = "/student/add/{id}/{name}/{age}")
	public Object addStudent(@PathVariable("id") Integer id,
	                         @PathVariable("name") String name,
	                         @PathVariable("age") Integer age){
		return "新增学生:"+id+name+age;
	}
	
	@DeleteMapping (value = "/student/delete/{id}")
	public Object deleteStudent(@PathVariable("id") Integer id){
		return "删除学生:"+id;
	}
	
	@PutMapping (value = "/student/update/{id}/{name}/{age}")
	public Object updateStudent(@PathVariable("id") Integer id,
	                            @PathVariable("name") String name,
	                            @PathVariable("age") Integer age){
		return "更新学生:"+id+name+age;
	}
	
}
