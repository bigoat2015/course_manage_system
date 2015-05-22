package cn.cms.service;

import java.util.List;

import cn.cms.mode.Teacher;

public interface TeacherService {
	 
	public List<Teacher> findAll();

	public Teacher update(Teacher teacher);

	public int delete(String id);

	public Teacher add(Teacher teacher);


}
