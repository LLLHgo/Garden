package dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import po.OrderPO;

public interface OrderDataService extends Remote{
	/**
	 * 在数据库中查看当前可用的新id号
	 * @return 当前可用的新id号
	 * @throws RemoteException
	 */
	public int lookIdValid() throws RemoteException;
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
	public OrderPO findSpecificUserOrder(String orderId)throws RemoteException;
	/**
	 * 查找客户某天的所有订单
	 * @param clientId
	 * @param orderId
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> findSpecificDayClientOrderList(String clientId,String date)throws RemoteException;
	
	/**
	 * 查找某用户的所有订单
	 * @param userId
	 * @return
	 */
	public ArrayList<OrderPO> findUserOrderList(String userId) throws RemoteException;
	
	/**
	 *  查找数据库中某客户的某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param clientId
	 * @return 订单列表
	 */
	public ArrayList<OrderPO> findClientTypeOrderList (OrderType orderType,String clientId) throws RemoteException;
	
	/**
	 *  查找数据库中某酒店的某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param clientId
	 * @return 订单列表
	 */
	public ArrayList<OrderPO> findHotelTypeOrderList (OrderType orderType,String hotelId) throws RemoteException;
	/**
	 * 查找数据库中某客户在某酒店的所有订单
	 * @param clientId
	 * @param orderId
	 * @return 订单列表
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> findClientInHotelAllOrderList(String clientId,String hotelId) throws RemoteException;
	
	/**
	 * 查找数据库中某天的异常订单
	 * @param date
	 * @return 异常订单列表
	 */
	public ArrayList<OrderPO> findAbnormalOrderList(String date) throws RemoteException;
	
	/**
	 * 根据时间，在数据库中将超时订单置为异常状态
	 * @param orderId
	 */
	public void checkTimeOperateAbnormal (String orderId) throws RemoteException;
}
