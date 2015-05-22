package cn.cms.mode;

import java.util.HashMap;
import java.util.Map;

public class WeekCourse {
	
	private String week;
	
	private int data[];
	
	private int section[];
	
	private Map<String,String> cm;
	
	public WeekCourse() {
	}

	public WeekCourse(String week, int[] data, int[] section, Map<Integer[][], String> cm) {
		
		this.week = week;
		this.data = data;
		this.section = section;
	
	}

	public WeekCourse(String week, int data[], int[] section, String[] courseName){
		this.week = week;
		this.data = data;
		this.section = section;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < section.length; j++) {
				
			}
		}
	}
	
	
	public void addCourse(TimeTable tt) {
	
		String sec = tt.getSection();
		
		if(cm.get(sec) == null) {
			cm.put(sec, tt.toString());
			
		} else {
			cm.put(sec, cm.get(sec) + "," + tt.toString());
		}
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		WeekCourse wc = new WeekCourse();
		
		
	}

	
	
}
