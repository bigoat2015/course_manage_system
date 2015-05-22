package cn.cms.test;


import java.util.Currency;
import java.util.List;

import org.junit.Test;

import cn.cms.dao.ICourse;
import cn.cms.mode.Course;
import cn.cms.mode.School;

public class TestCourseDao extends TestBase{

	ICourse iCourse;
	
	public TestCourseDao() {
		// TODO Auto-generated constructor stub
		iCourse = getSqlSession().getMapper(ICourse.class);
	}
	
	@Test
	public void add(){
		try{
			
			Course course = new Course("1", "java程序设计");
			int i = iCourse.add(course);
			commit();
			System.out.println("add: " + i);
			
		}finally{
			close();
		}
		
	}
	
	@Test
	public void delete(){
		try {
			
			int i = iCourse.delete("1");
			commit();
			System.out.println("delete: " + i);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void update(){
	try {		
			Course course = new Course("1", "c程序设计");
			int i = iCourse.update(course);
			commit();
			System.out.println("update: " + i);
			
		} finally {
			close();
		}
		
	}
	
	@Test
	public void findById(){
		try {		
			Course c = iCourse.findById("1");
			System.out.println("findById: " + c);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void findAll(){
		try {		
			List<Course> cs = iCourse.findAll();
			
			System.out.println("findAll: ");
			for (Course c : cs) {
				System.out.println(c);
			}
			
		} finally {
			close();
		}
	}
	
}
