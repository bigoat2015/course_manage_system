package cn.cms.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;


import cn.cms.dao.ICampus;
import cn.cms.dao.IClass;
import cn.cms.dao.IClassroom;
import cn.cms.dao.ITeachBuild;
import cn.cms.dao.ITeacher;
import cn.cms.dao.ITimeTable;
import cn.cms.mode.Campus;
import cn.cms.mode.Class;
import cn.cms.mode.Classroom;
import cn.cms.mode.TeachBuild;
import cn.cms.mode.Teacher;
import cn.cms.mode.TimeTable;
import cn.cms.test.TestBase;


public class Insert2DB extends TestBase{

//	private ArrayList<TeachBuild> jxls = null;
	//private ArrayList<JiaoShi> jss = new ArrayList<JiaoShi>();
	
	// 教学楼
	@Test
	public void jiaoXueLou() {
		
		String url = "http://202.101.92.20:85/jwweb/ZNPK/Private/List_JXL.aspx";
		String htmlPage = SimulateHttpRequest.simulateGet(url, null); 	
    	
		System.out.println(htmlPage);
		//ArrayList<TeachBuild> jxls = DataUtil.getJXLDataforSDWeb(htmlPage);	
    	
//    	return;
//    	try{
//    		ITeachBuild iTeachBuild = getSqlSession().getMapper(ITeachBuild.class);
//    		
//    		for (int i = 0; i < jxls.size(); i++) {
//    			TeachBuild tb = jxls.get(i);
//				iTeachBuild.add(tb);
//				System.out.println(tb);
//			}
//    		//commit();
//    	} finally {
//    		close();
//    	}
    	
	}
	
	
	// 教室
	public void jiaoShi() {
		
		ITeachBuild iTeachBuild = getSqlSession().getMapper(ITeachBuild.class);
		List<TeachBuild> jxls = iTeachBuild.findAll();
		
    	IClassroom iClassroom = getSqlSession().getMapper(IClassroom.class);
    	
		String jxlid = null;		
		try{
			for (int i = 0; i < jxls.size(); i++) {		// 根据教学楼编号 获取教室
			
			
				
				jxlid = jxls.get(i).getId();
				String url1 = "http://202.101.92.20:85/jwweb/ZNPK/Private/List_ROOM.aspx?w=150&id=" + jxlid; 
				String htmlPage = SimulateHttpRequest.simulateGet(url1, null);
				List<Classroom> cs = DataUtil.getJSDataforSDWeb(htmlPage, jxlid);
				
				for (int j = 0; j < cs.size(); j++) {
					
						Classroom c = cs.get(j);
						System.out.println(c);
						iClassroom.add(c);
						
				}
				
				commit();
			
			
			}
		}finally{
			close();
		}
	}
	
//		
//
//	// 学院信息
//	public void xueyuan() {
//		
//		String url = "http://202.101.92.20:85/jwweb/JXSJ/FB_XQJXSJAP.aspx";
//		String htmlPage = SimulateHttpRequest.simulateGet(url, null); 	
//    	List<XueYuan> xys = DataUtil.getXYDataforSDWeb(htmlPage);	
//
//		
//		
//		XueYuanDaoImpl dao = new XueYuanDaoImpl();	// 向数据库中添加
//		for (int i = 0; i < xys.size(); i++) {
//			dao.addXueYuan(xys.get(i));
//		}
//		
//	}
//	
//	
//
//	// 老师
	@Test
	public void laoShi() {
		
		// 添加教师编号 姓名信息
		String url = "http://202.101.92.20:85/jwweb/ZNPK/Private/List_JS.aspx?xnxq=20140&js=";
		String htmlPage = SimulateHttpRequest.simulateGet(url, null); 	
		ArrayList<Teacher> lss = DataUtil.getLSDataforSDWeb(htmlPage);
		
		// 添加教师其它信息
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("Sel_XNXQ", "20140");		// 学年信息
		param.put("type", "2");				// 那种格式显示
		String url1 = "http://202.101.92.20:85/jwweb/ZNPK/TeacherKBFB_rpt.aspx";
		
		try{
			
			ITeacher iTeacher = getSqlSession().getMapper(ITeacher.class);
			for (int i = 0; i < lss.size(); i++) {
			
				Teacher ls = lss.get(i);
				param.put("Sel_JS", ls.getId());
				String htmlPage1 = SimulateHttpRequest.simulatePost(url1, param ,"http://202.101.92.20:85/jwweb/ZNPK/TeacherKBFB.aspx"); 
			//	System.out.println(htmlPage1);
				DataUtil.getLSDataforSDWeb(htmlPage1, ls);
				
				System.out.print(lss.size() - i + ": ");
				iTeacher.add(ls);		// 向数据库中添加老师信息
				System.out.println(ls);
			}
			commit();
			
		}finally {
			close();
		}
		
	}
//	
//	
//	// 课程
//	public void keCheng() {
//		
//		String url = "http://202.101.92.20:85/jwweb/ZNPK/Private/List_XNXQKC.aspx?xnxq=20140";
//		String htmlPage = SimulateHttpRequest.simulateGet(url, null); 		
//		ArrayList<KeCheng> kcs = DataUtil.getKCDataforSDWeb(htmlPage);	
//		
//		// 添加课程其它信息
//		/*
//		 * 
//		 * 	gs	2		
//			Sel_KC	000246		
//			Sel_XNXQ	20140		
//			Submit01			
//		 */
//		
//		HashMap<String, String> param = new HashMap<String, String>();
//		param.put("Sel_XNXQ", "20140");		// 学年信息
//		param.put("gs", "2");				// 那种格式显示
//		String url1 = "http://202.101.92.20:85/jwweb/ZNPK/KBFB_LessonSel_rpt.aspx";
//		
//		KeChengDao dao = new KeChengDaoImpl();
//		System.out.println(kcs.size());
//		for (int i = 0; i < kcs.size(); i++) {
//		
//			KeCheng kc = kcs.get(i);
//			param.put("Sel_KC", kc.getBianHao());
//			String htmlPage1 = SimulateHttpRequest.simulatePost(url1, param ,"http://202.101.92.20:85/jwweb/ZNPK/KBFB_LessonSel.aspx"); 
//		//	System.out.println(htmlPage1);
//			DataUtil.getKCDataforSDWeb(htmlPage1, kc); 
//			System.out.print(kcs.size()-i + ": " );
//			
//			dao.addKeCheng(kc);// 向数据库中添加老师信息
//		}
//	
//		
//	}
//	
	
	
	// 通过班级获得课表
	//http://202.101.92.20:85/jwweb/ZNPK/KBFB_ClassSel_rpt.aspx
	/**
	 *  chkrxkc	1		
		Sel_XNXQ	20140	
		Sel_XZBJ	2012070201	
		Submit01			
		txtxzbj			
		type	2		
	 */
	@Test
	public void timeTable() {
		
		
		// 所有班级id
		List<Class> cs = getSqlSession().getMapper(IClass.class).findAll();
		
		String url = "http://202.101.92.20:85/jwweb/ZNPK/KBFB_ClassSel_rpt.aspx";	//获得2014年所有班级 
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("chkrxkc", "1");
		param.put("Sel_XNXQ", "20140");
		param.put("type", "2");
		
		ITimeTable iTimeTable = getSqlSession().getMapper(ITimeTable.class);
		
		try{
			
			for (int i = 0; i < cs.size(); i++) {
				
				System.out.print(i-cs.size() + ":   ");
				
				String id = cs.get(i).getId();
				param.put("Sel_XZBJ", id);	//2011050401 
				String htmlPage = SimulateHttpRequest.simulatePost(url, param, "http://202.101.92.20:85/jwweb/ZNPK/KBFB_ClassSel.aspx");  
				List<TimeTable> timeTables = DataUtil.getDataTimeTableforSDWeb(htmlPage, id); 
				
				if(timeTables !=null){
					
					for (TimeTable timeTable : timeTables) {
						iTimeTable.add(timeTable);
						System.out.println("add: " + timeTable);
					}
				}
					
			}
			
			commit();
			
		}finally{
			close();
		}
    	
  		
	}



	
	
