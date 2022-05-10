package com.school.registerSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.registerSchool.model.Course;
import com.school.registerSchool.model.Register;
import com.school.registerSchool.model.Student;
import com.school.registerSchool.repository.RegisterRepository;
import com.school.registerSchool.serviceDomain.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	RegisterService registerService;
	@Autowired
	RegisterRepository registerRepository;

	@PostMapping(path = "/registerStudent", produces = { "application/json" })
	public Register registerStudent(Register register) throws Exception {

		register = registerService.registerStudent(register);
		return register;

	}

	@GetMapping(path = "/getCoursesWithoutStudent", produces = { "application/json" })
	public List<String> getCoursesWithoutStudent() {
		return registerRepository.getCoursesWithoutStudent();
	}

	@GetMapping(path = "/getStudentWithoutCourses", produces = { "application/json" })
	public List<String> getStudentWithoutCourses() {
		return registerRepository.getStudentWithoutCourses();
	}

	@PostMapping(path = "/getStudentsByCourse", produces = { "application/json" })
	public List<Student> getStudentsByCourse(Course course) {
		return registerRepository.getRegisterbyCourse(course);
	}

	@PostMapping(path = "/getCoursesByStudent", produces = { "application/json" })
	public List<Course> getCoursesByStudent(Student student) {
		return registerRepository.getCoursesbyStudent(student);
	}
}
