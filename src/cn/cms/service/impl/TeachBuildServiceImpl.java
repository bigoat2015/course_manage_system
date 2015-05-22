package cn.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.cms.dao.ICourse;
import cn.cms.dao.ITeachBuild;
import cn.cms.mode.Course;
import cn.cms.mode.TeachBuild;
import cn.cms.service.CourseService;
import cn.cms.service.TeachBuildService;

public class TeachBuildServiceImpl extends BaseServiceImpl implements TeachBuildService {
	private static Logger logger = Logger.getLogger(TeachBuildServiceImpl.class); //日志初始化

	private ITeachBuild iTeachBuild;
	
	public TeachBuildServiceImpl(){
		iTeachBuild = getSqlSession().getMapper(ITeachBuild.class);
	}
	
	public List<TeachBuild> findAll() {
		return iTeachBuild.findAll();
	}

	public TeachBuild add(TeachBuild teachBuild) {
		logger.info("添加信息 ServiceImpl " + teachBuild);
		int i = iTeachBuild.add(teachBuild);	
		commit();
		close();
		if(i > 0) {
			return teachBuild;
		} else {
			return null;
		}
	}

	public int delete(String id) {
		logger.info("删除信息 ServiceImpl " + id);
		int i = iTeachBuild.delete(id);	
		commit();
		close();
		return i;
	}

	public TeachBuild update(TeachBuild teachBuild) {
		logger.info("跟新信息 ServiceImpl " + teachBuild);
		int i = iTeachBuild.update(teachBuild);	
		commit();
		close();
		if(i > 0) {
			return teachBuild;
		} else {
			return null;
		}
	}
	

}
