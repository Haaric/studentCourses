package com.harish.springboot.studentservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harish.springboot.studentservices.dao.StudentDao;
import com.harish.springboot.studentservices.models.StudentEntity;

@Service(value="studentService")
public class StudentService {

	@Autowired
	StudentDao studentDao;
	
	public StudentEntity getStudent(int id) {
		return studentDao.getStudent(id);
	}
}
