package cn.cms.service.impl;





import java.util.List;
import org.apache.log4j.Logger;
import cn.cms.action.interceptor.CheckLoginInterceptor;
import cn.cms.dao.IClass;
import cn.cms.mode.Class;

import cn.cms.service.ClassService;

public class ClassServiceImpl extends BaseServiceImpl implements ClassService{
	private static Logger logger = Logger.getLogger(CheckLoginInterceptor.class); //日志初始化

	
	private IClass iClass;

	
	public ClassServiceImpl() {
		iClass = getSqlSession().getMapper(IClass.class);
	}
	
	
	
	public List<Class> findAll() {
		return iClass.findAll();
	}

	public String findAll(Class c, int start, int upperIndex) {
		
		

		return null;
	}

	public Class update(Class c) {
		logger.info("跟新班级信息 ClassServiceImpl " + c);
		int i = iClass.update(c);	
		commit();
		close();
		if(i > 0) {
			return c;
		} else {
			return null;
		}
	}



	public Class add(Class c) {
		logger.info("添加信息 ClassServiceImpl " + c);
		int i = iClass.add(c);	
		commit();
		close();
		if(i > 0) {
			return c;
		} else {
			return null;
		}
	}



	public int delete(String id) {
		logger.info("删除班级信息 ClassServiceImpl " + id);
		int i = iClass.delete(id);	
		commit();
		close();
		return i;
	}

}
