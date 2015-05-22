package cn.cms.mode;

/**
 * 班级
 * @author Administrator
 *
 */
public class Class {

	private String id;
	private String name;
	private String grade;			// 年级	
	private int totalStudent;		// 人数
	private String instructor;		// 辅导员
	private String specialty;		// 专业
	private String college;		// 学院
	
	public Class() {}
	
	public Class(String id, String name, String grade, int totalStudent,
			String instructor, String specialty, String college) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.totalStudent = totalStudent;
		this.instructor = instructor;
		this.specialty = specialty;
		this.college = college;
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

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", grade=" + grade
				+ ", totalStudent=" + totalStudent + ", instructor="
				+ instructor + ", specialty=" + specialty + ", college="
				+ college + "]";
	}

}
