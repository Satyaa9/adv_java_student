package com.test.service;

import java.util.List;

import com.test.entity.Student;

public interface StudentService {
	
	void deleteStudent(int id);
	
	Student updateStudent(int id, Student student);
	
	Student getStudent();
	
	String getStudentName();
	
	List<Student> getAllStudent();
	
	Student addStudent(Student student);
	
	List<Student> getStudentByAge(int age);
	
	List<Student> getStudentByName(String name);
}
