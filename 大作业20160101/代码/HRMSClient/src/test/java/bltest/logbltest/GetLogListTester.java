package bltest.logbltest;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import businesslogic.logbl.LogManage;
import dataservice.logdataservice.LogDataService;
import dataservice.logdataservice.LogDataService_Stub;
import po.LogPO;
import vo.logVO.LogVO;
/**
 * getLogList方法的测试
 * @author yilu
 *
 */
public class GetLogListTester {
	LogManage logManage;
	LogDataService dataservice;
	ArrayList<LogPO> listPO;
	ArrayList<LogVO> listVO;
	ArrayList<LogVO> list1;
	ArrayList<LogVO> list2;
	ArrayList<LogVO> list3;
	ArrayList<LogVO> list4;
	LogVO logVO1;
	LogVO logVO2;
	
	public GetLogListTester(){
		logManage=new LogManage();
		try {
			dataservice=new LogDataService_Stub();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		list1=new ArrayList<LogVO>();
		list1.add(new LogVO("S00000001 Mon Nov 29 09:51:52 CDT 2016 修改个人账户信息"));
		list1.add(new LogVO("S00000001 Mon Nov 29 09:51:52 CDT 2016 修改个人账户信息"));
		list1.add(new LogVO("S00000001 Mon Nov 29 09:51:52 CDT 2016 修改个人账户信息"));
		
		list2=new ArrayList<LogVO>();
		list2.add(new LogVO("S00000001 Mon Nov 30 09:51:52 CDT 2016 修改个人账户信息"));
		list2.add(new LogVO("S00000001 Mon Nov 30 09:51:52 CDT 2016 修改个人账户信息"));
		
		
	}

	@Test
	public void test1() {
		// 得到2016年11月29日的日志
		listVO=logManage.getLog("2016","11","29");
		assertEquals(true,sameList(listVO,list1));
	}
	
	@Test
	public void test2() {
		// 得到2016年11月30日的日志
		listVO=logManage.getLog("2016","11","30");
		assertEquals(true,sameList(listVO,list2));
	}
	
	
	boolean sameList(ArrayList<LogVO> list1,ArrayList<LogVO> list2){
		if(list1.size()!=list2.size())
			return false;
		for(int i=0;i<list1.size();i++){
			if(!list1.get(i).getLogInfo().equals(list2.get(i).getLogInfo()))
				return false;
		}
		return true;
	}

}
