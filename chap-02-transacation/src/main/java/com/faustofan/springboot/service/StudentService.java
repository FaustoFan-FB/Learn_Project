package com.faustofan.springboot.service;

import com.faustofan.springboot.model.Student;

/**
 * @author: fausto
 * @date: 2021/6/5 17:24
 * @description:
 */
public interface StudentService {
	Student queryStudent(Integer id);
}
