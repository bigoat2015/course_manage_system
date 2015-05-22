package cn.cms.dao;

import java.util.List;

import cn.cms.mode.TeachTime;

public interface ITeachTime {
	
	public int add(TeachTime teachTime);
	
	public int delete(String id);
	
	public int update(TeachTime teachTime);
	
	public List<TeachTime> findByClassId(String classId);

	public List<TeachTime> findAll();
}

