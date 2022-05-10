package com.school.registerSchool.repository;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.registerSchool.model.Student;

@EnableJpaRepositories
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	
}
