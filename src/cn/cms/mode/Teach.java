package cn.cms.mode;

/**
 * 授课
 * @author Administrator
 *
 */
public class Teach {
	
	private String id; // varchar(20) not null,
	private String classId;
	private String teacherId; // varchar(20),
	private String courseId;  //varchar(50),
	private float credit; // float not null,
	private int period;  //smallint unsigned not null,
	private String examination;   //varchar(20),
	
	public Teach() {}
	
	


	public Teach(String id, String classId, String teacherId, String courseId,
			float credit, int period, String examination) {
		this.id = id;
		this.classId = classId;
		this.teacherId = teacherId;
		this.courseId = courseId;
		this.credit = credit;
		this.period = period;
		this.examination = examination;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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

	public String getClassId() {
		return classId;
	}


	public void setClassId(String classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Teach [classId=" + classId + ", courseId=" + courseId
				+ ", credit=" + credit + ", examination=" + examination
				+ ", id=" + id + ", period=" + period + ", teacherId="
				+ teacherId + "]";
	}

	
}
