package cn.cms.test;


import java.util.List;

import org.junit.Test;

import cn.cms.dao.ISchool;
import cn.cms.mode.School;

public class TestSchoolDao extends TestBase{

	ISchool iSchool;
	
	public TestSchoolDao() {
		// TODO Auto-generated constructor stub
		iSchool = getSqlSession().getMapper(ISchool.class);
	}
	
	@Test
	public void add(){
		try{
			
			School school = new School("10663", "贵州师范大学", "贵州 贵阳");	
			int i = iSchool.add(school);
			commit();
			System.out.println("add: " + i);
			
		}finally{
			close();
		}
		
	}
	
	@Test
	public void delete(){
		try {
			
			int i = iSchool.delete("1");
			commit();
			System.out.println("delete: " + i);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void update(){
	try {		
			School school = new School("10337", "贵州电子信息技术学院", "凯里");
			int i = iSchool.update(school);
			commit();
			System.out.println("update: " + i);
			
		} finally {
			close();
		}
		
	}
	
	@Test
	public void findById(){
		try {		
			School school = iSchool.findById("10336");
			System.out.println("findById: " + school);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void findAll(){
		try {		
			List<School> schools = iSchool.findAll();
			
			System.out.println("findAll: ");
			for (School school2 : schools) {
				System.out.println(school2);
			}
			
		} finally {
			close();
		}
	}
	
}
