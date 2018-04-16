package com.harish.springboot.studentservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.harish.springboot.beans.Student;
import com.harish.springboot.studentservices.models.StudentEntity;
import com.harish.springboot.studentservices.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/getStudent/{id}", method=RequestMethod.GET)
	public @ResponseBody StudentEntity getStudent(@PathVariable("id") int id) {
		return studentService.getStudent(id);
	}
	
	@RequestMapping(value="/insertStudent", method= RequestMethod.POST)
	public @ResponseBody StudentEntity insertStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);
	}
}
