package cn.cms.test;



import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CookieSessionTest extends ActionSupport {
	private static final long serialVersionUID = 12313131L;


	@Override
	public String execute() throws Exception {
	
		 Cookie[] cookies = ServletActionContext.getRequest().getCookies();
	   
	    	for (int i = 0; i < cookies.length; i++) {
	    		
	    		Cookie c = cookies[i];
	    		String inf = i + 1 + " : " +"Cookie [getName()=" + c.getName() + ", getValue()="
				+ c.getValue() + ", getMaxAge()=" + c.getMaxAge()
				+ ", getComment()=" + c.getComment() + ", getDomain()="
				+ c.getDomain() + ", getPath()=" + c.getPath() + ", getSecure()="
				+ c.getSecure() + ", getVersion()=" + c.getVersion()
				+ ", getClass()=" + c.getClass() + ", hashCode()=" + c.hashCode()
				+ "]";
	    		System.out.println(inf);
			}
	    		
		return super.execute();
	}
	

}
