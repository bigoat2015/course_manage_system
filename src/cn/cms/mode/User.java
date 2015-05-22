package cn.cms.mode;

public class User {
	
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

	public User(){}

	public User(String username, String nickname, String password,
			String confirmPassword, String sex, String phoneNumber,
			String email, String birthday, String address, String question,
			String answer, String verificationCode) {
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthday = birthday;
		this.address = address;
		this.question = question;
		this.answer = answer;
		this.verificationCode = verificationCode;
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

	@Override
	public String toString() {
		return "User [username=" + username + ", nickname=" + nickname
				+ ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", sex=" + sex + ", birthday=" + birthday
				+ ", email=" + email + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", question=" + question
				+ ", answer=" + answer + ", verificationCode="
				+ verificationCode + "]";
	};
	
	
}
