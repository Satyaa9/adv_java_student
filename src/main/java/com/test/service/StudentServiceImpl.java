package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Student;
import com.test.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}
	
	public Student getStudent() {
		return new Student();
	}
	
	public String getStudentName() {
		return "Test Student";
	}
	
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	
	public List<Student> getStudentByAge(int age){
		return studentRepository.findByAge(age);
	}
	
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getStudentByName(String name){
		return studentRepository.findByName(name);
	}
	
	public Student updateStudent(int id , Student student) {
		Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found of this id"+id));
		
		existingStudent.setName(student.getName());
		existingStudent.setAge(student.getAge());
		
		return studentRepository.save(existingStudent);
	}

}
