package cn.cms.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.cms.dao.ISchool;
import cn.cms.mode.School;

public class DaoTest {
	
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static {
		try {
			reader = Resources.getResourceAsReader("configuration.xml"); 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void addSchool(School school){
		
		/**
	     * 测试增加,增加后，必须提交事务，否则不会写入到数据库.
	     */
		
		SqlSession session = sqlSessionFactory.openSession();
		try{
			
			ISchool iSchool = session.getMapper(ISchool.class);
			int b = iSchool.add(school);
		
			session.commit();	// 提交事务
			
			System.out.println(b+ "-" + school);
			
		}finally{
			session.close();
		}
		
	}
	
	public static void main(String[] args) {
		School school = new School("1", "贵州师范大学", "贵阳");
		DaoTest dt = new DaoTest();
		dt.addSchool(school);
	}

}
