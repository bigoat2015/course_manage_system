package cn.cms.test;



import java.util.List;
import org.junit.Test;

import cn.cms.dao.ITimeTable;
import cn.cms.mode.TimeTable;

public class TestTimeTableDao extends TestBase{

	ITimeTable iTimeTable;
	
	public TestTimeTableDao() {
		// TODO Auto-generated constructor stub
		iTimeTable = getSqlSession().getMapper(ITimeTable.class);
	}
	
	@Test
	public void add(){
		try{
			
			TimeTable timeTable = new TimeTable("1", "1", "1", 1, 1, "1", 1, "1", "1", "1");
			int i = iTimeTable.add(timeTable);
			commit();
			System.out.println("add: " + i);
			
		}finally{
			close();
		}
		
	}
	
	@Test
	public void delete(){
		try {
			
			
			
		//	System.out.println(iTimeTable.findAll());
			
			List<TimeTable> list = iTimeTable.findAll();
			
			for (int i = 0; i < list.size(); i++) {
				TimeTable tt = list.get(i);
				
				String r = tt.getSection();
		
				r = r.replaceAll("一", "1");
				r = r.replaceAll("二", "2");
				r = r.replaceAll("三", "3");
				r = r.replaceAll("四", "4");
				r = r.replaceAll("五", "5");
				r = r.replaceAll("六", "6");
				r = r.replaceAll("七", "7");
				
				tt.setSection(r);
				iTimeTable.update(tt);
				commit();
				System.out.println(tt);
				
			}
			
		//	int i = iTimeTable.delete("1");
		//	commit();
		//	System.out.println("delete: " + i);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void update(){
	try {		
			TimeTable timeTable = new TimeTable("2", "2", "2", 2, 2, "2", 2, "2", "2", "2");
			timeTable.setId(4);
			int i = iTimeTable.update(timeTable);
			commit();
			System.out.println("update: " + i);
			
		} finally {
			close();
		}
		
	}
	
	@Test
	public void findByClassId(){
		try {		
			List<TimeTable> tts = iTimeTable.findByClassId("1");
			
			System.out.println("findByClassId: ");
			for (TimeTable tt : tts) {
				System.out.println(tt);
			}
			
		} finally {
			close();
		}
	}
	
	@Test
	public void findByTeacherId(){
		try {		
			List<TimeTable>  tts = iTimeTable.findByTeacherId("1");
			
			System.out.println("findAll: ");
			for (TimeTable tt : tts) {
				System.out.println(tt);
			}
			
		} finally {
			close();
		}
	}
	
}
