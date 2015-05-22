package cn.cms.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.cms.dao.IStudent;
import cn.cms.mode.Student;
import cn.cms.service.StudentService;

public class StudentServiceImpl extends BaseServiceImpl implements StudentService {
	private static Logger logger = Logger.getLogger(StudentServiceImpl.class); //日志初始化

	private IStudent iStudent;
	
	public StudentServiceImpl(){
		iStudent = getSqlSession().getMapper(IStudent.class);
	}
	
	public List<Student> findAll() {
		return iStudent.findAll();
	}

	public Student add(Student student) {
		logger.info("添加信息 ServiceImpl " + student);
		int i = iStudent.add(student);	
		commit();
		close();
		if(i > 0) {
			return student;
		} else {
			return null;
		}
	}

	public int delete(String id) {
		logger.info("删除信息 ServiceImpl " + id);
		int i = iStudent.delete(id);	
		commit();
		close();
		return i;
	}

	public Student update(Student student) {
		logger.info("跟新信息 ServiceImpl " + student);
		int i = iStudent.update(student);	
		commit();
		close();
		if(i > 0) {
			return student;
		} else {
			return null;
		}
	}

}
