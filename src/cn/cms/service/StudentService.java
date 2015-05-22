package cn.cms.service;

import java.util.List;

import cn.cms.mode.Student;

public interface StudentService {
	 
	public List<Student> findAll();

	public Student update(Student student);

	public Student add(Student student);

	public int delete(String id);


}
