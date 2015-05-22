package cn.cms.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.standard.MediaSize.ISO;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import cn.cms.mode.Class;
import cn.cms.mode.Classroom;
import cn.cms.service.ClassService;
import cn.cms.service.ClassroomService;
import cn.cms.service.impl.ClassServiceImpl;
import cn.cms.service.impl.ClassroomServiceImpl;


@SuppressWarnings("serial")
public class ClassroomAction extends BaseAction implements ServletResponseAware {
	private static Logger logger = Logger.getLogger(JsonAction.class);

	private String id;
	private String name;
	private int seating;			
	private String teachBuildId;

	private ClassroomService service;
	private HttpServletResponse response;
	private PrintWriter pw;
	
	public ClassroomAction() {
		service = new ClassroomServiceImpl();
	}
	
	@SuppressWarnings("unused")
	private void myValidate() {
		
		try{
			if(id==null || id.trim().equals("")) {
				pw.write("编号不能为空");
				pw.flush();
				pw.close();
				return;
			}
			
			if(name==null || name.trim().equals("")) {
				pw.write("用户名不能为空");
				pw.flush();
				pw.close();
				return;
			}
			
		}catch (Exception e) {
			pw.write("服务器异常");
		}
	}
	
	public void update() {
		logger.info("更新信息");
		
		myValidate();
		
		try {
			Classroom cr = service.update(new Classroom(id, name, seating, teachBuildId));
			System.out.println("#########################" + cr);
			if(cr != null)
				pw.write("true");
			else
				pw.write("更新失败");
		} catch (Exception e) {
			pw.write("服务器异常");
		} finally {
			pw.flush();
			pw.close();
			System.out.println("close");
		}
	}
	
	
	public void add(){
		logger.info("添加信息");
		
		myValidate();
		try {
			Classroom cr = service.add(new Classroom(id, name, seating, teachBuildId));
			if(cr != null)
				pw.write("true");
			else
				pw.write("添加失败");
		} catch (Exception e) {
			pw.write("服务器异常");
		} finally {
			pw.flush();
			pw.close();
		}
	}
	
	public void delete(){
		logger.info("删除信息");
	
		try {
			if(service.delete(id) == 1){
				pw.write("true");
			} else {
				pw.write("删除失败");
			}	
		} catch (Exception e) {
			pw.write("服务器异常");
		} finally {
			pw.flush();
			pw.close();
		}
		
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeating() {
		return seating;
	}

	public void setSeating(int seating) {
		this.seating = seating;
	}

	public String getTeachBuildId() {
		return teachBuildId;
	}

	public void setTeachBuildId(String teachBuildId) {
		this.teachBuildId = teachBuildId;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		response.setContentType("text/html;charset=utf-8");  
	    //response.setCharacterEncoding("UTF-8"); 
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
}
