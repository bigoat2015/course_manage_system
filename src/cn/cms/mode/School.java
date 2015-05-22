package cn.cms.mode;

/**
 * 学校
 * @author bigGoat
 */
public class School {
	
	private String id;
	private String name;
	private String site;
	
	public School(){}
	
	public School(String id, String name, String site) {
		this.id = id;
		this.name = name;
		this.site = site;
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

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", site=" + site + "]";
	}
	
}
