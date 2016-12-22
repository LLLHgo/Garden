package businesslogicservice.logblservice;

import java.util.ArrayList;

import Enum.ResultMessage;
import businesslogicservice.logblservice.LogBLService;
import vo.logVO.LogVO;

public class LogBLService_Stub implements LogBLService {
	String logInfo;
	ArrayList<LogVO> logs;
	
	public LogBLService_Stub(String logInfo){
		this.logInfo=logInfo;
	}
	public LogBLService_Stub(){
		logs=new ArrayList<LogVO>();
	}
	/**
	 * 界面得到日志列表
	 * @return 日志列表
	 */
	@Override
	public ArrayList<LogVO> getLog(String year,String month,String day) {
		// TODO Auto-generated method stub
		ArrayList<LogVO> logList1=new ArrayList<LogVO>();
		ArrayList<LogVO> logList2=new ArrayList<LogVO>();
		if(day.equals("29")){
			logList1.add(new LogVO("C00000001 Mon May 29 09:51:52 CDT 2016 登录"));
			logList1.add(new LogVO("C00000002 Mon May 29 09:51:56 CDT 2016 登录"));
			return logList1;
		}
		if(day.equals("30")){
			logList2.add(new LogVO("C00000003 Tues May 30 09:52:01 CDT 2016 登录"));
			return logList2;
		}
		
		return logList1;
	}
	/**
	 * 界面得到添加日志成功或失败信息
	 * @param logInfo
	 * @return 添加日志成功或失败的enum值
	 */
	@Override
	public ResultMessage addLog(String logInfo) {
		// TODO Auto-generated method stub
		logs.add(new LogVO(logInfo));
		return ResultMessage.SUCCESS; 
	}

}
