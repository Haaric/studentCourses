package com.harish.springboot.studentservices.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.harish.springboot.studentservices.models.StudentEntity;

@Repository(value="studentDao")
public class StudentDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private static String getStudent = "SELECT * FROM STUDENTENTITY WHERE ID=:id";
	
	public StudentEntity getStudent(int id) {
		StudentEntity res = null;
		try {
		res = (StudentEntity) entityManager.find(StudentEntity.class, 1);
		}catch(Exception e) {
			System.out.println(e);
		}
		return res;
 	}
}
