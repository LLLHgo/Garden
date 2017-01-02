package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.UserType;
import po.OrderPO;
/**
 * order数据层的桩
 * @author yilu
 *
 */
public class OrderDataService_Stub implements OrderDataService{
	OrderPO orderPO;
	ArrayList<OrderPO> orderPOList;
	public OrderDataService_Stub(OrderPO orderPO,ArrayList<OrderPO> orderPOList){
		this.orderPO=orderPO;
		this.orderPOList=orderPOList;
		
	}
	/**
	 * 在数据库中增加一个订单记录
	 * @param order
	 * @return  添加成功（true）或失败（false）的布尔值
	 */
	
	public boolean add(OrderPO order) throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 在数据库中保存一个订单记录
	 * @param order
	 * @return 添加成功（true）或失败（false）的布尔值
	 */

	public boolean save(OrderPO order) throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 将数据库中将订单置为取消状态
	 * @param orderId
	 * @return 置为取消状态成功（true）或失败（false）的布尔值
	 */
	
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
	
	public OrderPO findSpecificUserOrder(UserType userType, String orderId) throws RemoteException{
		// TODO Auto-generated method stub
		return orderPO;
	}
	
	/**
	 * 查找某客户的所有订单
	 * @param userId
	 * @return
	 */
	
	public ArrayList<OrderPO> findUserOrderList(String userId)throws RemoteException {
		// TODO Auto-generated method stub
		return orderPOList;
	}
	
	/**
	 *  查找数据库中某客户的某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param clientId
	 * @return 订单列表
	 */
	
	public List<OrderPO> findClientTypeOrder(OrderType orderType,String clientId) throws RemoteException{
		// TODO Auto-generated method stub
		return orderPOList;
	}
	
	/**
	 * 查找数据库中某天的异常订单
	 * @param date
	 * @return 异常订单列表
	 */
	public List<OrderPO> findAbnormalOrderList(Date date)throws RemoteException {
		// TODO Auto-generated method stub
		return orderPOList;
	}

	/**
	 * 根据时间，在数据库中将超时订单置为异常状态
	 * @param orderId
	 */
	public void checkTime(String orderId) throws RemoteException{
		// TODO Auto-generated method stub
		
	}
	public int lookIdValid() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
	public OrderPO findSpecificUserOrder(String orderId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<OrderPO> findSpecificDayClientOrderList(String clientId, String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderPO> findClientTypeOrderList(OrderType orderType, String clientId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<OrderPO> findHotelTypeOrderList(OrderType orderType, String hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<OrderPO> findClientInHotelAllOrderList(String clientId, String hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<OrderPO> findAbnormalOrderList(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean checkTimeOperateAbnormal() throws RemoteException {
		return false;
		// TODO Auto-generated method stub
		
	}

}
