package cn.cms.dao;

import java.util.List;

import cn.cms.mode.User;


public interface IUser {
	
	public int add(User user);
	
	public int delete(String username);
	
	public int update(User user);
	
	public User findByUsername(String username);
	
	public List<User> findAll();
}

