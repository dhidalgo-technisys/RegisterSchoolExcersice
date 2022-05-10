package com.school.registerSchool.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.registerSchool.model.Student;
import com.school.registerSchool.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentRepository studentRepository;

	@GetMapping(path = "/getAll", produces = { "application/json" })
	public List<Student> getAllgetStudents() {
		List<Student> result = StreamSupport.stream(studentRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		
		return result;
	}
	
	@PostMapping(path = "/insertStudent", produces = { "application/json" })
	public Student newStudent(Student student) {
		return studentRepository.save(student);
	}
	@PutMapping("/updateStudent/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable Integer id)
	{
		return studentRepository.findById(id).map(e->{
			e.setBirthday(student.getBirthday());
			e.setName(student.getName());
			e.setLastname(student.getLastname());
			e.setStudentNumber(student.getStudentNumber());
			return studentRepository.save(e);
		}).orElseGet(()->{
			student.setIdstudent(id);
			return studentRepository.save(student);
		});
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable Integer StudentId) {
		
		studentRepository.deleteById(StudentId);
	}
}
