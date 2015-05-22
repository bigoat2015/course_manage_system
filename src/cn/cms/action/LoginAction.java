package cn.cms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import cn.cms.action.interceptor.CheckLoginInterceptor;
import cn.cms.exception.MyException;
import cn.cms.mode.User;
import cn.cms.service.UserService;
import cn.cms.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class LoginAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 946761112963787349L;
	private static Logger logger = Logger.getLogger(CheckLoginInterceptor.class); //日志初始化
	
	private String username;
	private String password;
	private String verificationCode;
	private HttpServletRequest request;
	private HttpSession session;
	

	@Override
	public void validate() {
		// TODO 验证字段合法性
		
		logger.info("登录数据效验");
		
		// 学号效验	
		if(!username.matches("^\\d{12,20}$")){
			addFieldError("username", "学号只能是纯数字，且12位以上");
		}
			
		
		// 密码效验
		if (!password.matches("^[a-z0-9A-Z]{6,20}$")) {
			addFieldError("password", "密码只能是 a-z0-9A-Z 6位以上");
		}
		
		
		// 验证码效验
		String validateCode = (String) ServletActionContext.getRequest().getSession().getAttribute("validateCode");
		System.out.println("yanzhengma:" + validateCode);
		if (!verificationCode.equals(validateCode)) {
			addFieldError("verificationCode", "验证码错误");
		}
		
		
	}

	
	public String login(){
		
		logger.info("登录中。。。。。。");
		
		UserService userService = new UserServiceImpl();
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		
		try {
			User u = userService.login(user);
			session.setAttribute("logined", u.getNickname());
			return "admin";
		} catch (MyException e) {
			addFieldError(e.getField(), e.getMessage());
			return INPUT;
		}
				
	}


	public String getUsername() {
		return username;
	}

	@RequiredStringValidator(message="用户名不能为空")
	public void setUsername(String username) {
		this.username = username.trim();
	}

	public String getPassword() {
		return password;
	}

	@RequiredStringValidator(message="密码不能为空")
	public void setPassword(String password) {
		this.password = password.trim();
	}

	
	public String getVerificationCode() {
		return verificationCode;
	}

	@RequiredStringValidator(message="验证码不能为空")
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}



	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}


	
	
}
