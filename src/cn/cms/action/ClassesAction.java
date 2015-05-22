package cn.cms.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.standard.MediaSize.ISO;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import cn.cms.mode.Class;
import cn.cms.service.ClassService;
import cn.cms.service.impl.ClassServiceImpl;


@SuppressWarnings("serial")
public class ClassesAction extends BaseAction implements ServletResponseAware {
	private static Logger logger = Logger.getLogger(JsonAction.class);

	private String id;
	private String name;
	private String grade;			// 年级	
	private int totalStudent;		// 人数
	private String instructor;		// 辅导员
	private String specialty;		// 专业
	private String college;		// 学院
	
	private HttpServletResponse response;
	private PrintWriter pw;
	
	
	@SuppressWarnings("unused")
	private String myValidate() {
		
		if(id==null || id.trim().equals("")) {
			return "编号不能为空";
		}
		
		if(name==null || name.trim().equals("")) {
			return "用户名不能为空";
		}
		
		return null;
	}
	
	public void update() {
		logger.info("更新班级信息");
		String isOk = "false";
		try {
			ClassService service = new ClassServiceImpl();
			Class c = service.update(new Class(id, name, grade, totalStudent, instructor, specialty, college));
			if(c != null) isOk = "true";
			pw.write(isOk);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			pw.write("error");
			pw.flush();
			pw.close();
		}
	}
	
	
	public void add(){
		logger.info("添加班级信息");
		
		String v = myValidate();
		if(v == null) {
			try {
				ClassService service = new ClassServiceImpl();
				Class c = service.add(new Class(id, name, grade, totalStudent, instructor, specialty, college));
				if(c != null) {
					pw.write("true");
					pw.flush();
					pw.close();
				} else {
					pw.write("添加失败");
					pw.flush();
					pw.close();
				} 
				
			} catch (Exception e) {
				pw.write("error");
				pw.flush();
				pw.close();
			}
			
		} else {
			pw.write(v);
			pw.flush();
			pw.close();
			
		}	
	}
	
	public void delete(){
		logger.info("删除班级信息");
	
		try {
			ClassService service = new ClassServiceImpl();
			int i = service.delete(id);
			if(i == 1) {
				pw.write("true");
				pw.flush();
				pw.close();
			} else {
				pw.write("删除失败");
				pw.flush();
				pw.close();
			} 
			
		} catch (Exception e) {
			pw.write("服务器异常");
			pw.flush();
			pw.close();
		}
	}

	public String getId() {
		return id;
	}
	
	//@RequiredStringValidator(message="id不能为空")
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

//	@RequiredStringValidator(message="名称不能为空")
	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getTotalStudent() {
		return totalStudent;
	}

	public void setTotalStudent(int totalStudent) {
		this.totalStudent = totalStudent;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
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
