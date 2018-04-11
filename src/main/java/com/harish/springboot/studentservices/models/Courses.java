package com.harish.springboot.studentservices.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Courses {
	
	private int id;
	private String name;
	private String desc;
	private Set<StudentEntity> students;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@ManyToMany(mappedBy = "courses")
	public Set<StudentEntity> getStudents() {
		return students;
	}
	public void setStudents(Set<StudentEntity> students) {
		this.students = students;
	}
	
	
	
}
