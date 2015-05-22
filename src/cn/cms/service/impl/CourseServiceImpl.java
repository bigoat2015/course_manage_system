package cn.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.cms.dao.ICourse;
import cn.cms.mode.Course;
import cn.cms.mode.WeekCourse;
import cn.cms.service.CourseService;

public class CourseServiceImpl extends BaseServiceImpl implements CourseService {
	private static Logger logger = Logger.getLogger(CourseServiceImpl.class); //日志初始化

	private ICourse iCourse ;
	
	public CourseServiceImpl(){
		iCourse = getSqlSession().getMapper(ICourse.class);
	}
	
	public List<Course> findAll() {
		return iCourse.findAll();
	}

	public Course add(Course course) {
		logger.info("添加信息 ServiceImpl " + course);
		int i = iCourse.add(course);	
		commit();
		close();
		if(i > 0) {
			return course;
		} else {
			return null;
		}
	}

	public int delete(String id) {
		logger.info("删除信息 ServiceImpl " + id);
		int i = iCourse.delete(id);	
		commit();
		close();
		return i;
	}

	public Course update(Course course) {
		logger.info("跟新信息 ServiceImpl " + course);
		int i = iCourse.update(course);	
		commit();
		close();
		if(i > 0) {
			return course;
		} else {
			return null;
		}
	}

}
