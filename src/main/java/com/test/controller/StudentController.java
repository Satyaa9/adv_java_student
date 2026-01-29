package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Student;
import com.test.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	//API to get the student name
	@GetMapping("/studentname")
		public String getStudentName() {
			return studentService.getStudentName();
		}
	
	
	
	//API to get all students from the database
	@GetMapping("/allstudents")
	public List<Student> allStudents(){
		return studentService.getAllStudent();
	}
	
	
	//API to add student in the database
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	//API to get the student by age from the database
	@GetMapping("/studentByAge/{age}")
	public List<Student> getStudentByAge(@PathVariable int age){
		return studentService.getStudentByAge(age);
	}
	
	//API to get the student by name
	@GetMapping("/studentByName/{name}")
		public List<Student> getStudentByName(@PathVariable String name){
			return studentService.getStudentByName(name);
		
	}
	
	//API to delete the student by using the id
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
		return "student deleted";
		
	}
	
	//API to update the student by using the id of student
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id , @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}

}
