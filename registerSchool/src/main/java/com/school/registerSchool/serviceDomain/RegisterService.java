package com.school.registerSchool.serviceDomain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.registerSchool.exception.IncorrectRegisterRulesException;
import com.school.registerSchool.model.Course;
import com.school.registerSchool.model.Register;
import com.school.registerSchool.model.Student;
import com.school.registerSchool.repository.RegisterRepository;

@Component
public class RegisterService {
	@Autowired
	RegisterRepository registerRepository;

	public Register registerStudent(Register register) throws Exception {
		List<Student> listStudents = registerRepository.getRegisterbyCourse(register.getIdCourse());
		if (listStudents.size() < 50) {
			List<Course> courses = registerRepository.getCoursesbyStudent(register.getIdStudent());
			if (courses.size() < 5) {
				return registerRepository.save(register);
			} else {
				throw new IncorrectRegisterRulesException("Student has  already 5 courses ",
						new Exception("student is a limit"));
			}
		} else {
			throw new IncorrectRegisterRulesException("Course has  already 50 students ",
					new Exception("courses is a limit"));
		}

	}

	
}
