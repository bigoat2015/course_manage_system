package cn.cms.service.impl;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public abstract class BaseServiceImpl {

	static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	private SqlSession sqlSession;
	
	static {
		try {
			reader = Resources.getResourceAsReader("mybatis-configuration.xml"); 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public SqlSession getSqlSession(){
		this.sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	public void commit(){
		sqlSession.commit();
	}
	
	public void close(){
		sqlSession.close();
	}
}
