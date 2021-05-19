package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;

@Service
public class CourseServiceimpl implements CourseServices {

	List<Course> list;
	private Object id;
	public CourseServiceimpl() {
		list =new ArrayList<>();
		list.add(new Course(123,"java course","description of this"));
		list.add(new Course(124,"Spring  course","description of this"));
	}
	
	
	
	
	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c=null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}




	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}




	@Override
	public Course updateCourse(Course course, long courseId) {
		list.stream().map(b->{
			if(b.getId()==courseId) {
				b.setTitle(course.getTitle());
				b.setDescription(course.getDescription());
			}
			return b;
		}).collect(Collectors.toList());
		return course;
		
	}




	@Override
	public Course deleteCourse(long courseId) {
		list.stream().filter(e->{
			if(e.getId()!=courseId) {
				return true;
			}
			else {
				return false;
			}
			
		}).collect(Collectors.toList());
		return null;
		
	}







	
	
	


}
