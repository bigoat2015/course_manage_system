package cn.cms.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import cn.cms.exception.MyException;
import cn.cms.mode.User;
import cn.cms.service.UserService;
import cn.cms.service.impl.UserServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

public class RegistAction extends ActionSupport{
	private static final long serialVersionUID = 946761112963787348L;

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
	
	
	// 注册数据合法性验证
	public void validate() {
		
		System.out.println(new User(username, nickname, password, confirmPassword, sex, phoneNumber, email, birthday, address, question, answer, verificationCode));
		
		// 学号效验	
		if(!username.matches("^\\d{12,20}$")){
			addFieldError("username", "学号只能是纯数字，且12位以上");
		}
			
		
		// 昵称效验，并且是汉字
		if(!nickname.equals("") && !nickname.matches("[\u4e00-\u9fa5]+")){
			addFieldError("nickname", "昵称必须是汉字");
		}
		
		// 密码效验
		if (!password.matches("^[a-z0-9A-Z]{6,20}$")) {
			addFieldError("password", "密码只能是 a-z0-9A-Z 6位以上");
			
		} else if(!password.equals(confirmPassword)){
			addFieldError("confirmPassword", "输入的两次密码不相等");			
		}
		
		// 性别效验
		if(!sex.equals("")){
			if(!(sex.equals("男") || sex.equals("女")))
				addFieldError("sex", "性别选择有误");
		}
		
		
		// 手机号码效验
		if(!phoneNumber.equals("") && !phoneNumber.matches("^\\d{11}$")){
			addFieldError("phoneNumber", "请输入11位手机号码");
		}
		
		
		// 生日效验
		if(!birthday.equals("")){
			try{
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(birthday);
				if(date.after(new Date())){
					addFieldError("birthday", "亲，你是一个未来人");
				}
				
			}catch (Exception e) {
				addFieldError("birthday", "日期格式错误");
			}
			
		}
		
		// 问题 and 答案 效验
		if (!question.equals("")) {
			if(answer.equals("")){
				addFieldError("answer", "问题答案不能为空");
			}
		} else {
			if(!answer.equals("")){
				addFieldError("question", "请选择问题");
			}
		}
		
		
		
		// 验证码效验
		String validateCode = (String) ServletActionContext.getRequest().getSession().getAttribute("validateCode");
		System.out.println("yanzhengma:" + validateCode);
		if (!verificationCode.equals(validateCode)) {
			addFieldError("verificationCode", "验证码错误");
		}
			
	}
	
	
	// 注册action
	public String regist(){
		
		UserService userService = new UserServiceImpl();
		
		User user = new User(username, nickname, password, confirmPassword, sex, phoneNumber, email, birthday, address, question, answer, verificationCode);
		
		try {			
			
			User u = userService.regist(user);
			
		}catch (MyException e) {
			addFieldError(e.getField(), e.getMessage());
			return INPUT;
		}
		
		return SUCCESS;
	}


	public String getUsername() {
		return username;
	}


	@RequiredStringValidator(message="学号不能为空")
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

	@RequiredStringValidator(message="密码不能为空")
	public void setPassword(String password) {
		this.password = password.trim();
	}

	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	@RequiredStringValidator(message="确定密码不能为空")
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword.trim();
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


	@EmailValidator(message = "邮件格式不对", key = "i18n.key", shortCircuit = false)
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
		this.question = question.trim();
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer.trim();
	}



	public String getVerificationCode() {
		return verificationCode;
	}


	@RequiredStringValidator(message="验证码不能为空")
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	
	
	
}
