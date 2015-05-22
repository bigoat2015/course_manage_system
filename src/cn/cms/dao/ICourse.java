package cn.cms.dao;

import java.util.List;
import cn.cms.mode.Course;


public interface ICourse {


	public int add(Course course);
	
	public int delete(String id);
	
	public int update(Course course);
	
	public Course findById(String id);
	
	public List<Course> findAll();
	
}
