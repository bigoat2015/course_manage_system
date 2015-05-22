package cn.cms.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.cms.mode.Course;
import cn.cms.mode.User;
import cn.cms.service.CourseService;
import cn.cms.service.UserService;
import cn.cms.service.impl.CourseServiceImpl;
import cn.cms.service.impl.UserServiceImpl;

public class UserAction extends BaseAction implements ServletResponseAware{

	private String username;
	private String nickname;
	private String password;
	private String confirmPassword;
	private String sex;
	private String phoneNumber;
	private String email;
	private String birthday;
	private String address;
	private String question;
	private String answer;
	private String verificationCode;
	

	private UserService service;
	private HttpServletResponse response;
	private PrintWriter pw;
	
	public UserAction() {
		service = new UserServiceImpl();
	}
	
	@SuppressWarnings("unused")
	private void myValidate() {
		// 学号效验	
		
		try{
			if(!username.matches("^\\d{1,20}$") || username.equals("")){
				pw.write("学号只能是纯数字，且12位以上 不能为空");
				pw.flush();
				pw.close();
				return;
			}
				
			
			// 密码效验
			if (!password.matches("^[a-z0-9A-Z]{6,20}$") || password.equals("")) {
				pw.write("密码只能是 a-z0-9A-Z 6位以上 不能为空");
				pw.flush();
				pw.close();
				return;
			}	
			
			
		}catch (Exception e) {
			pw.write("服务器异常");
		} 
	}
	
	public void update() {
		
		
		myValidate();
		
		try {
			User c = service.update(new User(username, nickname, password, "", sex, phoneNumber, email, birthday, address, question, answer, ""));
			if(c != null)
				pw.write("true");
			else
				pw.write("更新失败");
		} catch (Exception e) {
			pw.write("服务器异常");
		} finally {
			pw.flush();
			pw.close();
		}
	}
	
	
	public void add(){
		
		
		myValidate();
		try {
			User c = service.add(new User(username, nickname, password, "", sex, phoneNumber, email, birthday, address, question, answer, ""));
			if(c != null)
				pw.write("true");
			else
				pw.write("添加失败");
		} catch (Exception e) {
			pw.write("服务器异常");
		} finally {
			pw.flush();
			pw.close();
		}
	}
	
	public void delete(){
		
	
		try {
			if(service.delete(username) == 1){
				pw.write("true");
			} else {
				pw.write("删除失败");
			}	
		} catch (Exception e) {
			pw.write("服务器异常");
		} finally {
			pw.flush();
			pw.close();
		}	
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public PrintWriter getPw() {
		return pw;
	}

	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		response.setContentType("text/html;charset=utf-8");  
	    //response.setCharacterEncoding("UTF-8"); 
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	
}
