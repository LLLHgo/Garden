package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Enum.OrderType;
import Enum.UserType;
import po.OrderPO;

public class OrderDataService_Driver {
	public void driver( OrderDataService orderDataService) throws RemoteException{
		boolean result;
		OrderPO orderPO = null;
		ArrayList<OrderPO> orderPOList=null;
		Iterator<OrderPO> it;
		
		// 在数据库中增加一个订单记录
		System.out.println("在数据库中增加一个订单记录");
		result=orderDataService.add(orderPO);
		if(result==true){
			System.out.println("增加记录成功");
		}
		else
			System.out.println("增加记录失败");
		
		// 在数据库中保存一个订单记录
		System.out.println("在数据库中保存一个订单记录");
		result=orderDataService.add(orderPO);
		if(result==true){
			System.out.println("保存记录成功");
		}
		else
			System.out.println("保存记录失败");
		
		// 将数据库中将订单置为取消状态
		System.out.println("将数据库中将订单置为取消状态");
		result=orderDataService.cancel("20161015143702");
		if(result==true){
			System.out.println("订单置为取消状态成功");
		}
		else
			System.out.println("订单置为取消状态失败");
		
		// 查找某用户的具体订单
		System.out.println("查找某用户的具体订单");
		orderPO=orderDataService.findSpecificUserOrder("20160823131207");
		System.out.println("显示该订单");
		System.out.println(orderPO.getClientId()+" "+orderPO.getHotelName()+" "+orderPO.getPrice());
		System.out.println("这里是该订单的详细信息");
		
		// 查找某用户的所有订单
		System.out.println("查找某用户的所有订单");
		orderPOList=orderDataService.findUserOrderList("C00000099");
		System.out.println("显示该用户的所有订单");
		it=orderPOList.iterator();
		/*while(it.hasNext()){
		System.out.println(((OrderVO) it).getClientId()+" "+((OrderVO) it).getClientName()+" "
	           +((OrderVO) it).getHotelName()+" "+((OrderVO) it).getPrice()+((OrderVO) it).getOrderDate());
		}*/
		System.out.println("这里是该用户的所有订单");
		
		// 查找数据库中某客户的某个种类（正常未执行、正常已执行、取消、异常）的订单
		System.out.println("查找数据库中某客户的某个种类（正常未执行、正常已执行、取消、异常）的订单");
		orderPOList=orderDataService.findClientTypeOrderList(OrderType.ABNORMAL,"C00000008");
		System.out.println("显示该客户该种类的所有订单");
		it=orderPOList.iterator();
		/*while(it.hasNext()){
		System.out.println(((OrderVO) it).getClientId()+" "+((OrderVO) it).getClientName()+" "
	           +((OrderVO) it).getHotelName()+" "+((OrderVO) it).getPrice()+((OrderVO) it).getOrderDate());
		}*/
		System.out.println("这里是该客户该种类的所有订单");
		
		// 查找数据库中某天的异常订单
		System.out.println("查找数据库中某天的异常订单");
		orderPOList=orderDataService.findAbnormalOrderList("");
		System.out.println("显示数据库中某天的异常订单");
		it=orderPOList.iterator();
		/*while(it.hasNext()){
		System.out.println(((OrderVO) it).getClientId()+" "+((OrderVO) it).getClientName()+" "
	           +((OrderVO) it).getHotelName()+" "+((OrderVO) it).getPrice()+((OrderVO) it).getOrderDate());
		}*/
		System.out.println("数据库中某天的异常订单");
		
		// 根据时间，在数据库中将超时订单置为异常状态
		System.out.println("根据时间，在数据库中将超时订单置为异常状态");
		//orderDataService.checkTime("20160823131207");
		
		
	}

}
