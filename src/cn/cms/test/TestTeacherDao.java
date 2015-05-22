package cn.cms.test;


import java.util.List;

import org.junit.Test;

import cn.cms.dao.ITeacher;
import cn.cms.mode.School;
import cn.cms.mode.Teacher;

public class TestTeacherDao extends TestBase{

	ITeacher iTeacher;
	
	public TestTeacherDao() {
		// TODO Auto-generated constructor stub
		iTeacher = getSqlSession().getMapper(ITeacher.class);
	}
	
	@Test
	public void add(){
		try{
			
			Teacher teacher = new Teacher("1", "张三", "男", 12, "教授", "数计");
			int i = iTeacher.add(teacher);
			commit();
			System.out.println("add: " + i);
			
		}finally{
			close();
		}
		
	}
	
	@Test
	public void delete(){
		try {
			
			int i = iTeacher.delete("1");
			commit();
			System.out.println("delete: " + i);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void update(){
	try {		
			Teacher teacher = new Teacher("1", "张三", "男", 32, "教授", "数计");
			int i = iTeacher.update(teacher);
			commit();
			System.out.println("update: " + i);
			
		} finally {
			close();
		}
		
	}
	
	@Test
	public void findById(){
		try {		
			Teacher t = iTeacher.findById("1");
			System.out.println("findById: " + t);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void findAll(){
		try {		
			List<Teacher> ts = iTeacher.findAll();
			
			System.out.println("findAll: ");
			for (Teacher t : ts) {
				System.out.println(t);
			}
			
		} finally {
			close();
		}
	}
	
}
