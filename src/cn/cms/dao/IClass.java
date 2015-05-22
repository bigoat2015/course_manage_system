package cn.cms.dao;

import java.util.List;
import cn.cms.mode.Class;


public interface IClass {


	public int add(Class c);
	
	public int delete(String id);
	
	public int update(Class c);
	
	public Class findById(String id);
	
	public List<Class> findAll();
	
}
