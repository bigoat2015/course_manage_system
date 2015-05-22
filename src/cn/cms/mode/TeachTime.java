package cn.cms.mode;

public class TeachTime {
	
	private String year;	// 学年
	private int term; 		// 学期
	private int week; 		// 周
	private int day; 		// 星期
	private int section;	// 节次
	private String locale;	// 地点
	private String teachId;	// 教授id

	public TeachTime() {
	}

	public TeachTime(String year, int term, int week, int day, int section,
			String locale, String teachId) {
		this.year = year;
		this.term = term;
		this.week = week;
		this.day = day;
		this.section = section;
		this.locale = locale;
		this.teachId = teachId;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getTeachId() {
		return teachId;
	}

	public void setTeachId(String teachId) {
		this.teachId = teachId;
	}

	@Override
	public String toString() {
		return "TeachTime [day=" + day + ", locale=" + locale + ", section="
				+ section + ", teachId=" + teachId + ", term=" + term
				+ ", week=" + week + ", year=" + year + "]";
	}
	
}
