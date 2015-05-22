package cn.cms.mode;

/**
 * 教师
 * @author Administrator
 *
 */
public class Teacher {

	private String id;
	private String name;
	private String sex;
	private int age;
	private String teacherTitle;	// 教师职称
	private String department;		// 部门
	
	public Teacher() {}

	public Teacher(String id, String name, String sex, int age,
			String teacherTitle, String department) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.teacherTitle = teacherTitle;
		this.department = department;
	}


	public String getTeacherTitle() {
		return teacherTitle;
	}

	public void setTeacherTitle(String teacherTitle) {
		this.teacherTitle = teacherTitle;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", teacherTitle=" + teacherTitle
				+ ", department=" + department + "]";
	}
	
}
