package cn.cms.util;

import java.security.MessageDigest;
import java.util.UUID;

import cn.cms.exception.MyException;

import sun.misc.BASE64Encoder;

/**
 * 加密
 * @author Administrator
 *
 */
public class Encryption {

	//private static final String KEY = ":cookie@localhost.com";	// 密匙

	public final static String calcMD5(String ss) throws MyException{
		
		String s = ss==null ? "" : ss;
		
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'}; //字典
		
		try{
			
			byte[] strTemp = s.getBytes();
			
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			
			mdTemp.update(strTemp);	//更新数据
			
			byte[] md = mdTemp.digest();	// 加密
			
			int j = md.length;
			
			char str[] = new char[j*2];		//新字符串数组
			
			int k = 0;	// 计数器
			
			for(int i=0; i<j; i++){
				
				byte b = md[i];
				str[k++] = hexDigits[b >>> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			
			return new String(str);		//加密后的字符串
			
			
		}catch(Exception e){
			throw new MyException("error", "密码转换时出错");
		}
		
	}
	
	
	public final static String baseMd5(String message) throws Exception {

		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(message.getBytes());
			
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		
		} catch (Exception e) {
			throw e;
		}
	}
	
	// 产生全球唯一的ID值
	public final static String generateID(){
		return UUID.randomUUID().toString();
	}
	
}
