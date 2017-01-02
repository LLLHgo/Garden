package dataservice.logdataservice;

import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;

import po.LogPO;
/**
 * 日志模块的客户端数据接口的驱动
 * @author yilu
 *
 */
public class LogDataService_Driver {
	public void driver(LogDataService logDataService)throws RemoteException{
		LogPO logPO = null;
		List<LogPO> logPOList = null; 
		Iterator<LogPO> it;
		boolean result;

		// 得到日志列表
		System.out.println("得到日志列表");
		logPOList=logDataService.getLogList();
		System.out.println("显示结果：");
		it=logPOList.iterator();
		/*while (it.hasNext()){
			System.out.println(it.next());
		}*/
		System.out.println("这里从数据库中得到的日志列表");
		
		// 得到添加日志成功或失败信息
		System.out.println("界面得到添加日志成功或失败信息");
		result=logDataService.addLog(logPO);
		if(result==false){
			System.out.println("添加日志失败");
		}
		else
			System.out.println("添加日志成功");
		
		
	}

}
