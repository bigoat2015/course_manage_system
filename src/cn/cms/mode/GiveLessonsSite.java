package cn.cms.mode;

/**
 * 授课地点
 * @author Administrator
 *
 */

public abstract class GiveLessonsSite {

	private String id;
	private String name;
	
	public GiveLessonsSite(String id, String name) {
		this.id = id;;
		this.name = name;
	}
	
	public GiveLessonsSite() {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "GiveLessonsSite [id=" + id + ", name=" + name + "]";
	}
	
	
}
