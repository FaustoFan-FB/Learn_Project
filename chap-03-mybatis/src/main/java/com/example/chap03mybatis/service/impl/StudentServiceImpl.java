package com.example.chap03mybatis.service.impl;

import com.example.chap03mybatis.mapper.StudentMapper;
import com.example.chap03mybatis.model.Student;
import com.example.chap03mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: fausto
 * @date: 2021/6/5 17:25
 * @description:
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper mapper;
	
	@Override
	public Student queryStudent(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
}
