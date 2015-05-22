package cn.cms.util;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.StringFilter;
import org.htmlparser.tags.OptionTag;
import org.htmlparser.tags.TableColumn;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import sun.net.www.content.audio.x_aiff;

import cn.cms.mode.Classroom;
import cn.cms.mode.TeachBuild;
import cn.cms.mode.Teacher;
import cn.cms.mode.TimeTable;


// 数据处理
public class DataUtil {
	
	/**
	 * 教学楼
	 * @param htmlPage
	 * @throws ParserException
	 */
	public static ArrayList<TeachBuild> getJXLDataforSDWeb(String htmlPage) {
		
		ArrayList<TeachBuild> jxls = new ArrayList<TeachBuild>();
		
		Parser parser;
		try {
			parser = new Parser(htmlPage);
		
			NodeFilter filter = new NodeClassFilter(OptionTag.class);
			NodeList nodes = parser.parse(filter);
		
			for (int i = 0; i < nodes.size(); i++) {
			
				OptionTag tag = (OptionTag) nodes.elementAt(i);
				
				String bianhao = tag.getAttribute("value").trim();
				Character XQ_BianHao = bianhao.charAt(0);			//教学楼第一个字符代表校区
				
				TeachBuild teachBuild = new TeachBuild();
				teachBuild.setId(bianhao);
				teachBuild.setName(tag.toPlainTextString().trim());
				teachBuild.setCampusId(XQ_BianHao.toString());
				
				jxls.add(teachBuild);
			
		}
			
		} catch (ParserException e) {
			System.out.println(e.getMessage());
		}
		return jxls;
	}
	
	
	/**
	 * 
	 * @param htmlPage
	 * @param jxl		教室
	 * @throws ParserException
	 */
	public static ArrayList<Classroom> getJSDataforSDWeb(String htmlPage, String jxlid) {
				
		ArrayList<Classroom> jss = new ArrayList<Classroom>();
		System.out.println(htmlPage);
		
		Parser parser;
		try {
			parser = new Parser(htmlPage);
		
		
		NodeFilter filter = new NodeClassFilter(OptionTag.class);
		NodeList nodes = parser.parse(filter);
		
		for (int i = 0; i < nodes.size(); i++) {
			
			OptionTag tag = (OptionTag) nodes.elementAt(i);
		//	jss.add(new JiaoShi(tag.getAttribute("value").trim(), tag.toPlainTextString().trim(), 80, bianHao));

			Classroom jiaoShi = new Classroom();
			jiaoShi.setId(tag.getAttribute("value").trim());
			jiaoShi.setName(tag.toPlainTextString().trim());
			jiaoShi.setTeachBuildId(jxlid);
			jiaoShi.setSeating(0);
			jss.add(jiaoShi);
			
		}
		
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return jss;
	}
///	
	
	
	/**
	 * 教师编号，姓名信息
	 * @param htmlPage
	 * @throws ParserException
	 */
	public static ArrayList<Teacher> getLSDataforSDWeb(String htmlPage) {

		ArrayList<Teacher> lss = new ArrayList<Teacher>();
		
		Parser parser;
		try {
			parser = new Parser(htmlPage);
		
		
		NodeFilter filter = new NodeClassFilter(OptionTag.class);
		NodeList nodes = parser.parse(filter);
		
		for (int i = 0; i < nodes.size(); i++) {
			
			OptionTag tag = (OptionTag) nodes.elementAt(i);
			
			//lss.add(new LaoShi(tag.getAttribute("value"), tag.toPlainTextString(), "", "", ""));
			//t = tag.getAttribute("value") + tag.toPlainTextString();	
			Teacher laoShi = new Teacher();;
			laoShi.setId(tag.getAttribute("value"));
			laoShi.setName(tag.toPlainTextString());
			
			lss.add(laoShi);
			
		}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		
		return lss;
	}

	
	/**
	 * 教师其它信息
	 * @param htmlPage
	 * @throws ParserException
	 */
	public static void getLSDataforSDWeb(String htmlPage, Teacher ls) {
					
//String t = ls.getXingMing();
		Parser parser;
		try {
			parser = new Parser(htmlPage);
		NodeFilter filter = new StringFilter("部门");
		NodeList nodes = parser.extractAllNodesThatMatch(filter);
		
		for (int i = 0; i < nodes.size(); i++) {
			
			String str = nodes.elementAt(i).getText().replaceAll("&nbsp;&nbsp;", "：") + "： ";
			String[] s = str.split("：");
			ls.setDepartment(s[1]);
			ls.setAge(0);
			ls.setSex(s[5]);
			ls.setTeacherTitle(s[7]);
			
		}
		} catch (ParserException e) {
			e.printStackTrace();
		} 
	}


	public static List<TimeTable> getDataTimeTableforSDWeb(String htmlPage, String classId) {
		// TODO Auto-generated method stub
		
		htmlPage = tagPolishing(htmlPage, "</tr>");
		
		List<TimeTable> tts = new ArrayList<TimeTable>();
		Parser parser;
		try {
			parser = new Parser(htmlPage);
			NodeFilter filter = new NodeClassFilter(TableTag.class);
			NodeList nodes = parser.extractAllNodesThatMatch(filter);
			
			if(nodes.size()<4){
				return null;
			}
			
			TableTag tt = (TableTag) nodes.elementAt(3);
			TableRow[] trs = tt.getRows();
			
			TimeTable timeTablerBak = new TimeTable();
			
			for (int i = 1; i < trs.length-1; i++) {
				TableColumn[] tcs = trs[i].getColumns();
				
				TimeTable timeTable = new TimeTable();
				timeTable.setClassId(classId);
				
				String teacherId = tcs[4].getStringText().replaceAll("<br>", "").trim();
				teacherId = teacherId.equals("") ? timeTablerBak.getTeacherId() : teacherId;
				timeTable.setTeacherId(teacherId);
				
				String courseId = tcs[0].getStringText().replaceAll("<br>", "").trim();
				courseId = courseId.equals("") ? timeTablerBak.getCourseId() : courseId;
				timeTable.setCourseId(courseId);
				
				float credit;
				try{
					credit = Float.parseFloat( tcs[1].getStringText().replaceAll("<br>", "").trim());
				}catch (Exception e) {
					credit = timeTablerBak.getCredit();
				}
				timeTable.setCredit(credit);
				
				int period = 0;
				try{
					period = (int) Float.parseFloat( tcs[2].getStringText().replaceAll("<br>", "").trim());
				}catch (Exception e) {
					period = timeTablerBak.getPeriod();
				}
				timeTable.setPeriod(period);
				
				String examination = tcs[3].getStringText().replaceAll("<br>", "").trim();
				examination = examination.equals("") ? timeTablerBak.getExamination() : examination;
				timeTable.setExamination(examination);
				
			
				int studentCount ;
				try{
					studentCount = Integer.parseInt( tcs[6].getStringText().replaceAll("<br>", "").trim());
				}catch (Exception e) {
					studentCount = timeTablerBak.getStudentCount();
				}
				timeTable.setStudentCount(studentCount);
				
				
				String week = tcs[7].getStringText().replaceAll("<br>", "").trim();
				week = week.equals("") ? timeTablerBak.getWeek() : week;
				timeTable.setWeek(week);
				
				
				String section = tcs[8].getStringText().replaceAll("<br>", "").trim();
				section = section.equals("") ? timeTablerBak.getSection() : section;
				timeTable.setSection(section);
				
				
				String locale = tcs[9].getStringText().replaceAll("<br>", "").trim();
				locale = locale.equals("") ? timeTablerBak.getLocale() : locale;
				timeTable.setLocale(locale);
				
				tts.add(timeTable);
				timeTablerBak = timeTable;
			}
			
			
		} catch (ParserException e) {
				e.printStackTrace();
				
		}
		
		return tts; 
	}

	
//	/**
//	 * 	课程
//	 * @param htmlPage	
//	 * @throws ParserException
//	 */
//	public static ArrayList<KeCheng> getKCDataforSDWeb(String htmlPage) {
//				
//		ArrayList<KeCheng> kcs = new ArrayList<KeCheng>();
//		
//		
//		
//		Parser parser;
//		try {
//			parser = new Parser(htmlPage);
//		
//		
//		NodeFilter filter = new NodeClassFilter(OptionTag.class);
//		NodeList nodes = parser.parse(filter);
//		
//		for (int i = 0; i < nodes.size(); i++) {
//			
//			OptionTag tag = (OptionTag) nodes.elementAt(i);
//			//kcs.add(new KeCheng(tag.getAttribute("value").trim(), tag.toPlainTextString().trim()));
//			KeCheng keCheng = new KeCheng();
//			keCheng.setBianHao(tag.getAttribute("value").trim());
//			
//			String mingCheng = tag.toPlainTextString().trim();
//			
//			mingCheng = '[' + mingCheng;
//			mingCheng = mingCheng.replace('|', ']');
//			
//			keCheng.setMingCheng(mingCheng);
//			
//			kcs.add(keCheng);
//			
//		}
//		
//		} catch (ParserException e) {
//			System.out.println(e.getMessage());
//		}
//		return kcs;
//	}
//	
//	// 添加课程其它信息
//	public static void getKCDataforSDWeb(String htmlPage1, KeCheng kc) {
//		
//		try {
//			
//			Parser parser = new Parser(htmlPage1);				
//			NodeFilter filter = new StringFilter("承担单位：");
//			NodeList nodes = parser.extractAllNodesThatMatch(filter);
//	
//			String str = nodes.elementAt(0).getText().replaceAll("&nbsp;&nbsp;", "：") + "： ";
//			String[] s = str.split("：");
//			kc.setXueFen(Float.parseFloat(s[7]));
//			kc.setXueShi((int)Float.parseFloat(s[5]));
//		
//			
//		} catch (ParserException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}						
//		
//	}
//	
//	
//	
//	
//	// 班级  	处理  过滤 班级编号 名称
//	public static ArrayList<BanJi> getBJDataforSDWeb(String htmlPage) {
//		
//		ArrayList<BanJi> bjs = new ArrayList<BanJi>();
//		
//		try {
//			
//			Parser parser = new Parser(htmlPage);
//			NodeFilter filter = new NodeClassFilter(OptionTag.class);		// htmlPage 处理  过滤 班级编号 名称
//			NodeList nodes = parser.parse(filter);
//		
//			for (int i = 0; i < nodes.size(); i++) {
//				
//				OptionTag tag = (OptionTag) nodes.elementAt(i);
//				BanJi bj = new BanJi();
//				bj.setBianHao(tag.getAttribute("value").trim());
//				bj.setMingCheng(tag.toPlainTextString().trim());
//	
//				bjs.add(bj);
//		}
//		
//		} catch (ParserException e) {
//			System.out.println(e.getMessage());
//		}
//		return bjs;
//	}
//	
//	
//	// htmlPage1处理	过滤班级 专业 年级
//	public static void getBJDataforSDWeb(String htmlPage, BanJi bj) {
//		
//		try {
//			
//			Parser parser = new Parser(htmlPage);				
//			NodeFilter filter = new StringFilter("年级：");
//			NodeList nodes = parser.extractAllNodesThatMatch(filter);
//	
//			String str = nodes.elementAt(0).getText().replaceAll("&nbsp;&nbsp;", "：") + "： ";
//			String[] s = str.split("：");
//			bj.setNianJi(s[1]);
//			bj.setZhuanYe(s[3]);
//			bj.setRenShu(0);
//	
//		} catch (ParserException e) {
//			System.out.println(e.getMessage());
//		}						
//	}
//
//	
//	// htmlPage1处理	开课
//	public static void getKKforSDWeb(String htmlPage, List<JiaoShou> jss) {
//		
//		try {
//			
////System.out.println(htmlPage);
//			htmlPage = tagPolishing(htmlPage,"</tr>");
//			Parser parser = new Parser(htmlPage);				
//			NodeFilter filter = new NodeClassFilter(TableTag.class);
//			NodeList nodes = parser.extractAllNodesThatMatch(filter);
//			
//			//System.out.println("\n\n"+htmlPage);
//			
//			//System.out.println(nodes.size());
//			//for (int i = 0; i < nodes.size(); i++) {
//			TableTag tt = (TableTag) nodes.elementAt(1);
//				
//		//	System.out.println(tt.getStringText());
//			
//			TableRow[] trs = tt.getRows();
//			for (int i = 1; i < trs.length - 1; i++) {
//				
//				JiaoShou js = new JiaoShou();
//				
//				TableColumn[] tcs = trs[i].getColumns();
////System.out.println(i);
//				
//				js.setKeCheng(tcs[1].getStringText().replaceAll("<br>", "").trim());
//				js.setLaoShi(tcs[4].getStringText().replaceAll("<br>", "").trim());
//				js.setDiDian(tcs[6].getStringText().replaceAll("<br>", "").trim());
//				js.setBanJi(tcs[7].getStringText().replaceAll("<br>", " ").trim());
//				
//				String ds = tcs[5].getStringText().replaceAll("<br>", "").trim();
//				
//				if(ds.endsWith("单")) 
//					ds = "单";
//				else if(ds.endsWith("双")) 
//					ds = "双";
//				else
//					ds = "";
//				js.setDanShuang(ds);
//				
//				
//				int renshu = 0;
//				try{
//					renshu = Integer.parseInt(tcs[3].getStringText().replaceAll("<br>", "").trim());
//				}catch (Exception e) {
//					renshu = 0;
//				}
//				js.setRenShu(renshu);
//				
//				jss.add(js);
//			
//				//System.out.println(kk);
//				//System.out.println();
//			}
//			
//			//System.out.println(tt.getStringText());
//				
//				
//				
//				/*TableRow[] tr = tt.getRows();
//				for (int j = 0; j < tr.length - 1; j++) {
//					TableColumn[] tc = tr[j].getColumns();
//					//System.out.print(+">> ");
//					
//					for (int k = 0; k < tc.length; k++) {
//						System.out.print(tc.length+"  ");
//						System.out.print(tc[k].getStringText()+"\t | \t");
//					}
//					System.out.println();
//					
//				}
//				System.out.println("###############################################");
//				*/
//		//	}
//			
//			
//	
//		} catch (ParserException e) {
//			e.printStackTrace();
//		}						
//	}
//	
// 
//	
//	
	public static String tagPolishing(String htmlPage, String tag) {
		
		StringBuffer sb = new StringBuffer();
		String[] strs = htmlPage.split(tag);
		
		for (int i = 0; i < strs.length; i++) {
			
			String s = strs[i];
		
			if(s.startsWith("<tr>"))
				s += "</tr>";
			else
				s  = "<tr>" + s + "</tr>";
			
			
			if(!(strs[i].equals("") || strs[i] == null))
				sb.append("<tr>"+strs[i]+"</tr>");
		}
		
		return sb.toString();
	}
//
//
//	public static List<XueYuan> getXYDataforSDWeb(String htmlPage) {
//		
//		ArrayList<XueYuan> xys = new ArrayList<XueYuan>();
//		
//		Parser parser;
//		try {
//			parser = new Parser(htmlPage);
//		
//		
//		NodeFilter filter = new NodeClassFilter(OptionTag.class);
//		NodeList nodes = parser.parse(filter);
//		
//		for (int i = 0; i < nodes.size(); i++) {
//			
//			OptionTag tag = (OptionTag) nodes.elementAt(i);
//			System.out.println(tag.getAttribute("value").trim() + "--" + tag.toPlainTextString().trim());
//			XueYuan xueYuan = new XueYuan();
//			xueYuan.setBianHao(tag.getAttribute("value").trim());
//			xueYuan.setMingCheng(tag.toPlainTextString().trim());
//			xueYuan.setXX_bianHao("10663");
//			if(!( (xueYuan.getBianHao().equals("")||xueYuan.getBianHao() == null) 
//					&&(xueYuan.getBianHao().equals("")||xueYuan.getMingCheng()==null)))
//				xys.add(xueYuan);
//			
//		}
//		
//		} catch (ParserException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		return xys;
//	}
//
//
//	
//	
//	
//	
//	
	
	
}
