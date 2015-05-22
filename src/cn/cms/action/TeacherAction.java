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
import cn.cms.mode.Course;
import cn.cms.mode.Teacher;
import cn.cms.service.ClassService;
import cn.cms.service.ClassroomService;
import cn.cms.service.CourseService;
import cn.cms.service.TeacherService;
import cn.cms.service.impl.ClassServiceImpl;
import cn.cms.service.impl.ClassroomServiceImpl;
import cn.cms.service.impl.CourseServiceImpl;
import cn.cms.service.impl.TeacherServiceImpl;


@SuppressWarnings("serial")
public class TeacherAction extends BaseAction implements ServletResponseAware {
	private static Logger logger = Logger.getLogger(TeacherAction.class);

	private String id;
	private String name;
	private String sex;
	private int age;
	private String teacherTitle;	// 教师职称
	private String department;		// 部门
	
	private TeacherService service;
	private HttpServletResponse response;
	private PrintWriter pw;
	
	public TeacherAction() {
		service = new TeacherServiceImpl();
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
				pw.write("名称不能为空");
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
			Teacher c = service.update(new Teacher(id, name, sex, age, teacherTitle, department));
			if(c != null)
				pw.write("true");
			else
				pw.write("更新失败");
		} catch (Exception e) {
			pw.write("服务器异常");
		} finally {
			pw.flush();
			pw.close();
		}
	}
	
	
	public void add(){
		logger.info("添加信息");
		
		myValidate();
		try {
			Teacher c = service.add(new Teacher(id, name, sex, age, teacherTitle, department));
			if(c != null)
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTeacherTitle() {
		return teacherTitle;
	}

	public void setTeacherTitle(String teacherTitle) {
		this.teacherTitle = teacherTitle;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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
