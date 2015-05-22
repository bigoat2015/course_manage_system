package cn.cms.dao;

import java.util.List;

import cn.cms.mode.Classroom;


public interface IClassroom {


	public int add(Classroom classroom);
	
	public int delete(String id);
	
	public int update(Classroom classroom);
	
	public Classroom findById(String id);
	
	public List<Classroom> findAll();
	
}
