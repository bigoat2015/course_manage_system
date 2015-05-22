package cn.cms.service;

import java.util.List;

import cn.cms.mode.Classroom;

public interface ClassroomService {
	 
	public List<Classroom> findAll();

	public Classroom update(Classroom classroom);

	public Classroom add(Classroom classroom);

	public int delete(String id);


}
