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

import com.school.registerSchool.model.Course;
import com.school.registerSchool.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	CourseRepository courseRepository;

	@GetMapping(path = "/getAll", produces = { "application/json" })
	public List<Course> getAllgetStudents() {
		List<Course> result = StreamSupport.stream(courseRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return result;
	}
	@PostMapping(path = "/insertCourse", produces = { "application/json" })
	public Course newCourse(Course course) {
		return courseRepository.save(course);
	}
	@PutMapping("/updateCourse/{id}")
	public Course updateCourse(@RequestBody Course course, @PathVariable Integer id)
	{
		return courseRepository.findById(id).map(c->{
			c.setCourse(course.getCourse());
			c.setDescription(course.getDescription());
			return courseRepository.save(c);
		}).orElseGet(()->{
			course.setIdcourse(id);
			return courseRepository.save(course);
		});
	}
	
	@DeleteMapping("/deleteCourse/{id}")
	public void deleteCourse(@PathVariable Integer courseId) {
		
		courseRepository.deleteById(courseId);
	}
}
