package dataservice.logdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.LogPO;
/**
 * 日志的数据层接口的桩
 * @author yilu
 *
 */
public class LogDataService_Stub implements LogDataService {
	LogPO logPO;
	ArrayList<LogPO> logPOList;
	
	public LogDataService_Stub(LogPO logPO,List<LogPO> logPOList)throws RemoteException{
		this.logPO=logPO;
		this.logPOList=(ArrayList<LogPO>) logPOList;
	}
	
	/**
	 * 从数据库中得到所有日志
	 * @return 日志PO
	 */
	public ArrayList<LogPO> getLogList()throws RemoteException{
		return logPOList;
	}
	public boolean addLog (LogPO logPo){
		return true;
	}
}
