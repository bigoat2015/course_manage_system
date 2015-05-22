package cn.cms.service;

import java.util.List;

import cn.cms.mode.TeachBuild;

public interface TeachBuildService {
	 
	public List<TeachBuild> findAll();

	public TeachBuild update(TeachBuild teachBuild);

	public TeachBuild add(TeachBuild teachBuild);

	public int delete(String id);


}
