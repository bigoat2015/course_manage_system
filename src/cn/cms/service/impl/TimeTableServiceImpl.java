package cn.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.cms.dao.ICourse;
import cn.cms.dao.ITimeTable;
import cn.cms.mode.Course;
import cn.cms.mode.TimeTable;
import cn.cms.mode.WeekCourse;
import cn.cms.service.CourseService;
import cn.cms.service.TimeTableService;

public class TimeTableServiceImpl extends BaseServiceImpl implements TimeTableService {
	private static Logger logger = Logger.getLogger(TimeTableServiceImpl.class); //日志初始化

	private ITimeTable iTimeTable ;
	
	public TimeTableServiceImpl(){
		iTimeTable = getSqlSession().getMapper(ITimeTable.class);
	}
	
	public List<TimeTable> findAll() {
		return iTimeTable.findAll();
	}

	public TimeTable add(TimeTable timeTable) {
		logger.info("添加信息 ServiceImpl " + timeTable);
		int i = iTimeTable.add(timeTable);	
		commit();
		close();
		if(i > 0) {
			return timeTable;
		} else {
			return null;
		}
	}

	public int delete(String id) {
		logger.info("删除信息 ServiceImpl " + id);
		int i = iTimeTable.delete(id);	
		commit();
		close();
		return i;
	}

	public TimeTable update(TimeTable timeTable) {
		logger.info("跟新信息 ServiceImpl " + timeTable);
		int i = iTimeTable.update(timeTable);	
		commit();
		close();
		if(i > 0) {
			return timeTable;
		} else {
			return null;
		}
	}

	public WeekCourse findWeekCourse(String user) {
		
		WeekCourse wc = new WeekCourse();
		
		List<TimeTable> list = iTimeTable.findByClassId("2012070201");
		
		for (int i = 0; i < list.size(); i++) {
			wc.addCourse(list.get(i));	
		}
		
		return wc;
	}

}
