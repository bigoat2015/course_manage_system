package cn.cms.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxRequestAction extends ActionSupport {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	public String findUserById(){
		System.out.println("findUserById()");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		
		String usernmae = request.getParameter("username");
		System.out.println("username="+ usernmae);
		try {
			PrintWriter pw = response.getWriter();
			Boolean b = usernmae.equals("123");
			System.out.println(b);
			pw.print(b);
			pw.flush();
			pw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("execute()");
		return super.execute();
	}
}
