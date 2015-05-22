package cn.cms.mode;

/**
 * 教学楼
 * @author bigGoat
 *
 */
public class TeachBuild {

	private String id;
	private String name;
	private String campusId;
	
	public TeachBuild(){}

	public TeachBuild(String id, String name, String campusId) {
		this.id = id;
		this.name = name;
		this.campusId = campusId;
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

	public String getSchoolId() {
		return campusId;
	}

	public void setCampusId(String campusId) {
		this.campusId = campusId;
	}

	@Override
	public String toString() {
		return "TeachBuild [id=" + id + ", name=" + name + ", campusId="
				+ campusId + "]";
	}
	
	
}
