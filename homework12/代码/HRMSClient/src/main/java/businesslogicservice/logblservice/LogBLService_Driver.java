package businesslogicservice.logblservice;

import java.util.Iterator;
import java.util.List;

import Enum.ResultMessage;
import vo.logVO.LogVO;

public class LogBLService_Driver {
	public void drive(LogBLService logBLService){
		List<LogVO> logVOList; 
		Iterator<LogVO> it;
	    ResultMessage result;
	
		//界面得到日志列表
		System.out.println("界面得到日志列表");
		logVOList =logBLService.getLog("2016","11","29");
		System.out.println("显示结果：");
		it=logVOList.iterator();
		/*while (it.hasNext()){
			System.out.println(it.next());
		}*/
		System.out.println("这里是日志列表");
		
		// 界面得到添加日志成功或失败信息
		System.out.println("界面得到添加日志成功或失败信息");
		result=logBLService.addLog("C00000002 2016-10-15 10:56:23 下订单2016101510562308");
		if(result==ResultMessage.FAIL){
			System.out.println("添加日志失败");
		}
		else
			System.out.println("添加日志成功");
		
		
	}
}
