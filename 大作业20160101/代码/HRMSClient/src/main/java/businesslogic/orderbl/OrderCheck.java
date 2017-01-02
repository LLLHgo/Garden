package businesslogic.orderbl;

import java.rmi.RemoteException;

import businesslogic.clientbl.ClientManage;
import businesslogicservice.orderblservice.OrderCheckTimeBLService;
import dataservice.orderdataservice.OrderDataService;
import rmi.RemoteHelper;
import vo.orderVO.OrderVO;
/**
 * 检查订单是否超时的类，若超时则置为异常
 * @author yilu
 *
 */
public class OrderCheck implements OrderCheckTimeBLService{

	OrderDataService orderDateService;
	RemoteHelper remote;
	boolean result=false;
	//ClientManage clientManage;

	public OrderCheck(){
		remote=RemoteHelper.getInstance();
		orderDateService=remote.getOrderDataService();
		//clientManage=new ClientManage();
	}
	@Override
	public boolean checkTimeOperateAbnormal() {
		try {
			result=orderDateService.checkTimeOperateAbnormal();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
