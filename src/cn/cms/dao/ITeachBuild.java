package cn.cms.dao;

import java.util.List;
import cn.cms.mode.TeachBuild;

public interface ITeachBuild {

	public int add(TeachBuild teachBuild);

	public int delete(String id);
	
	public int update(TeachBuild teachBuild);
	
	public TeachBuild findById(String id);
	
	public List<TeachBuild> findAll();
}
