package com.pkrestapipro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkrestapipro.dao.CourseDao;
import com.pkrestapipro.entities.Course;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	
//	List<Course> list;
	
	public CourseServiceImpl() {
		
//		list = new ArrayList<>();
		
//		list.add(new Course(11, "Basic Java", "Basic Understanding of Java"));
//		list.add(new Course(12, "Basic Spring", "Basic Understanding of Spring"));
//		list.add(new Course(13, "Basic React", "Basic Understanding of React"));
		
	}
	
	// get all courses
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		
//		return list;
		
		return courseDao.findAll();
		
	}
	
	// get single course
	
	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		
//		Course c = null;
		
//		for(Course course : list) {
			
//			if(course.getId() == courseId) {
				
//				c = course;
//				break;
			
//			}
//		}
		
//		return c;
		Course c=	courseDao.getOne(courseId);
		
		return c;
		
	}

	// add course
	
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		
//		list.add(course);
		
		courseDao.save(course);
		
		return course;
		
	}

	// update course
	
	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		
//		list.forEach(e ->{
			
//			if(e.getId() == course.getId()) {
				
//				e.setTitle(course.getTitle());
		
//				e.setDescription(course.getDescription());
		
//			}
//		});
		
		courseDao.save(course);
		
		return course;
		
	}

	// delete course
	
	@Override
	public Course deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		
//		list = this.list.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());
		
//		return null;
		
		Course entity = courseDao.getOne(parseLong);
		
		courseDao.delete(entity);
		
		return entity;
		
	}
}
