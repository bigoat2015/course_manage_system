package cn.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.cms.dao.ICourse;
import cn.cms.dao.ITeacher;
import cn.cms.mode.Course;
import cn.cms.mode.Teacher;
import cn.cms.service.CourseService;
import cn.cms.service.TeachBuildService;
import cn.cms.service.TeacherService;

public class TeacherServiceImpl extends BaseServiceImpl implements TeacherService {
	private static Logger logger = Logger.getLogger(TeacherServiceImpl.class); //日志初始化

	private ITeacher iTeacher;
	
	public TeacherServiceImpl(){
		iTeacher = getSqlSession().getMapper(ITeacher.class);
	}
	
	public List<Teacher> findAll() {
		return iTeacher.findAll(); 
	}

	public int delete(String id) {
		logger.info("删除信息 ServiceImpl " + id);
		int i = iTeacher.delete(id);	
		commit();
		close();
		return i;
	}

	public Teacher update(Teacher teacher) {
		logger.info("跟新信息 ServiceImpl " + teacher);
		int i = iTeacher.update(teacher);	
		commit();
		close();
		if(i > 0) {
			return teacher;
		} else {
			return null;
		}
	}

	public Teacher add(Teacher teacher) {
		logger.info("添加信息 ServiceImpl " + teacher);
		int i = iTeacher.add(teacher);	
		commit();
		close();
		if(i > 0) {
			return teacher;
		} else {
			return null;
		}
	}

}
