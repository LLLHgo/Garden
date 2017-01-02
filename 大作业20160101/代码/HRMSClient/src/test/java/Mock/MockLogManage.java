package Mock;

import java.util.ArrayList;

import Enum.ResultMessage;
import datatool.LogDataTool;
import vo.logVO.LogVO;
/**
 * log的mock
 * @author yilu
 *
 */
public class MockLogManage {
	
	LogVO logVO=new LogVO();
	ResultMessage result;
	
	public MockLogManage(){
		
	}
	
    LogDataTool logDataTool=new LogDataTool();
	
	/**
	 * 界面得到日志列表
	 * @return 日志列表
	 */
	public ArrayList<LogVO> getLog(){
		return LogDataTool.logList;
	}
	/**
	 * 界面得到添加日志成功或失败信息
	 * @param logInfo
	 * @return 添加日志成功或失败的enum值
	 */
	public ResultMessage addLog (String logInfo){
		return ResultMessage.SUCCESS; 
	}
}
