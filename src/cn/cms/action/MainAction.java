package cn.cms.action;

import cn.cms.mode.WeekCourse;
import cn.cms.service.TimeTableService;
import cn.cms.service.impl.TimeTableServiceImpl;

@SuppressWarnings("serial")
public class MainAction extends BaseAction {
	
	private WeekCourse wc;
	
	
	@Override
	public String execute() throws Exception {
		TimeTableService timeTableService = new TimeTableServiceImpl();
		String user = "";
		wc = timeTableService.findWeekCourse(user);
		
		
		
		return super.execute();
	}

}