	// 班级
	// 班级 http://202.101.92.20:85/jwweb/ZNPK/Private/List_XZBJ.aspx?xnxq=20140
	// 	http://202.101.92.20:85/jwweb/ZNPK/KBFB_ClassSel_rpt.aspx
	/**
	 *  chkrxkc	1		
		Sel_XNXQ	20140	
		Sel_XZBJ	2012070201	
		Submit01			
		txtxzbj			
		type	2		
	 */
//	public void banJi() {
//		
//		String url = "http://202.101.92.20:85/jwweb/ZNPK/Private/List_XZBJ.aspx?xnxq=20140";	//获得2014年所有班级 
//		
//		String url1 = "http://202.101.92.20:85/jwweb/ZNPK/KBFB_ClassSel_rpt.aspx";
//		HashMap<String, String> param = new HashMap<String, String>();
//		param.put("chkrxkc", "1");
//		param.put("Sel_XNXQ", "20140");
//		param.put("type", "2");
//		
//		String htmlPage = SimulateHttpRequest.simulateGet(url, null);
//    	ArrayList<BanJi> bjs = DataUtil.getBJDataforSDWeb(htmlPage);
//    	
//    	BanJiDao dao = new BanJiDaoImpl();
//    	
//    	for (int i = 0; i < bjs.size(); i++) {
//			BanJi bj = bjs.get(i);
//			param.put("Sel_XZBJ", bj.getBianHao());
//			String htmlPage1 = SimulateHttpRequest.simulatePost(url1, param, "http://202.101.92.20:85/jwweb/ZNPK/KBFB_ClassSel.aspx"); 
//			DataUtil.getBJDataforSDWeb(htmlPage1, bj); 
//System.out.print(bjs.size() - i + ": ");
//			dao.addBanJi(bj);
//		}
//    	ConnectionUtil.close();		
//	}
	
//	
//	public void kaiKe() {
//		
//		String url = "http://202.101.92.20:85/Jwweb/ZNPK/KBFB_DayJCSel_rpt.aspx";	//获得班级课表信息
//		/*
//rad	3	
//Sel_JC	01		
//Sel_JS			
//Sel_KC			
//Sel_XNXQ	20140		
//Sel_XQ	3	
//Sel_XZBJ			
//Sel_ZC	01		
//selxqs	1		
//Submit01			
//		 */
//		
//		HashMap<String, String> param = new HashMap<String, String>();
//		param.put("rad", "3");
//		
//		param.put("Sel_XNXQ", "20140");
//		
//		
//		param.put("Sel_XQ", "3");
//		
//		int cout = 0;
//		
//		for (int i = 1; i <= 18; i++) {
//			param.put("Sel_ZC", i+"");
//			for (int j = 1; j <= 7; j++) {
//				param.put("selxqs", j+"");
//				for (int k = 1; k <= 10; k++) {
//					param.put("Sel_JC", k+"");
//	
//					String htmlPage = SimulateHttpRequest.simulatePost(url, param, "http://202.101.92.20:85/jwweb/ZNPK/KBFB_DayJCSel.aspx"); 
//					List<JiaoShou> jss = new ArrayList<JiaoShou>();
//			    	DataUtil.getKKforSDWeb(htmlPage, jss);
//			    	
//			    	JiaoShouDaoImpl daoImpl = new JiaoShouDaoImpl();	
//			    	
//			    	for (int m = 0; m < jss.size(); m++) {
//						
//			    		JiaoShou js = jss.get(m);
//			    		js.setBianHao(++cout);
//			    		js.setXueNianXueQi(param.get("Sel_XNXQ"));
//			    		js.setZhouCi(param.get("Sel_ZC"));
//			    		js.setXingQi(param.get("selxqs"));
//			    		js.setJiCi(param.get("Sel_JC"));
//			    		
//			    	//	daoImpl.addJiaoShou(js);
//			    		
//			    		System.out.print(i+"-"+j+"-"+k+"-"+m+"：");
//			    		System.out.println(js);
//			    		
//					}
//					
//					
//					
//				}
//			}
//			
//		}
//		
//		
//		
//    	
//    	
//    	//ConnectionUtil.close();		
//	}
//	
//	
//	// 上课时间
//	public void shangKeShiJian(){
//		ShangKeShiJianDao dao = new ShangKeShiJianDaoImpl();
//		ShangKeShiJian shangKeShiJian = new ShangKeShiJian();
//		
//		for (int i = 1; i <= 20; i++) {
//			shangKeShiJian.setZhouCi("第" + i + "周");
//			for (int j = 1; j <= 7; j++) {
//				shangKeShiJian.setXingQi("星期" + j);
//				for (int j2 = 1; j2 <= 10; j2++) {
//					shangKeShiJian.setJC_bianHao(j2 + "");
//					shangKeShiJian.setBianHao(i+"_"+j+"_"+j2);
//					dao.addShangKeShiJian(shangKeShiJian);
//				}
//			}
//			
//		}
//	
//		
//	}
//	
	public static void main(String[] args) {
//		
		Insert2DB insert2db = new Insert2DB();
//		
//		//教学楼
		insert2db.jiaoXueLou();
//		
//		
//		// 教室
//		//insert2db.jiaoShi();
//		
//		// 学院 数据库中该表也去除
//		//insert2db.xueyuan();
//		
//		// 老师
//		//insert2db.laoShi();
//		
//		//课程
//		//insert2db.keCheng();
//		
//		// 班级
//		//insert2db.banJi();
//
//		//上课时间
//		//insert2db.shangKeShiJian();
//		
//		//开课
//		insert2db.kaiKe();
//		
//		/*KeChengDaoImpl chengDaoImpl = new KeChengDaoImpl();
//		
//		KeCheng kc = chengDaoImpl.selectByMingCheng("[010005]古代汉语(一)");
//		System.out.println(kc);*/
//		
//		/*LaoShiDaoImpl impl = new LaoShiDaoImpl();
//		System.out.println(impl.selectByMingCheng1("王建设"));
//		*/
	}
//
//
//	
}
