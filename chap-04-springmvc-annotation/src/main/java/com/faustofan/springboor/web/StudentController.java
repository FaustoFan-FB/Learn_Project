package com.faustofan.springboor.web;

import com.faustofan.springboor.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: fausto
 * @date: 2021/6/10 17:00
 * @description:
 */
@RestController //相当于: @Controller + @ResponseBody
public class StudentController {
	@RequestMapping(value = "/listStudent" )
	//由于使用了@RestController,可以省略@ResponseBody
	public Object listStudent(){
		Student student=new Student();
		student.setAge(22);
		student.setId(1001);
		student.setName("张三");
		return student;
	}
	
	/**
	 * @return: null
	 * @author: fausto
	 * @date: 2021/6/11 14:25
	 * @description:
	 *              GetMapping    : 查询数据时使用
	 *              PostMapping   : 新增数据时使用
	 *              DeleteMapping : 删除数据时使用
	 *              PutMapping    : 更新数据时使用
	 */
	@GetMapping(value = "/queryStudent")
	//只接收Get请求,请求方式不对会报405错误,相当于@RequestMapping(value="/..." , method = "RequestMethod.GET")
	//查询数据时使用
	
	public Object queryStudent(){
		return "Spring-MVC注解";
	}
}
