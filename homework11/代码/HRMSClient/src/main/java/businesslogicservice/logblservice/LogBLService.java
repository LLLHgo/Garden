package businesslogicservice.logblservice;

import java.util.ArrayList;

import Enum.ResultMessage;
import vo.logVO.LogVO;

public interface LogBLService {
	/**
	 * 界面得到日志列表
	 * @return 日志列表
	 */
	public ArrayList<LogVO> getLog(String year,String month,String day);
	/**
	 * 界面得到添加日志成功或失败信息
	 * @param logInfo
	 * @return 添加日志成功或失败的enum值
	 */
	public ResultMessage addLog (String logInfo);

}
