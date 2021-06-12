package com.faustofan.springboot.service.impl;

import com.faustofan.springboot.mapper.StudentMapper;
import com.faustofan.springboot.model.Student;
import com.faustofan.springboot.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: fausto
 * @date: 2021/6/5 17:25
 * @description:
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentMapper mapper;
	
	public Student queryStudent(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
}
