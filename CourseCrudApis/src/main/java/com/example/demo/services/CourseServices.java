package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Course;

public interface CourseServices {
public List<Course> getCourses();

public Course getCourse(long courseId);

public Course addCourse(Course course);

public Course updateCourse(Course course,long courseId);

public Course deleteCourse(long courseId);


}
