package com.harish.springboot.studentservices.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harish.springboot.beans.Student;
import com.harish.springboot.studentservices.dao.StudentDao;
import com.harish.springboot.studentservices.models.Courses;
import com.harish.springboot.studentservices.models.StudentEntity;

@Service(value="studentService")
public class StudentService {

	@Autowired
	StudentDao studentDao;
	
	public StudentEntity getStudent(int id) {
		return studentDao.getStudent(id);
	}
	
	public StudentEntity insertStudent(Student student) {
		return studentDao.insertStudent(student);
	}
}
