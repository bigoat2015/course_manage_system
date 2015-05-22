package cn.cms.mode;

public class Classroom extends GiveLessonsSite{

	private int seating = 0;
	private String teachBuildId;
	
	public Classroom(){}

	public Classroom(String id, String name, int seating, String teachBuildId) {
		super(id, name);
		this.seating = seating;
		this.teachBuildId = teachBuildId;
	}

	public int getSeating() {
		return seating;
	}

	public void setSeating(int seating) {
		this.seating = seating;
	}

	public String getTeachBuildId() {
		return teachBuildId;
	}

	public void setTeachBuildId(String teachBuildId) {
		this.teachBuildId = teachBuildId;
	}

	@Override
	public String toString() {
		return "Classroom [id=" + getId() + ", name="
				+ getName() + ", seating=" + seating + ", teachBuildId="
				+ teachBuildId + "]";
	};
	
	
}
