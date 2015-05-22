package cn.cms.dao;

import java.util.List;
import cn.cms.mode.Teach;

public interface ITeach {
	
	public int add(Teach teach);
	
	public int delete(String id);
	
	public int update(Teach teach);
	
	public List<Teach> findByClassId(String classId);
	
	public Teach findById(String Id);
	
	public List<Teach> findByTeacherId(String teacherId);

	public List<Teach> findAll();
}

