package cn.cms.test;


import java.util.List;

import org.junit.Test;

import cn.cms.dao.ISchool;
import cn.cms.dao.ITeachBuild;
import cn.cms.mode.School;
import cn.cms.mode.TeachBuild;

public class TestTeachBuildDao extends TestBase{

	ITeachBuild iTeachBuild;
	
	public TestTeachBuildDao() {
		// TODO Auto-generated constructor stub
		iTeachBuild = getSqlSession().getMapper(ITeachBuild.class);
	}
	
	@Test
	public void add(){
		try{
			
			TeachBuild teachBuild = new TeachBuild("1", "gs4404 test", "1");
			int i = iTeachBuild.add(teachBuild);
			commit();
			System.out.println("add: " + i);
			
		}finally{
			close();
		}
		
	}
	
	@Test
	public void delete(){
		try {
			
			int i = iTeachBuild.delete("1");
			commit();
			System.out.println("delete: " + i);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void update(){
	try {		
			TeachBuild teachBuild = new TeachBuild("1", "gj3403", "1");
			int i = iTeachBuild.update(teachBuild);
			commit();
			System.out.println("update: " + i);
			
		} finally {
			close();
		}
		
	}
	
	@Test
	public void findById(){
		try {		
			TeachBuild teachBuild = iTeachBuild.findById("1");
			System.out.println("findById: " + teachBuild);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void findAll(){
		try {		
			List<TeachBuild> tbs = iTeachBuild.findAll();
			
			System.out.println("findAll: ");
			for (TeachBuild tb : tbs) {
				System.out.println(tb);
			}
			
		} finally {
			close();
		}
	}
	
}
