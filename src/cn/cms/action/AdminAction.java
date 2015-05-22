package cn.cms.action;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class AdminAction extends BaseAction{

	private String operObject;
	private Map<String, String> thead;
	
	
	public String classes(){
		
		thead = new LinkedHashMap<String, String>();
		thead.put("id", "编号");
		thead.put("name", "名称");
		thead.put("grade", "年级");
		thead.put("totalStudent", "学生人数");
		thead.put("instructor", "辅导员");
		thead.put("specialty", "专业");
		thead.put("college", "所属学院");
		
		return SUCCESS;
	}
	
	
	public String classroom() {
		
		thead = new LinkedHashMap<String, String>();
		thead.put("id", "编号");
		thead.put("name", "名称");
		thead.put("seating", "座位数");
		thead.put("teachBuildId", "教学楼号");
		
		return SUCCESS;
	}
	
	public String course() {
		
		thead = new LinkedHashMap<String, String>();
		thead.put("id", "编号");
		thead.put("name", "名称");
		return SUCCESS;
	}
	
	
	public String student() {
		
		thead = new LinkedHashMap<String, String>();
		thead.put("id", "学号");
		thead.put("name", "姓名");
		thead.put("sex", "性别");
		thead.put("age", "年龄");
		thead.put("classId", "班级");
		return SUCCESS;
	}
	
	public String teacher() {
		
		thead = new LinkedHashMap<String, String>();
		thead.put("id", "编号");
		thead.put("name", "姓名");
		thead.put("sex", "性别");
		thead.put("age", "年龄");
		thead.put("teacherTitle", "职称");
		thead.put("department", "部门");
		return SUCCESS;
	}
	
	public String teachBuild() {
		
		thead = new LinkedHashMap<String, String>();
		thead.put("id", "编号");
		thead.put("name", "名称");
		thead.put("schoolId", "校区");
		
		return SUCCESS;
	}
	
	public String user() {
		
		thead = new LinkedHashMap<String, String>();
		thead.put("username", "有户名");
		thead.put("nickname", "昵称");
		thead.put("password", "密码");
		thead.put("sex", "性格");
		thead.put("phoneNumber", "手机号码");
		thead.put("email", "邮箱");
		thead.put("birthday", "生日");
		thead.put("address", "地址");
		thead.put("question", "问题");
		thead.put("answer", "答案");
		
		return SUCCESS;
	}
	
	public String timeTable() {
		
		thead = new LinkedHashMap<String, String>();
		thead.put("id", "编号");
		thead.put("classId", "班级");
		thead.put("teacherId", "教师");
		thead.put("courseId", "课程");
		thead.put("credit", "学分");
		thead.put("period", "课时");
		thead.put("examination", "考核方式");
		thead.put("studentCount", "上课人数");
		thead.put("week", "周次");
		thead.put("section", "节次");
		thead.put("locale", "上课地点");
		
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	


	public String getOperObject() {
		return operObject;
	}


	public void setOperObject(String operObject) {
		this.operObject = operObject;
	}


	public Map<String, String> getThead() {
		return thead;
	}

	public void setThead(Map<String, String> thead) {
		this.thead = thead;
	}
	
	
	
}
