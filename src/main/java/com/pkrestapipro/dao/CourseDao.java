package com.pkrestapipro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkrestapipro.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{
	

}
