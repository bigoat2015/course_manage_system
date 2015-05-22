package cn.cms.service;

import java.util.List;

import cn.cms.mode.Classroom;
import cn.cms.mode.Course;
import cn.cms.mode.WeekCourse;

public interface CourseService {
	 
	public List<Course> findAll();

	public Course update(Course course);

	public int delete(String id);

	public Course add(Course course);


}
