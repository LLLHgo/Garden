package dataservice.logdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogPO;

public class LogDataService_Stub implements LogDataService {
	LogPO logPO;
	ArrayList<LogPO> logPOList;
	
	public LogDataService_Stub(LogPO logPO,ArrayList<LogPO> logPOList)throws RemoteException{
		this.logPO=logPO;
		this.logPOList=logPOList;
	}
	public LogDataService_Stub()throws RemoteException{
		logPOList=new ArrayList<LogPO>();
		logPOList.add(new LogPO("S00000001 Mon Nov 29 09:51:52 CDT 2016 修改个人账户信息"));
		logPOList.add(new LogPO("S00000001 Mon Nov 29 09:51:52 CDT 2016 修改个人账户信息"));
		logPOList.add(new LogPO("S00000001 Mon Nov 29 09:51:52 CDT 2016 修改个人账户信息"));
		logPOList.add(new LogPO("S00000001 Mon Nov 30 09:51:52 CDT 2016 修改个人账户信息"));
		logPOList.add(new LogPO("S00000001 Mon Nov 30 09:51:52 CDT 2016 修改个人账户信息"));
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
