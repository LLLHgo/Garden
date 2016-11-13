package businesslogicservice.logblservice;

import java.util.List;

import Enum.ResultMessage;
import vo.logVO.LogVO;

public interface LogBLService {
	/**
	 * 界面得到日志列表
	 * @return 日志列表
	 */
	public List<LogVO> getLog();
	/**
	 * 界面得到添加日志成功或失败信息
	 * @param logInfo
	 * @return 添加日志成功或失败的enum值
	 */
	public ResultMessage addLog (String logInfo);

}
