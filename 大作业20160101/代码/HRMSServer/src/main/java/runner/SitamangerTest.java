package runner;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Enum.OrderType;
import Enum.VIPType;
import impl.mysql.LogDataServiceMySqlImpl;
import impl.mysql.OrderDataServiceMySqlImpl;
import impl.mysql.SitemanagerDataServiceMySqlImpl;
import impl.txt.LogDataServiceTxtImpl;
import po.LogPO;
import po.OrderPO;
import po.SitemanagerPO;
/**
 * sitemanager数据层的test
 * @author yilu
 *
 */
public class SitamangerTest {
	// SitemanagerDataServiceMySqlImpl  getAccount
		void test1(){
			SitemanagerDataServiceMySqlImpl si;
			SitemanagerPO sitemanagerPO = null;
			try {
				si = new SitemanagerDataServiceMySqlImpl();
				sitemanagerPO=si.getAccount();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			System.out.println(sitemanagerPO.getPassword());
			
		}
		// SitemanagerDataServiceMySqlImpl SitemanagerAccountUpdate
		void test2(){
			SitemanagerDataServiceMySqlImpl si;
			boolean result=false;
			SitemanagerPO sitemanagerPO = new SitemanagerPO("S00000001","025-88888825","HRMSSitemanager");
			try {
				si = new SitemanagerDataServiceMySqlImpl();
				result=si.SitemanagerAccountUpdate(sitemanagerPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			System.out.println(result);
		}
		// LogDataServiceTxtImpl getLogList
		void test3(){
			LogDataServiceTxtImpl li;
			ArrayList<LogPO> list=new ArrayList<LogPO>();
			try {
				li=new LogDataServiceTxtImpl();
				list=li.getLogList();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			System.out.println(list.get(0).getLogInfo());
		}
		// LogDataServiceTxtImpl addLog
		void test4(){
			LogDataServiceTxtImpl li;
			LogPO logPO=new LogPO("M00000010 Mon Dec 07 23:23:32 CDT 2016 修改C00000015信用值");
			boolean result=false;
			try {
				li=new LogDataServiceTxtImpl();
				result=li.addLog(logPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}	
			System.out.println(result);
		}
		// OrderDataServiceMySqlImpl add
		void test5(){
			OrderDataServiceMySqlImpl o;
			ArrayList<String>strategies=new ArrayList<String>();
			strategies.add("双十一特惠");
			strategies.add("生日");
			strategies.add("会员特惠");
			OrderPO po=new OrderPO("000000003","C00000001","小螺丝","16679876372",VIPType.ORDINARYVIP,"2016-12-01 12:23:28",
					OrderType.ABNORMAL,"冠军楼酒店","H00000010",340.28,strategies,"大床房",1,1,"2016-12-02 12:00:00",
					"","2016-12-03 12:00:00",400.00,false);
			boolean result=false;
			try {
				o=new OrderDataServiceMySqlImpl();
				result=o.add(po);
			} catch (RemoteException e) {
				e.printStackTrace();
			}	
			System.out.println(result);
		}
		
		// OrderDataServiceMySqlImpl lookIdValid
		void test6(){
			OrderDataServiceMySqlImpl o;
			int num=0;
			try {
				o=new OrderDataServiceMySqlImpl();
				num=o.lookIdValid();
			} catch (RemoteException e) {
				e.printStackTrace();
			}	
			System.out.println(num);
		}
		// OrderDataServiceMySqlImpl save
		void test7(){
			OrderDataServiceMySqlImpl o;
			boolean result=false;
			ArrayList<String>strategies=new ArrayList<String>();
			strategies.add("双十一特惠");
			strategies.add("生日");
			strategies.add("会员特惠");
			OrderPO po=new OrderPO("000000003","C00000001","小螺丝","16679876372",VIPType.ORDINARYVIP,"2016-12-01 12:23:28",
					OrderType.NORMALNONEXEC,"冠军楼酒店","H00000010",340.28,strategies,"豪华套房",1,1,"2016-12-02 12:00:00",
					"","2016-12-03 12:00:00",400.00,false);
			try {
				o=new OrderDataServiceMySqlImpl();
				result=o.save(po);
			} catch (RemoteException e) {
				e.printStackTrace();
			}	
			System.out.println(result);
		}
		
		// OrderDataServiceMySqlImpl cancel
		void test8(){
			OrderDataServiceMySqlImpl o;
			boolean result=false;
			try {
				o=new OrderDataServiceMySqlImpl();
				result=o.cancel("000000002");
			} catch (RemoteException e) {
				e.printStackTrace();
			}		
			System.out.println(result);
		}
		//  OrderDataServiceMySqlImpl findSpecificUserOrder
		void test9(){
			OrderDataServiceMySqlImpl o;
			OrderPO orderPO=new OrderPO();
			try {
				o=new OrderDataServiceMySqlImpl();
				orderPO=o.findSpecificUserOrder("000000002");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(orderPO!=null){
				System.out.println(orderPO.getHotelName()+" ");
			}
		}
		// OrderDataServiceMySqlImpl findSpecificDayClientOrderList
		void test10(){
			OrderDataServiceMySqlImpl o;
			ArrayList<OrderPO> orderPOList=new ArrayList<OrderPO>();
			try {
				o=new OrderDataServiceMySqlImpl();
				orderPOList=o.findSpecificDayClientOrderList("C00000001", "2016-12-02 12:00:00");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(orderPOList.size()!=0){
				for(int i=0;i<orderPOList.size();i++)
					System.out.println(orderPOList.get(i).getHotelName()+" ");
			}
		}
		// OrderDataServiceMySqlImpl findUserOrderList
		void test11(){
			OrderDataServiceMySqlImpl o;
			ArrayList<OrderPO> orderPOList=new ArrayList<OrderPO>();
			try {
				o=new OrderDataServiceMySqlImpl();
				orderPOList=o.findUserOrderList("M00000001");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(orderPOList.size()!=0){
				for(int i=0;i<orderPOList.size();i++)
					System.out.println(orderPOList.get(i).getClientName()+" ");
			}
		}
		// OrderDataServiceMySqlImpl findClientTypeOrderList
		void test12(){
			OrderDataServiceMySqlImpl o;
			ArrayList<OrderPO> orderPOList=new ArrayList<OrderPO>();
			try {
				o=new OrderDataServiceMySqlImpl();
				orderPOList=o.findClientTypeOrderList(OrderType.ABNORMAL, "C00000003");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(orderPOList.size()!=0){
				for(int i=0;i<orderPOList.size();i++)
					System.out.println(orderPOList.get(i).getHotelName()+" ");
			}
		}
		
		// OrderDataServiceMySqlImpl findHotelTypeOrderList
		void test13(){
			OrderDataServiceMySqlImpl o;
			ArrayList<OrderPO> orderPOList=new ArrayList<OrderPO>();
			try {
				o=new OrderDataServiceMySqlImpl();
				orderPOList=o.findHotelTypeOrderList(OrderType.CANCEL, "H00000001");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(orderPOList.size()!=0){
				for(int i=0;i<orderPOList.size();i++)
					System.out.println(orderPOList.get(i).getClientName()+" ");
			}
		}
		// OrderDataServiceMySqlImpl findClientInHotelAllOrderList
		void test14(){
			OrderDataServiceMySqlImpl o;
			ArrayList<OrderPO> orderPOList=new ArrayList<OrderPO>();
			try {
				o=new OrderDataServiceMySqlImpl();
				orderPOList=o.findClientInHotelAllOrderList("C00000003", "H00000010");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(orderPOList.size()!=0){
				for(int i=0;i<orderPOList.size();i++)
					System.out.println(orderPOList.get(i).getPrice());
			}
		}
		// OrderDataServiceMySqlImpl findAbnormalOrderList
		void test15(){
			OrderDataServiceMySqlImpl o;
			ArrayList<OrderPO> orderPOList=new ArrayList<OrderPO>();
			try {
				o=new OrderDataServiceMySqlImpl();
				orderPOList=o.findAbnormalOrderList("2016-12-02 12:00:00");
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(orderPOList.size()!=0){
				for(int i=0;i<orderPOList.size();i++)
					System.out.println(orderPOList.get(i).getPrice());
			}
		}
		// LogDataServiceMySqlImpl getLogList
		void test16(){
			LogDataServiceMySqlImpl li;
			ArrayList<LogPO> list=new ArrayList<LogPO>();
			try {
				li=new LogDataServiceMySqlImpl();
				list=li.getLogList();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			System.out.println(list.size());
			System.out.println(list.get(0).getLogInfo());
		}
		// LogDataServiceMySqlImpl addLog
		void test17(){
			LogDataServiceMySqlImpl li;
			LogPO logPO=new LogPO("M00000010 Mon Dec 07 23:23:32 CDT 2016 修改C00000015信用值");
			boolean result=false;
			try {
				li=new LogDataServiceMySqlImpl();
				result=li.addLog(logPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}	
			System.out.println(result);
		}
}
