package datatool;

import java.util.ArrayList;

import vo.logVO.LogVO;
/**
 * 日志数据工具
 * @author yilu
 *
 */
public class LogDataTool {
     //List<LogPO> getLogList():logList

	static LogVO logVO1=new LogVO("2016-08-10 09:21:22 H00000010 修改密码");
	static LogVO logVO2=new LogVO("2016-08-10 09:20:11 C00000002 下订单20160810092001");
	
	public static ArrayList<LogVO> logList=new ArrayList<LogVO>();
	static{
		logList.add(logVO1);
		logList.add(logVO2);
	}		
	
}
