package cn.cms.dao;

import java.util.List;
import cn.cms.mode.Campus;

public interface ICampus {


	public int add(Campus campus);
	
	public int delete(String id);
	
	public int update(Campus campus);
	
	public Campus findById(String id);
	
	public List<Campus> findAll();
	
}
