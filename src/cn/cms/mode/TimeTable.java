package cn.cms.mode;

public class TimeTable {

	private int id;
	private String classId;
	private String teacherId;
	private String courseId;
	private float credit = 0.0f;		//  学分
	private int period = 0;			// 课时
	private String examination;	// 考核方式
	private int studentCount = 0;	// 上课人数
	private String week;		// 周次
	private String section;		// 节次
	private String locale;		// 上课地点
	
	public TimeTable() {}

	public TimeTable(String classId, String teacherId, String courseId,
			float credit, int period, String examination, int studentCount,
			String week, String section, String locale) {
		this.classId = classId;
		this.teacherId = teacherId;
		this.courseId = courseId;
		this.credit = credit;
		this.period = period;
		this.examination = examination;
		this.studentCount = studentCount;
		this.week = week;
		this.section = section;
		this.locale = locale;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getExamination() {
		return examination;
	}

	public void setExamination(String examination) {
		this.examination = examination;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@Override
	public String toString() {
		return "[id:" + id + ", classId:" + classId + ", courseId:"
				+ courseId + ", teacherId:" + teacherId + ", credit:" + credit
				+ ", period:" + period + ", studentCount:" + studentCount
				+ ", examination:" + examination + ", week:" + week
				+ ", section:" + section + ", locale:" + locale + "]";
	}
	
}
