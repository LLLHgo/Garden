package businesslogicservice.logblservice;

import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import businesslogicservice.logblservice.LogBLService;
import vo.logVO.LogVO;

public class LogBLService_Stub implements LogBLService {
	String logInfo;
	
	public LogBLService_Stub(String logInfo){
		this.logInfo=logInfo;
	}
	/**
	 * 界面得到日志列表
	 * @return 日志列表
	 */
	@Override
	public List<LogVO> getLog() {
		// TODO Auto-generated method stub
		List<LogVO> logList=new ArrayList<LogVO>();
		logList.add(new LogVO("C00000001 2016-10-15  00:25:25 登录"));
		return logList;
	}
	/**
	 * 界面得到添加日志成功或失败信息
	 * @param logInfo
	 * @return 添加日志成功或失败的enum值
	 */
	@Override
	public ResultMessage addLog(String logInfo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
