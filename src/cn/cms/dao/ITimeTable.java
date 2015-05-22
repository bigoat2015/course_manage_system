package cn.cms.dao;

import java.util.List;

import cn.cms.mode.Course;
import cn.cms.mode.TimeTable;

public interface ITimeTable {
	
	public int add(TimeTable timeTable);
	
	public int delete(String id);
	
	public int update(TimeTable timeTable);
	
	public List<TimeTable> findByClassId(String classId);
	
	public List<TimeTable> findByTeacherId(String teacherId);

	public List<TimeTable> findAll();
}

