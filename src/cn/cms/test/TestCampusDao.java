package cn.cms.test;


import java.util.List;

import org.junit.Test;

import cn.cms.dao.ICampus;
import cn.cms.dao.ISchool;
import cn.cms.mode.Campus;
import cn.cms.mode.School;

public class TestCampusDao extends TestBase{

	ICampus iCampus;
	
	public TestCampusDao() {
		// TODO Auto-generated constructor stub
		iCampus = getSqlSession().getMapper(ICampus.class);
	}
	
	@Test
	public void add(){
		try{
			
			Campus campus = new Campus("1", "宝山校区", "云岩区11111", "10663");	
			int i = iCampus.add(campus);
			commit();
			System.out.println("add: " + i);
			
		}finally{
			close();
		}
		
	}
	
	@Test
	public void update(){
		try {		
			Campus campus = new Campus("1", "宝山校区", "云岩区", "10663");	
			int i = iCampus.update(campus);
			commit();
			System.out.println("update: " + i);
			
		} finally {
			close();
		}
		
	}
	
	
	@Test
	public void delete(){
		try {
			
			int i = iCampus.delete("1");
			commit();
			System.out.println("delete: " + i);
			
		} finally {
			close();
		}
	}
	@Test
	public void findById(){
		try {		
			Campus campus = iCampus.findById("1");
			System.out.println("findById: " + campus);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void findAll(){
		try {		
			List<Campus> campuss = iCampus.findAll();
			
			System.out.println("findAll: ");
			for (Campus c: campuss) {
				System.out.println(c);
			}
			
		} finally {
			close();
		}
	}
	
}
