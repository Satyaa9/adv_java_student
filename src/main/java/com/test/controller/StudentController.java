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
	
	
	@GetMapping("/studentname")
		public String getStudentName() {
			return studentService.getStudentName();
		}
	
	
	
	@GetMapping("/allstudents")
	public List<Student> allStudents(){
		return studentService.getAllStudent();
	}
	
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("/studentByAge/{age}")
	public List<Student> getStudentByAge(@PathVariable int age){
		return studentService.getStudentByAge(age);
	}
	
	@GetMapping("/studentByName/{name}")
		public List<Student> getStudentByName(@PathVariable String name){
			return studentService.getStudentByName(name);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
		return "student deleted";
		
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id , @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}

}
