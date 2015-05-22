package cn.cms.test;


import java.util.List;

import org.junit.Test;

import cn.cms.dao.IClassroom;
import cn.cms.mode.Classroom;
import cn.cms.mode.School;

public class TestClassroomDao extends TestBase{

	IClassroom iclassroom;
	
	public TestClassroomDao() {
		// TODO Auto-generated constructor stub
		iclassroom = getSqlSession().getMapper(IClassroom.class);
	}
	
	@Test
	public void add(){
		try{
			
			Classroom classroom = new Classroom("1", "gj1211", 123, "2");
			int i = iclassroom.add(classroom);
			commit();
			System.out.println("add: " + i);
			
		}finally{
			close();
		}
		
	}
	
	@Test
	public void delete(){
		try {
			
			int i = iclassroom.delete("1");
			commit();
			System.out.println("delete: " + i);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void update(){
	try {		
			Classroom classroom = new Classroom("1", "gj1211", 123, "1");
			int i = iclassroom.update(classroom);
			commit();
			System.out.println("update: " + i);
			
		} finally {
			close();
		}
		
	}
	
	@Test
	public void findById(){
		try {		
			Classroom classroom = iclassroom.findById("1");
			System.out.println("findById: " + classroom);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void findAll(){
		try {		
			List<Classroom> cs = iclassroom.findAll();
			
			System.out.println("findAll: ");
			for (Classroom c : cs) {
				System.out.println(c);
			}
			
		} finally {
			close();
		}
	}
	
}
