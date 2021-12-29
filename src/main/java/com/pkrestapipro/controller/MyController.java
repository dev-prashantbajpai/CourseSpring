package com.pkrestapipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pkrestapipro.entities.Course;
import com.pkrestapipro.services.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		
		return "Welcome in my Home Page";
		
	}
	
	// get all courses
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourses(){
		
		List<Course> list = courseService.getCourses();
		
		if(list.size() <= 0) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(list));
		
	}
	
	// get single course
	 
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Course> getCourse(@PathVariable String courseId) {
		
		Course course = courseService.getCourse(Long.parseLong(courseId));
		
		if(course == null) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		
		return ResponseEntity.ok(course);
		
	}
	
	// add course
	
	@PostMapping("/courses")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		
		Course c = null;
		
		try {
			
			c = courseService.addCourse(course);
			
			return ResponseEntity.of(Optional.of(course));
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	// update course
	
	@PutMapping("/courses/{courseId}")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
		
		try {
			
			this.courseService.updateCourse(course);
			
			return ResponseEntity.status(HttpStatus.OK).build();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	// delete course
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<Course> deleteCourse(@PathVariable String courseId) {
		
		try {
			
			this.courseService.deleteCourse(Long.parseLong(courseId));
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
}
