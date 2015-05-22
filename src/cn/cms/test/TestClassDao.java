package cn.cms.test;


import java.util.List;

import org.junit.Test;

import cn.cms.dao.IClass;
import cn.cms.mode.Class;

public class TestClassDao extends TestBase{

	IClass iClass;
	
	public TestClassDao() {
		// TODO Auto-generated constructor stub
		iClass = getSqlSession().getMapper(IClass.class);
	}
	
	@Test
	public void add(){
		try{
			
			Class c = new Class("1", "2012计本", "2011", 87, "邓丽莎", "计算机科学与技术", "数计学院");
			int i = iClass.add(c);
			commit();
			System.out.println("add: " + i);
			
		}finally{
			close();
		}
		
	}
	
	@Test
	public void delete(){
		try {
			
			int i = iClass.delete("1");
			commit();
			System.out.println("delete: " + i);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void update(){
	try {		
			Class c = new Class("1", "2012计本", "2012", 87, "邓丽莎", "计算机科学与技术", "数计学院");
			int i = iClass.update(new Class("2011010101", "	2011汉语言1班 111", "", 11, "", "", ""));
			commit();
			System.out.println("update: " + i);
			
		} finally {
			close();
		}
		
	}
	
	@Test
	public void findById(){
		try {		
			Class c = iClass.findById("1");
			System.out.println("findById: " + c);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void findAll(){
		try {		
			List<Class> cs = iClass.findAll();
			
			System.out.println("findAll: ");
			for (Class c : cs) {
				System.out.println(c);
			}
			
		} finally {
			close();
		}
	}
	
}
