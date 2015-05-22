package cn.cms.util;
  
import java.io.IOException;  
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;  
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;  
import org.apache.commons.httpclient.NameValuePair;  
import org.apache.commons.httpclient.methods.GetMethod;  
import org.apache.commons.httpclient.methods.PostMethod;  
  
/**
 * 模拟HTTP 请求 到师大官网获取 教室 教师 课程等信息
 * 
 * 教学楼：GET - "http://202.101.92.20:85/jwweb/ZNPK/Private/List_JXL.aspx"
 * 
 * 教室：GET - "http://202.101.92.20:85/jwweb/ZNPK/Private/List_ROOM.aspx?w=150"
 * 
 * 老师编号 姓名： GET "http://202.101.92.20:85/jwweb/ZNPK/Private/List_JS.aspx?xnxq=20140&js="
 * 其它信息 :		 POST "http://202.101.92.20:85/jwweb/ZNPK/TeacherKBFB_rpt.aspx" 
 *				   Sel_JS	0000399	
 *				   Sel_XNXQ	20050	
 *				   type	1	
 * 
 * @author Administrator
 *
 */
public class SimulateHttpRequest {  
  
	
	/**
	 * post 			请求
	 * @param url		请求地址
	 * @param param		post请求需要的参数
	 * @return			返回请求得到的 html文档
	 */
	public static String simulatePost(String url, HashMap<String, String> param, String referer) {
		
		if(url == null) return null;	
		
		HttpClient httpClient = new HttpClient();
		
		PostMethod method = new PostMethod(url); 
		method.setRequestHeader("Referer", referer);	// 设置header 信息 放置拦截
	    //method.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");    // 请求编码设置
		
		try {
			
			if(param == null || param.isEmpty()) {		//参数为空直接提交请求
				
				method.releaseConnection();
				httpClient.executeMethod(method);
				return method.getResponseBodyAsString();
				
			} else {									//请求参数不为空 处理
				
				Iterator<String> keys = param.keySet().iterator();
				NameValuePair[] pairs = new NameValuePair[param.size()];
				
				for (int i = 0; keys.hasNext(); i++) {
					String key = keys.next();
					String value = param.get(key);
					pairs[i] = new NameValuePair(key, value);
				}
				method.addParameters(pairs);
				method.releaseConnection();
				httpClient.executeMethod(method);
				return method.getResponseBodyAsString();
					
			}
		
			} catch (HttpException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		
		return null;
	}
	
	/**
	 * GET 请求
	 * @param url		请求地址
	 * @param param		GET请求参数
	 * @return			返回请求到的html文档
	 */
	
	public static String simulateGet(String url, HashMap<String, String> param) {
		
		if(url == null)	return null;
		
		HttpClient httpClient = new HttpClient();
		HttpMethod method = new GetMethod(url);
		
		try {
		
		if(param == null || param.isEmpty()) {			// 请求参数为空
			
			method.releaseConnection();
			httpClient.executeMethod(method);
			return method.getResponseBodyAsString();
			
									
		} else {										// 请求参数不为空
			
			StringBuffer sb = new StringBuffer(url);
			Iterator<String> keys = param.keySet().iterator();
			
			for (int i = 0; keys.hasNext(); i++) {
				String key = keys.next();
				
				if(i ==0 )
					sb.append("?" + key +"=" + param.get(key));
				else
					sb.append("&" + key +"=" + param.get(key));
				
			}
//		System.out.println(sb);
			method.releaseConnection();
			httpClient.executeMethod(method);
//		System.out.println(method.getResponseBodyAsString());
			return method.getResponseBodyAsString();
				
		}
		
	
		} catch (HttpException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	 
   
}  