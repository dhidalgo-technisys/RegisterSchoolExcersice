package com.school.registerSchool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.registerSchool.model.Course;
import com.school.registerSchool.model.Register;
import com.school.registerSchool.model.Student;


@Repository
public interface RegisterRepository extends CrudRepository<Register, Integer> {

	@Query(value = "SELECT r.idStudent FROM Register r WHERE r.idCourse = :course")
	public List<Student> getRegisterbyCourse(@Param("course")Course course);
	@Query(value = "SELECT r.idCourse FROM Register r WHERE r.idStudent = :student")
	public List<Course> getCoursesbyStudent(@Param("student") Student student);
	
	@Query(value = "SELECT c.course, COUNT(r) FROM Course c RIGHT JOIN Register r  GROUP BY c.course HAVING COUNT(r)=0")
	public List<String> getCoursesWithoutStudent();
	
	@Query(value = "SELECT e.fullname, COUNT(r) FROM Student e  RIGHT JOIN Register r  GROUP BY e.fullname HAVING COUNT(r)=0")
	public List<String> getStudentWithoutCourses();
}
