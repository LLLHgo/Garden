package businesslogic.logbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Enum.ResultMessage;
import businesslogicservice.logblservice.LogBLService;
import dataservice.logdataservice.LogDataService;
import dataservice.logdataservice.LogDataService_Stub;
import po.LogPO;
import vo.logVO.LogVO;

public class LogManage implements LogBLService{
	
	LogDataService dateService;
	LogPO logPO;
	boolean dateBaseSave;
	ArrayList<LogVO> listVO;
	ArrayList<LogPO> listPO;
	
	public LogManage(){
		try {
			dateService=new LogDataService_Stub();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		listVO=new ArrayList<LogVO>();
	}
	/**
	 * 界面得到添加日志成功或失败信息
	 * @param logInfo
	 * @return 添加日志成功或失败的enum值
	 */
	public ResultMessage addLog (String logInfo){
		// array数组中放logInfo以空格分开的字符串
		String[] array=logInfo.split(" ");
		// logInfo为空
		if(voidInfo(logInfo))
			return ResultMessage.VOIDINFO;
		// 没有7个分隔的字符串
		else if(!partsLengthCorrect(array))
			return ResultMessage.WRONGFORMAT;
		// 第一个小字符串是否是帐号
		else if(!firstStringLength(array[0]))
			return ResultMessage.WRONGFORMAT;
		else{
			logPO=new LogPO(logInfo);
			// 将日志持久化保存
			try {
				dateBaseSave=dateService.addLog(logPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if (dateBaseSave==true)
				return ResultMessage.SUCCESS;
			else
				return ResultMessage.DATEBASEFAIL;
		}
	}
	boolean voidInfo(String logInfo){
		return logInfo.equals("")||logInfo==null;
	}
	// 判断loginfo中是否有8个分隔的字符串
	boolean partsLengthCorrect(String[]arr){
		return arr.length==8;
	}
	// 判断第一个小字符串中是否是帐号
	boolean firstStringLength(String str){
		boolean result=true;
		char c=str.charAt(0);
		if(str.length()!=9)
			return false;
		// 第一位是否为合法编码（H M S C中的一个）
		if(!(c=='H'||c=='M'||c=='S'||c=='C'))
			return false;
		for(int i=1;i<str.length();i++){
			// 2-8位是否为数字
			if(str.charAt(i)-'0'<0||str.charAt(i)-'0'>9){
				result=false;
				break;
			}
		}
		return result;
		
	}
	/**
	 * 界面得到某天的日志列表
	 * @return 日志列表
	 */
	@Override
	public ArrayList<LogVO> getLog(String year, String month, String day) {
		// 从data层得到日志列表
		try {
			listPO=dateService.getLogList();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		// arr数组中放logPO内logInfo以空格分开的字符串
		String[] arr;
		for(int i=0;i<listPO.size();i++){
			logPO=listPO.get(i);
			arr=logPO.getLogInfo().split(" ");
			if(yearMatch(arr[6],year)&&monthMatch(arr[2],month)&&dayMatch(arr[3],day)){
				listVO.add(new LogVO(logPO.getLogInfo()));
			}
		}
		return listVO;
	}
	// 年份相符
	boolean yearMatch(String arrYear,String year){
		return arrYear.equals(year);
	}
	// 月份相符
	boolean monthMatch(String arrMonth,String month){
		String[] monthArr={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sept","Oct","Nov","Dec"};
		if(arrMonth.equals(monthArr[Integer.parseInt(month)-1]))
			return true;
		else
			return false;
	}
	// 天 相符
	boolean dayMatch(String arrDay,String day){
		return arrDay.equals(day);
	}

}
// S00000001 Mon May 04 09:51:52 CDT 2009 修改个人账户信息
// log保存在txt文件中