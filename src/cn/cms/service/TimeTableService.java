package cn.cms.service;

import java.util.List;

import cn.cms.mode.Classroom;
import cn.cms.mode.Course;
import cn.cms.mode.TimeTable;
import cn.cms.mode.WeekCourse;

public interface TimeTableService {
	 
	public List<TimeTable> findAll();

	public TimeTable update(TimeTable timeTable);

	public int delete(String id);

	public TimeTable add(TimeTable timeTable);

	public WeekCourse findWeekCourse(String user);



}
