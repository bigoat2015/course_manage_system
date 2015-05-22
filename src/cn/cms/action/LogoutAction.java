package cn.cms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import cn.cms.action.interceptor.CheckLoginInterceptor;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements ServletRequestAware{
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(CheckLoginInterceptor.class); //日志初始化 
	private HttpSession session;
	
	public String logout(){
		logger.info("正在退出登录......");
		
		try{
			if(session.getAttribute("logined") != null){
				session.removeAttribute("logined");
				logger.info("退出登录成功");	
				return "index";
				
			} else{
				return ERROR;
			}
			
		} catch (IllegalStateException e) {
			logger.error("退出登录异常");
			return ERROR;
		}
		
	}

	public void setServletRequest(HttpServletRequest request) {
		this.session = request.getSession();
	}

}
