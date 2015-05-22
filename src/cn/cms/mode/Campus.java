package cn.cms.mode;

/**
 * 校区
 * @author bigGoat
 *
 */
public class Campus {

	private String id;
	private String name;
	private String site;
	private String schoolId;
	
	public Campus() {}

	public Campus(String id, String name, String site, String schoolId) {
		this.id = id;
		this.name = name;
		this.site = site;
		this.schoolId = schoolId;
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	@Override
	public String toString() {
		return "Campus [id=" + id + ", name=" + name + ", site=" + site
				+ ", schoolId=" + schoolId + "]";
	}
	
	
}
