package cn.cms.service.impl;

import java.util.List;

import cn.cms.dao.IUser;
import cn.cms.exception.MyException;
import cn.cms.mode.User;
import cn.cms.service.UserService;
import cn.cms.util.Encryption;

public class UserServiceImpl extends BaseServiceImpl implements UserService {

	private IUser iUser ;
	
	public UserServiceImpl() {
		iUser = getSqlSession().getMapper(IUser.class);
	}
	
	public User login(User user) throws MyException {
		// TODO 处理登录
		try {

			User u = iUser.findByUsername(user.getUsername());
			
			if(u != null){
				String password = Encryption.calcMD5(user.getPassword());
				if(u.getPassword().equals(password)){
					return u;
				} else {
					throw new MyException("password", "密码错误");
				}
				
			} else {
				throw new MyException("username", "用户名不存在");
			}
			
		} catch (MyException e) {
			throw e;
		}
		
				
	}

	public User regist(User user) throws MyException {
		// TODO 处理注册

		try {
			
			// 检查用户是否已经存在
			User u = iUser.findByUsername(user.getUsername());
			if(u != null){
				throw new MyException("username", "用户名已存在");
			}
			
			
			String password = user.getPassword();
			
			password  = Encryption.calcMD5(password);		// 加密
			user.setPassword(password);
			
			if(iUser.add(user) != 1){
				throw new MyException("error", "注册用户异常，请刷新后，重试");
			}
			
			commit();	// 记得提交才真正的将数据插入 数据库中
			
		} catch (MyException e) {
			throw e;
		} finally{
			close();
		}
		
		return user;
	}

	public List<User> findAll() {
		
		return iUser.findAll();
	}

	public User add(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public int delete(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
