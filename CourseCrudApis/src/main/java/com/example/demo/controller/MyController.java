package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Course;
import com.example.demo.services.CourseServices;

@RestController
public class MyController {

	@Autowired
	private CourseServices courseServices;

	@GetMapping("/home")
	public String home() {
		return "this is home";
	}

	// get the courses
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.courseServices.getCourses();
	}

	// get single Courses
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseServices.getCourse(Long.parseLong(courseId));
	}

	// Post method
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseServices.addCourse(course);
	}

	// Put method
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@RequestBody Course course, @PathVariable("courseId") long courseId) {
		return this.courseServices.updateCourse(course, courseId);
	}

	
//	 Delete Method
	 
	  @DeleteMapping("/courses/{courseId}")
	  public Course deleteCourse(@PathVariable("courseId") long courseId) {
		  return this.courseServices.deleteCourse(courseId);
	  }
	 

}
