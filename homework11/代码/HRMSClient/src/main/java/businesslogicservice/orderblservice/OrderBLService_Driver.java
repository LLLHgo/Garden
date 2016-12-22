package businesslogicservice.orderblservice;

import Enum.ResultMessage;
import vo.orderVO.OrderVO;
import Enum.VIPType;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Enum.OrderType;
/*
public class OrderBLService_Driver {
	public void drive(OrderOperatorBLService operator,OrderFindBLService finf,OrderCheckTimeBLService check){
		OrderVO orderVO = null;
		List<OrderVO> orderList;
		Iterator<OrderVO> it;
		Date date;
		ResultMessage result;
		
		// 下订单
		System.out.println("下订单:");
		result=orderBLService.createOrder(new OrderVO("20161015085702","C00000002","Lucy","17714368889",
				VIPType.ORDINARYVIP,"2016-10-15 08:57",OrderType.NORMALNONEXEC,"caesar","H00000001",650.32,new ArrayList<String>()));
		if(result==ResultMessage.SUCCESS) 
			System.out.println("创建失败");
		else if(result==ResultMessage.FAIL)
			System.out.println("创建成功");
		
		// 保存订单
		System.out.println("保存订单:");
		result=orderBLService.createOrder(new OrderVO("20161015085702","C00000002","Lucy","17714368889",
				VIPType.ORDINARYVIP,"2016-10-15 08:57",OrderType.NORMALNONEXEC,"caesar","H00000001",650.32,new ArrayList<String>()));
		if(result==ResultMessage.SUCCESS) 
			System.out.println("保存成功");
		else if(result==ResultMessage.FAIL)
			System.out.println("保存失败");
		
		// 取消订单
		System.out.println("取消订单:");
		result=operator.cancelOrderPO("20161015085702");
		if(result==ResultMessage.SUCCESS) 
			System.out.println("订单号对应的订单不存在，置为取消状态失败");
		else 
			System.out.println("成功将该订单号对应订单置为取消状态");
		

				
		// 查找某种用户(客户或酒店)的所有订单
		System.out.println("查找Lily的所有订单：");
		orderList=find.findUserOrderList("C00000089");
		System.out.print("查找结果： ");
		it=orderList.iterator();
		while(it.hasNext()){
		System.out.println(((OrderVO) it).getClientId()+" "+((OrderVO) it).getClientName()+" "
	           +((OrderVO) it).getHotelName()+" "+((OrderVO) it).getPrice()+((OrderVO) it).getOrderDate());
		}
		System.out.println("这里是Lily的所有订单");
		
		// 查找客户某天的订单
		System.out.println("查找Alina在2016年10月14日的订单：");
		orderList=find.findSpecificDayClientOrderList("C00000090",new Date());
		System.out.print("查找结果： ");
		it=orderList.iterator();
		while(it.hasNext()){
		System.out.println(((OrderVO) it).getClientId()+" "+((OrderVO) it).getClientName()+" "
	           +((OrderVO) it).getHotelName()+" "+((OrderVO) it).getPrice()+((OrderVO) it).getOrderDate());
		}
		System.out.println("这里是Alina在2016年10月14日的订单");
		
		// 查找用户客户在某个酒店的所有订单
		System.out.println("查找Nancy在LLLH酒店的所有订单：");
		orderList=find.findSpecificHotelClientOrderList("C00000091","H00000001");
		System.out.print("查找结果： ");
		it=orderList.iterator();
		while(it.hasNext()){
		System.out.println(((OrderVO) it).getClientId()+" "+((OrderVO) it).getClientName()+" "
	           +((OrderVO) it).getHotelName()+" "+((OrderVO) it).getPrice()+((OrderVO) it).getOrderDate());
		}
		System.out.println("这里是Nancy在LLLH酒店的所有订单");
		
		// 查找客户某个种类（正常未执行、正常已执行、取消、异常）的订单
		System.out.println("查找Nancy的正常未执行订单：");
		orderList=find.findClientTypeOrderList(OrderType.NORMALNONEXEC,"C00000091");
		System.out.print("查找结果： ");
		it=orderList.iterator();
		while(it.hasNext()){
		System.out.println(((OrderVO) it).getClientId()+" "+((OrderVO) it).getClientName()+" "
	           +((OrderVO) it).getHotelName()+" "+((OrderVO) it).getPrice()+((OrderVO) it).getOrderDate());
		}
		System.out.println("这里是Nancy的正常未执行订单");
		
		
		//查找具体某天的异常订单
		System.out.println("查找2016年9月15日的异常订单：");
		orderList=find.findAbnormalOrderList(new Date());
		System.out.print("查找结果： ");
		it=orderList.iterator();
		while(it.hasNext()){
		System.out.println(((OrderVO) it).getClientId()+" "+((OrderVO) it).getClientName()+" "
	           +((OrderVO) it).getHotelName()+" "+((OrderVO) it).getPrice()+((OrderVO) it).getOrderDate());
		}
		System.out.println("这里是2016年9月15日的异常订单");
		
		//检查时间，判断是否将订单置为异常
		System.out.println("晚上12点了，判断订单是否要变更为异常状态");
		boolean resultBoolean=check.checkTimeOperateAbnormal(orderVO,new Date());
		System.out.print("结果： ");
		if(resultBoolean==true)
			System.out.print("置为异常");
		else
			System.out.print("不变更为异常状态");		
	}
}*/
