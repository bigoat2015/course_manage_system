package cn.cms.dao;

import java.util.List;

import cn.cms.mode.Student;

public interface IStudent {


	public int add(Student student);
	
	public int delete(String id);
	
	public int update(Student student);
	
	public Student findById(String id);
	
	public List<Student> findByName(String name);
	
	public List<Student> findAll();
	
}
