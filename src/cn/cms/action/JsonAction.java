package cn.cms.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletResponseAware;

import cn.cms.service.ClassroomService;
import cn.cms.service.ClassService;
import cn.cms.service.CourseService;
import cn.cms.service.StudentService;
import cn.cms.service.TeachBuildService;
import cn.cms.service.TeacherService;
import cn.cms.service.TimeTableService;
import cn.cms.service.UserService;
import cn.cms.service.impl.ClassroomServiceImpl;
import cn.cms.service.impl.ClassServiceImpl;
import cn.cms.service.impl.CourseServiceImpl;
import cn.cms.service.impl.StudentServiceImpl;
import cn.cms.service.impl.TeachBuildServiceImpl;
import cn.cms.service.impl.TeacherServiceImpl;
import cn.cms.service.impl.TimeTableServiceImpl;
import cn.cms.service.impl.UserServiceImpl;
import cn.cms.util.Json;

@SuppressWarnings("serial")
public class JsonAction extends BaseAction implements ServletResponseAware{
	private static Logger logger = Logger.getLogger(JsonAction.class);
	private HttpServletResponse response;
	private PrintWriter pw;
	
	public void findClasses(){
		logger.info("获取Class for Json");
		try {
			ClassService server = new ClassServiceImpl();
			String json = Json.list2JSON(server.findAll());
			PrintWriter pw = response.getWriter();
			pw.write(json);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void updateClasses() {
		try {
			ClassService service = new ClassServiceImpl();
			//service.update(c);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void findClassroom() {
		logger.info("获取findClassRoom for Json");
		ClassroomService service = new ClassroomServiceImpl();
		String json = Json.list2JSON(service.findAll());
		pw.write(json);
		pw.flush();
		pw.close();
	}
	

	
	public void findCourse() {
		logger.info("获取findCourse for Json");
		CourseService service = new CourseServiceImpl();
		String json = Json.list2JSON(service.findAll());
		pw.write(json);
		pw.flush();
		pw.close();
	}
	
	public void findStudent() {
		logger.info("获取findStudent for Json");
		StudentService service = new StudentServiceImpl();
		String json = Json.list2JSON(service.findAll());
		pw.write(json);
		pw.flush();
		pw.close();
	}
	
	public void findTeacher() {
		logger.info("获取findTeacher for Json");
		TeacherService service = new TeacherServiceImpl();
		String json = Json.list2JSON(service.findAll());
		pw.write(json);
		pw.flush();
		pw.close();
	}
	
	public void findTeachBuild() {
		logger.info("获取findTeachBuild for Json");
		TeachBuildService service = new TeachBuildServiceImpl();
		String json = Json.list2JSON(service.findAll());
		pw.write(json);
		pw.flush();
		pw.close();
	}
	
	public void findTimeTable() {
		logger.info("获取TimeTable for Json");
		TimeTableService service = new TimeTableServiceImpl();
		String json = Json.list2JSON(service.findAll());
		pw.write(json);
		pw.flush();
		pw.close();
	}
	
	
	
	public void findUser() {
		logger.info("获取findUser for Json");
		UserService service = new UserServiceImpl();
		String json = Json.list2JSON(service.findAll());
		pw.write(json);
		pw.flush();
		pw.close();
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
