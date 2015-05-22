package cn.cms.mode;

/**
 * 学生
 * @author Administrator
 *
 */
public class Student{

	private String id;
	private String name;
	private String sex;
	private int age;
	private String classId;
	
	public Student() {}

	public Student(String id, String name, String sex, int age, String classId) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.classId = classId;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", age=" + age + ", classId=" + classId + "]";
	}
	
	
}
