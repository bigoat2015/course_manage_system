package cn.cms.service.impl;





import java.util.List;

import org.apache.log4j.Logger;

import cn.cms.dao.IClassroom;

import cn.cms.mode.Classroom;
import cn.cms.service.ClassroomService;

public class ClassroomServiceImpl extends BaseServiceImpl implements ClassroomService{
	private static Logger logger = Logger.getLogger(ClassroomServiceImpl.class); //日志初始化

	
	private IClassroom iClassroom;
	
	public ClassroomServiceImpl(){
		iClassroom = getSqlSession().getMapper(IClassroom.class);
	}


	public List<Classroom> findAll() {
		return iClassroom.findAll();
	}


	public Classroom add(Classroom classroom) {
		logger.info("添加信息 ServiceImpl " + classroom);
		int i = iClassroom.add(classroom);	
		commit();
		close();
		if(i > 0) {
			return classroom;
		} else {
			return null;
		}
	}


	public int delete(String id) {
		logger.info("删除信息 ServiceImpl " + id);
		int i = iClassroom.delete(id);	
		commit();
		close();
		return i;
	}


	public Classroom update(Classroom classroom) {
		logger.info("跟新信息 ServiceImpl " + classroom);
		int i = iClassroom.update(classroom);	
		commit();
		close();
		if(i > 0) {
			return classroom;
		} else {
			return null;
		}
	}

}
