package cn.cms.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.cms.dao.IUser;
import cn.cms.mode.Class;
import cn.cms.mode.User;

public class TestUserDao extends TestBase{

	IUser iUser;
	
	public TestUserDao() {
		// TODO Auto-generated constructor stub
		iUser = getSqlSession().getMapper(IUser.class);
	}
	
	@Test
	public void add() throws ParseException{
		try{
			
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Date date = sdf.parse("1991-01-15");
//			java.sql.Date bd = new java.sql.Date(date.getTime());
			
			User user = new User("root1", "1", "123", "123", "男", "123456789", "yaolunwei@qq.com", "1991-1-1", "1", "1", "1", "1234");
			int i = iUser.add(user);
			commit();
			System.out.println("add: " + i);
			
		}finally{
			close();
		}
		
	}
	
	@Test
	public void delete(){
		try {
			
			int i = iUser.delete("1");
			commit();
			System.out.println("delete: " + i);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void update(){
	try {		
		
			
			User user = new User("root", "姚论卫", "a123456", "a123456", "男", "18096051254", "yaolunwei@qq.com", "1991-1-1", "贵州省松桃苗族自治县迓驾镇迓驾村", "我在干什么", "敲代码", "1234");
			int i = iUser.update(user);
			commit();
			System.out.println("update: " + i);
			
		} finally {
			close();
		}
		
	}
	
	@Test
	public void findById(){
		try {		
			User u = iUser.findByUsername("root");
			System.out.println("findById: " + u);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void findAll(){
		try {		
			List<User> cs = iUser.findAll();
			
			System.out.println("findAll: ");
			for (User c : cs) {
				System.out.println(c);
			}
			
		} finally {
			close();
		}
	}
	
}
