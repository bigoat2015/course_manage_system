package cn.cms.test;

import java.math.BigInteger;

import com.opensymphony.xwork2.Action;

import cn.cms.util.Encryption;

public class T  {

	
	public static void reg(String s){
		
		boolean b = s.matches("^[a-zA-Z][a-z0-9A-Z_]{3,16}");	// 用户名
		boolean b1 = s.matches("");		// 学号
		
		
		System.out.println(s + ": " + b);
		
	}
	
	
	public static void main(String[] args) {
		
		String phoneNumber = "111111";
		boolean b = phoneNumber.matches("^[a-z0-9A-Z]{6,20}$");
		System.out.println(b);
	}


}
