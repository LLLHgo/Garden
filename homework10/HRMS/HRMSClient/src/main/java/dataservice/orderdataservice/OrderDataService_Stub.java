package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.UserType;
import po.OrderPO;

public class OrderDataService_Stub implements OrderDataService{
	OrderPO orderPO;
	List<OrderPO> orderPOList;
	public OrderDataService_Stub(OrderPO orderPO,List<OrderPO> orderPOList){
		this.orderPO=orderPO;
		this.orderPOList=orderPOList;
		
	}
	/**
	 * 在数据库中增加一个订单记录
	 * @param order
	 * @return  添加成功（true）或失败（false）的布尔值
	 */
	@Override
	public boolean add(OrderPO order) throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 在数据库中保存一个订单记录
	 * @param order
	 * @return 添加成功（true）或失败（false）的布尔值
	 */
	@Override
	public boolean save(OrderPO order) throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 将数据库中将订单置为取消状态
	 * @param orderId
	 * @return 置为取消状态成功（true）或失败（false）的布尔值
	 */
	@Override
	public boolean cancel(String orderId)throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 查找某用户的具体订单
	 * @param userType
	 * @param orderId
	 * @return
	 */
	@Override
	public OrderPO findSpecificUserOrder(UserType userType, String orderId) throws RemoteException{
		// TODO Auto-generated method stub
		return orderPO;
	}
	
	/**
	 * 查找某客户的所有订单
	 * @param userId
	 * @return
	 */
	@Override
	public List<OrderPO> findUserOrderList(String userId)throws RemoteException {
		// TODO Auto-generated method stub
		return orderPOList;
	}
	
	/**
	 *  查找数据库中某客户的某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param clientId
	 * @return 订单列表
	 */
	@Override
	public List<OrderPO> findClientTypeOrder(OrderType orderType,String clientId) throws RemoteException{
		// TODO Auto-generated method stub
		return orderPOList;
	}
	
	/**
	 * 查找数据库中某天的异常订单
	 * @param date
	 * @return 异常订单列表
	 */
	@Override
	public List<OrderPO> findAbnormalOrderList(Date date)throws RemoteException {
		// TODO Auto-generated method stub
		return orderPOList;
	}

	/**
	 * 根据时间，在数据库中将超时订单置为异常状态
	 * @param orderId
	 */
	@Override
	public void checkTime(String orderId) throws RemoteException{
		// TODO Auto-generated method stub
		
	}

}
