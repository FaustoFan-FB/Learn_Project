package com.example.chap03mybatis.service;

import com.example.chap03mybatis.model.Student;

/**
 * @author: fausto
 * @date: 2021/6/5 17:24
 * @description:
 */
public interface StudentService {
	Student queryStudent(Integer id);
}
