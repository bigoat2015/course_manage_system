package cn.cms.exception;


public class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public static final int USER_NONENTITY = 1;		//用户名不存在
	public static final int USER_PASSWORD_ERROR = 2;		//密码错误
	public static final int USER_PASSWORD_ENCRYPT = 3;		//密码转换错误
	
	
	private int errorType;
	private String message;
	private String field;
	
	
	public MyException(int errorType, String message) {
		this.errorType = errorType;
		this.message = message;
	}
	
	public MyException(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public int getErrorType() {
		return errorType;
	}

	public String getMessage() {
		return message;
	}
	
	public String getField(){
		return field;
	}
	
}
