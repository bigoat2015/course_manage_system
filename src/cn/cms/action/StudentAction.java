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
import cn.cms.mode.Student;
import cn.cms.service.ClassService;
import cn.cms.service.ClassroomService;
import cn.cms.service.CourseService;
import cn.cms.service.StudentService;
import cn.cms.service.impl.ClassServiceImpl;
import cn.cms.service.impl.ClassroomServiceImpl;
import cn.cms.service.impl.CourseServiceImpl;
import cn.cms.service.impl.StudentServiceImpl;


@SuppressWarnings("serial")
public class StudentAction extends BaseAction implements ServletResponseAware {
	private static Logger logger = Logger.getLogger(StudentAction.class);

	private String id;
	private String name;
	private String sex;
	private int age;
	private String classId;

	private StudentService service;
	private HttpServletResponse response;
	private PrintWriter pw;
	
	public StudentAction() {
		service = new StudentServiceImpl();
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
			Student c = service.update(new Student(id, name, sex, age, classId));
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
			Student c = service.add(new Student(id, name, sex, age, classId));
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

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
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
