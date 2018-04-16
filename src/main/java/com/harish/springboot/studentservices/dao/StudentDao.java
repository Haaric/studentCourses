package com.harish.springboot.studentservices.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.harish.springboot.beans.Student;
import com.harish.springboot.studentservices.models.Courses;
import com.harish.springboot.studentservices.models.StudentEntity;

@Repository(value = "studentDao")
public class StudentDao {

	@PersistenceContext
	private EntityManager entityManager;

	private static String getStudent = "SELECT * FROM STUDENTENTITY WHERE ID=:id";

	public StudentEntity getStudent(int id) {
		StudentEntity res = null;
		try {
			res = (StudentEntity) entityManager.find(StudentEntity.class, id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}
	
	
	@Transactional
	public StudentEntity insertStudent(Student student) {
		StudentEntity studentEntity = null;
		try {
			studentEntity = new StudentEntity();
			studentEntity.setAddress(student.getAddress());
			studentEntity.setFirstName(student.getFirstName());
			studentEntity.setLastName(student.getLastName());
			Set<Courses> set = new HashSet<Courses>();
			for (int i = 0; i < student.getCourses().length; i++) {
				Courses course = entityManager.find(Courses.class, Integer.parseInt(student.getCourses()[i]));
				set.add(course);
			}
			studentEntity.setCourses(set);

			entityManager.persist(studentEntity);
		} catch (Exception e) {
			return null;
		}
		return studentEntity;
	}
}
