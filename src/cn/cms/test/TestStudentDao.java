package cn.cms.test;


import java.util.List;

import org.junit.Test;

import cn.cms.dao.IStudent;
import cn.cms.mode.School;
import cn.cms.mode.Student;

public class TestStudentDao extends TestBase{

	IStudent iStudent;
	
	public TestStudentDao() {
		// TODO Auto-generated constructor stub
		iStudent = getSqlSession().getMapper(IStudent.class);
	}
	
	@Test
	public void add(){
		try{
			
			Student student = new Student("1", "王五", "", 12, "1");
			int i = iStudent.add(student);
			commit();
			System.out.println("add: " + i);
			
		}finally{
			close();
		}
		
	}
	
	@Test
	public void delete(){
		try {
			
			int i = iStudent.delete("1");
			commit();
			System.out.println("delete: " + i);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void update(){
	try {		
			Student student = new Student("1", "王五", "男", 12, "1");
			int i = iStudent.update(student);
			commit();
			System.out.println("update: " + i);
			
		} finally {
			close();
		}
		
	}
	
	@Test
	public void findById(){
		try {		
			Student s = iStudent.findById("1");
			System.out.println("findById: " + s);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void findAll(){
		try {		
			List<Student> ss = iStudent.findAll();
			
			System.out.println("findAll: ");
			for (Student s : ss) {
				System.out.println(s);
			}
			
		} finally {
			close();
		}
	}
	
}
