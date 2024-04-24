package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "age")
	private String age;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "studentId")
	private String studentId;
	
	@Column(name = "classDetail")
	private String classDetail;
	
	public Student() {
		
	}
	
	
	public Student(String firstName, String lastName, String age, String dob,String studentId,String email ,String classDetail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dob = dob;
		this.email = email;
		this.studentId = studentId;
		this.classDetail = classDetail;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getAge() {
		return age;
	}
	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public void setAge(String age) {
		this.age = age;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClassDetail() {
		return classDetail;
	}
	public void setClassDetail(String classDetail) {
		this.classDetail = classDetail;
	}
	
	
}
