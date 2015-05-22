package cn.cms.service;

import java.util.List;

import cn.cms.mode.Class;

public interface ClassService {
	 
	public List<Class> findAll();
	
	public Class update(Class c);
	
	public Class add(Class c);
	
	public String findAll(Class c, int start, int upperIndex);

	public int delete(String id);
	


}
