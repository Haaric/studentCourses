package com.harish.springboot.studentservices.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="studententity")
public class StudentEntity {


	private int id;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="address")
	private String address;
	private Set<Courses> courses;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "map_course_student", 
	joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}
	
    @Override
    public String toString() {
        String result = String.format(
                "Student [id=%d, name='%s']%n",
                id, firstName+lastName);
        if (courses != null) {
            for(Courses course : courses) {
                result += String.format(
                        "Course[id=%d, name='%s']%n",
                        course.getId(), course.getName());
            }
        }

        return result;
    }

}
