package dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.UserType;
import po.OrderPO;

public interface OrderDataService extends Remote{
	/**
	 * 在数据库中增加一个订单记录
	 * @param order
	 * @return  添加成功（true）或失败（false）的布尔值
	 */
	public boolean add(OrderPO order)throws RemoteException;
	
	/**
	 * 在数据库中保存一个订单记录
	 * @param order
	 * @return 添加成功（true）或失败（false）的布尔值
	 */
	public boolean save(OrderPO order)throws RemoteException;
	/**
	 * 将数据库中将订单置为取消状态
	 * @param orderId
	 * @return 置为取消状态成功（true）或失败（false）的布尔值
	 */
	public boolean cancel(String orderId)throws RemoteException;
	
	/**
	 * 查找某用户的具体订单
	 * @param userType
	 * @param orderId
	 * @return OrderPO
	 */
	public OrderPO findSpecificUserOrder(UserType userType, String orderId)throws RemoteException;
	
	/**
	 * 查找某用户的所有订单
	 * @param userId
	 * @return
	 */
	public List<OrderPO> findUserOrderList(String userId) throws RemoteException;
	
	/**
	 *  查找数据库中某客户的某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param clientId
	 * @return 订单列表
	 */
	public List<OrderPO> findClientTypeOrder (OrderType orderType,String clientId) throws RemoteException;
	
	/**
	 * 查找数据库中某天的异常订单
	 * @param date
	 * @return 异常订单列表
	 */
	public List<OrderPO> findAbnormalOrderList(Date date) throws RemoteException;
	
	/**
	 * 根据时间，在数据库中将超时订单置为异常状态
	 * @param orderId
	 */
	public void checkTime (String orderId) throws RemoteException;
}
