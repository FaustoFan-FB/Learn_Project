package com.example.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: fausto
 * @date: 2021/6/5 15:36
 * @description:
 */
@Controller
public class IndexController {
	@RequestMapping(value = "/say")
	public ModelAndView say(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg","HelloWorld");
		mv.setViewName("say");
		return mv;
	}
	
}
