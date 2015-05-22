package cn.cms.service;

import java.util.List;

import cn.cms.exception.MyException;
import cn.cms.mode.User;

public interface UserService {

	public User login(User user) throws MyException;
	
	public User regist(User user) throws MyException;
	
	public List<User> findAll();

	public User update(User user);

	public User add(User user);

	public int delete(String username);
}
