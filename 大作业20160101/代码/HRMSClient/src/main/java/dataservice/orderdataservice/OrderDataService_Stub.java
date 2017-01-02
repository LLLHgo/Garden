package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Enum.OrderType;
import datatool.OrderDataTool;
import po.OrderPO;
/**
 * 日志模块的客户端dataservice的桩
 * @author yilu
 *
 */

public class OrderDataService_Stub implements OrderDataService{
	OrderPO orderPO;
	ArrayList<OrderPO> orderPOList;
	OrderDataTool orderdatatool;
	public OrderDataService_Stub(OrderPO orderPO,ArrayList<OrderPO> orderPOList){
		this.orderPO=orderPO;
		this.orderPOList=orderPOList;
	}
	public OrderDataService_Stub() throws RemoteException{
		orderdatatool=new OrderDataTool();
	}
	/**
	 * 在数据库中增加一个订单记录
	 * @param order
	 * @return  添加成功（true）或失败（false）的布尔值
	 */
	@Override
	public boolean add(OrderPO order) throws RemoteException{
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * 在数据库中保存一个订单记录
	 * @param order
	 * @return 添加成功（true）或失败（false）的布尔值
	 */
	@Override
	public boolean save(OrderPO order) throws RemoteException{
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * 将数据库中将订单置为取消状态
	 * @param orderId
	 * @return 置为取消状态成功（true）或失败（false）的布尔值
	 */
	@Override
	public boolean cancel(String orderId)throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}
	
	/**
	 * 查找某用户的具体订单
	 * @param userType
	 * @param orderId
	 * @return
	 */
	@Override
	public OrderPO findSpecificUserOrder(String orderId) throws RemoteException{
		// TODO Auto-generated method stub
		return orderdatatool.orderPOFindTester;
	}
	
	/**
	 * 查找某客户的所有订单
	 * @param userId
	 * @return
	 */
	@Override
	public ArrayList<OrderPO> findUserOrderList(String userId)throws RemoteException {
		// TODO Auto-generated method stub
		return orderPOList;
	}
	
	/**
	 *  查找数据库中某客户的某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param clientId
	 * @return 订单列表
	 */
	@Override
	public ArrayList<OrderPO> findClientTypeOrderList(OrderType orderType,String clientId) throws RemoteException{
		// TODO Auto-generated method stub
		return orderPOList;
	}
	
	/**
	 * 查找数据库中某天的异常订单
	 * @param date
	 * @return 异常订单列表
	 */
	@Override
	public ArrayList<OrderPO> findAbnormalOrderList(String date)throws RemoteException {
		// TODO Auto-generated method stub
		return orderPOList;
	}

	/**
	 * 根据时间，在数据库中将超时订单置为异常状态
	 * @param orderId
	 */
	@Override
	public boolean checkTimeOperateAbnormal() throws RemoteException{
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public int lookIdValid() throws RemoteException {
		
		return 105;
	}
	@Override
	public ArrayList<OrderPO> findHotelTypeOrderList(OrderType orderType, String hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<OrderPO> findClientInHotelAllOrderList(String clientId, String hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<OrderPO> findSpecificDayClientOrderList(String clientId, String date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
