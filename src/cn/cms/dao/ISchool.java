package cn.cms.dao;

import java.util.List;

import cn.cms.mode.School;

public interface ISchool {
	
	public int add(School school);
	
	public int delete(String id);
	
	public int update(School school);
	
	public School findById(String id);
	
	public List<School> findAll();
}

