package cn.cms.action.interceptor;

import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;


import cn.cms.action.LoginAction;
import cn.cms.action.LogoutAction;
import cn.cms.action.RegistAction;
import cn.cms.action.ValidateCodeAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CheckLoginInterceptor extends AbstractInterceptor {
	private static Logger logger = Logger.getLogger(CheckLoginInterceptor.class); //日志初始化
	private static final long serialVersionUID = 1L;
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO login 拦击器
	
		logger.info("开始检查登录拦截！");
	
		Map<String, Object> sessionMap = invocation.getInvocationContext().getSession();
		
		Object action = invocation.getAction();
		
		if (action instanceof LogoutAction || action instanceof ValidateCodeAction || action instanceof RegistAction) {
			return invocation.invoke();
		}
		
		
		if(action instanceof LoginAction){
			if(sessionMap.get("logined") != null){
				logger.info("已经登录 ");
				return "main";	
				
			} else {
				String s = ServletActionContext.getRequest().getParameter("login");
				if(s == null) {
					return "index";
				}
				
				return invocation.invoke();
			}
			
			
		} else {
			
			if(sessionMap.get("logined") != null){
				return invocation.invoke();	
				
			} else {			
				return "index";
			}
			
			
		}
		
	}

	
}
