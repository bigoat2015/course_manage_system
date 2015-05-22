package cn.cms.dao;

import java.util.List;
import cn.cms.mode.Teacher;


public interface ITeacher {


	public int add(Teacher teacher);
	
	public int delete(String id);
	
	public int update(Teacher teacher);
	
	public Teacher findById(String id);
	
	public List<Teacher> findAll();
	
}
