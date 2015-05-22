package cn.cms.test;



import java.util.List;
import org.junit.Test;

import cn.cms.dao.ITeachTime;
import cn.cms.dao.ITimeTable;
import cn.cms.mode.TeachTime;
import cn.cms.mode.TimeTable;

public class TestTeachTimeDao extends TestBase{

	ITeachTime iTimeTable;
	
	public TestTeachTimeDao() {
		// TODO Auto-generated constructor stub
		iTimeTable = getSqlSession().getMapper(ITeachTime.class);
	}
	
	@Test
	public void add(){
		try{
			
			TeachTime timeTable = new TeachTime("2014", 1, 12, 1, 1, "gj2102", "2012070201");
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
			
			int i = iTimeTable.delete("2012070201");
			commit();
			System.out.println("delete: " + i);
			
		} finally {
			close();
		}
	}
	
	@Test
	public void update(){
	try {		
			TeachTime timeTable = new TeachTime("2014", 2, 12, 1, 1, "gj4102", "2012070201");
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
			List<TeachTime> tts = iTimeTable.findByClassId("2012070201");
			
			System.out.println("findByClassId: ");
			for (TeachTime tt : tts) {
				System.out.println(tt);
			}
			
		} finally {
			close();
		}
	}
	
	@Test
	public void findAll(){
		try {		
			List<TeachTime>  tts = iTimeTable.findAll();
			
			System.out.println("findAll: ");
			for (TeachTime tt : tts) {
				System.out.println(tt);
			}
			
		} finally {
			close();
		}
	}
	
}
