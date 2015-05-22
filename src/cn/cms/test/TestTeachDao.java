package cn.cms.test;



import java.util.List;

import javax.swing.Spring;

import org.junit.Test;

import sun.awt.windows.WWindowPeer;

import cn.cms.dao.ITeach;
import cn.cms.dao.ITeachTime;
import cn.cms.dao.ITimeTable;
import cn.cms.mode.Teach;
import cn.cms.mode.TeachTime;
import cn.cms.mode.TimeTable;

public class TestTeachDao extends TestBase{

	ITeach iTeach;
	ITimeTable iTimeTable;
	ITeachTime iTeachTime;
	
	public TestTeachDao() {
		// TODO Auto-generated constructor stub
		
	}
	
	@Test
	public void add(){
		try{
		
			
			iTimeTable = getSqlSession().getMapper(ITimeTable.class);
			List<TimeTable> timeTable = iTimeTable.findAll();
			close();
			
			
			
			
			int cout = 1;
			int id = 0;
			int ccc = timeTable.size();
			TeachTime tt = new TeachTime();
			Teach teach = new Teach();
			
			for (TimeTable table : timeTable) {
				
				teach.setId(++id + "");
				teach.setClassId(table.getClassId());
				teach.setTeacherId(table.getTeacherId());
				teach.setCourseId(table.getCourseId());
				teach.setCredit(table.getCredit());
				teach.setPeriod(table.getPeriod());
				teach.setExamination(table.getExamination());

				iTeach = getSqlSession().getMapper(ITeach.class);
				int it = iTeach.add(teach);
				System.out.println("Teach: " + it +"-" +"-"+ccc--);
				
				commit();
				close();
				
				
				tt.setYear("2014");
				tt.setTerm(1);
				tt.setTeachId(teach.getId());
				
				String s = table.getSection();
				String w = table.getWeek();
				//int zhou = Integer.parseInt(s.charAt(0)+"");
				int zhou = Integer.parseInt(String.valueOf(s.charAt(0)));
				
				int j1 = Integer.parseInt(String.valueOf(s.charAt(2)));
				int j2 = Integer.parseInt(String.valueOf(s.charAt(4)));
			
				int jici = Integer.parseInt(j1+""+j2);
				
				tt.setLocale(table.getLocale());

				tt.setDay(zhou);
				tt.setSection(jici);
				
				iTeachTime = getSqlSession().getMapper(ITeachTime.class);
				if(s.endsWith("单")) {
					System.out.println("是单周");
	
					String[] ww = w.split("-");
					
					if(ww.length == 1){
						tt.setWeek(Integer.parseInt(ww[0]));
	
						
						int i = iTeachTime.add(tt);
						System.out.println( "--" + i +"--" +cout++);
						commit();
							
					} else {
						
						int a = Integer.parseInt(ww[0]);
						int b = Integer.parseInt(ww[1]);
						for ( ; a <= b; a++) {
							if(a%2 != 0) {
								tt.setWeek(a);
							
								int i = iTeachTime.add(tt);
								System.out.println(  "--" + i +"--" +cout++);	
								commit();
							}					
							
						}
					}
					
				} else if(s.endsWith("双")) {
					System.out.println("是双周");
						
					
					
					String[] ww = w.split("-");
					
					if(ww.length == 1){
						tt.setWeek(Integer.parseInt(ww[0]));
					
						int i = iTeachTime.add(tt);
						System.out.println("--" + i +"--" +cout++);
						commit();
							
					} else {
						
						int a = Integer.parseInt(ww[0]);
						int b = Integer.parseInt(ww[1]);
						for ( ; a <= b; a++) {
							if(a%2 == 0) {
								tt.setWeek(a);
							
								int i = iTeachTime.add(tt);
								System.out.println("--" + i +"--" +cout++);
								commit();
								
							}
							
							
						}

					}
					
					
				} else {
					System.out.println("单双周");

				
					
					String[] ww = w.split("-");
					
					if(ww.length == 1){
						tt.setWeek(Integer.parseInt(ww[0]));
					
						int i = iTeachTime.add(tt);
						System.out.println( "--" + i +"--" +cout++);
						commit();
							
					} else {
						
						int a = Integer.parseInt(ww[0]);
						int b = Integer.parseInt(ww[1]);
						for ( ; a <= b; a++) {
							
								tt.setWeek(a);
								
								int i = iTeachTime.add(tt);
								System.out.println("--" + i +"--" +cout++);	
								commit();
						}
					}			
				}
				

				close();
			}
			
		
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		finally{
			close();
		}
		
	}
	
	@Test
	public void delete(){
		try {
			
			
			
		//	System.out.println(iTimeTable.findAll());
			
			int i = iTeach.delete("2011010102");
			commit();
			System.out.println("delete: " + i);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void update(){
	try {		
			Teach teach = new Teach();
			int i = iTeach.update(teach);
			commit();
			System.out.println("update: " + i);
			
		} finally {
			close();
		}
		
	}
	
	@Test
	public void findByClassId(){
		try {		
			List<Teach> tts = iTeach.findByClassId("2011010102");
			
			System.out.println("findByClassId: " + tts);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void findAll(){
		try {		
			List<Teach>  tts = iTeach.findAll();
			
			System.out.println("findAll: ");
			for (Teach tt : tts) {
				System.out.println(tt);
			}
			
		} finally {
			close();
		}
	}
	
	


	
}
