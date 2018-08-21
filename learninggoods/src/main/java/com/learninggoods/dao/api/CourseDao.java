package com.learninggoods.dao.api;

import java.util.List;

import com.learninggoods.dao.entity.Course;

public interface CourseDao{
	
	public boolean insert(Course course);
	public List<Course> getAllCourse();
	public boolean delete(long courseId);
	public boolean update(Course course);
	public Course getCourseById(long id);

}
