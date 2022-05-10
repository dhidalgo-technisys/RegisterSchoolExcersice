package com.school.registerSchool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.registerSchool.model.Course;


@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

}
