package businesslogicservice.orderblservice;

import java.util.ArrayList;

import Enum.OrderType;
import Enum.ResultMessage;
import Enum.VIPType;
import vo.orderVO.OrderVO;
/**
 * 订单模块的bl层桩
 * @author yilu
 *
 */
public class OrderBLService_Stub implements OrderOperatorBLService,OrderCheckTimeBLService,OrderFindBLService{
	    
	OrderVO orderVO;
	
	public OrderBLService_Stub(){
	
	}
	
	public OrderBLService_Stub(OrderVO orderVO){
		this.orderVO=orderVO;
	}

	/**
	 * 下订单
	 * @param orderInfo
	 * @return 创建订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	@Override
	public ResultMessage createOrderPO(OrderVO orderInfo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 保存订单
	 * @param order
	 * @return 保存订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	@Override
	public ResultMessage saveOrderPO(OrderVO order) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	/**
	 * 取消订单
	 * @param orderId
	 * @return 置订单于取消状态成功（Success）或是失败（fail）的ResultMessage值
	 */
	@Override
	public ResultMessage cancelOrderPO(String orderId) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	/**
	 * 查找某用户的具体订单
	 */
	@Override
	public OrderVO findSpecificOrder(String userId, String orderID) {
		// TODO Auto-generated method stub
		OrderVO orderVO=new OrderVO("000000001","C00000001","小螺丝","16679876372",VIPType.ORDINARYVIP,"2016-12-01 12:23:28",
				OrderType.NORMALNONEXEC,"冠军楼酒店","H00000010",340.28,null,"大床房",1,1,"2016-12-19 12:00:00",
				null,"2016-12:20 12:00:00",400.00,false);
		return orderVO;
	}

	/**
	 * 查找某种用户(客户或酒店)的所有订单
	 * @param userID
	 * @return 某种用户(客户或酒店)的所有订单列表
	 */
	@Override
	public ArrayList<OrderVO> findUserOrderList(String userID) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> UserOrderList=new ArrayList<OrderVO>();
		return UserOrderList;
	}
	/**
	 * 查找客户某天的订单
	 * @param clientId
	 * @param date
	 * @return 客户某天的订单列表
	 */
	@Override
	public ArrayList<OrderVO> findSpecificDayClientOrderList(String clientId, String date) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> SpecificDayClientOrderList=new ArrayList<OrderVO>();
		return SpecificDayClientOrderList;
	}
	/**
	 * 查找用户客户在某个酒店的所有订单
	 * @param clientId
	 * @param hoteIId
	 * @return 客户在某个酒店的所有订单列表
	 */
	@Override
	public ArrayList<OrderVO> findSpecificHotelClientOrderList(String clientId, String hoteIId) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> SpecificHotelClientOrderList=new ArrayList<OrderVO>();
		return SpecificHotelClientOrderList;
	}
	/**
	 * 查找客户某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param type
	 * @param clientId
	 * @return 客户某个种类（正常未执行、正常已执行、取消、异常）的订单列表
	 */
	@Override
	public ArrayList<OrderVO> findClientTypeOrderList(OrderType type, String clientId) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> ClientTypeOrder=new ArrayList<OrderVO>();
		return  ClientTypeOrder;
	}

	/**
	 * 查找具体某天的异常订单
	 * @param date
	 * @return 具体某天的所有订单列表
	 */
	@Override
	public ArrayList<OrderVO> findAbnormalOrderList(String date) {
		// TODO Auto-generated method stub
		ArrayList<OrderVO> findAbnormalOrder=new ArrayList<OrderVO>();
		return  findAbnormalOrder;
	}
	/**
	 * 检查时间，判断是否将订单置为异常
	 * @param order
	 * @param date
	 * @return 判断订单置为异常状态（true）或不修改状态（false）的布尔值
	 */
	@Override
	public boolean checkTimeOperateAbnormal() {
		// TODO Auto-generated method stub
		return false;
	}
	//@Override
	public ArrayList<OrderVO> findHotelTypeOrderList(OrderType type, String hotelId) {
		OrderVO orderVO4=new OrderVO("20161016092301","C00000010","Lily","17887780990"
		,VIPType.ORDINARYVIP,"2016-10-16 09:23",OrderType.NORMALNONEXEC,"LLLHH","H00000002",998,null);

OrderVO orderVO5=new OrderVO("20161017092401","C00000011","Tinny","17887780991"
		,VIPType.ORDINARYVIP,"2016-10-17 09:24",OrderType.NORMALEXEC,"LLLHH","H00000002",666,null);

OrderVO orderVO6=new OrderVO("20161017092501","C00000012","belikout","17887780992"
		,VIPType.ORDINARYVIP,"2016-10-17 09:25",OrderType.ABNORMAL,"LLLHH","H00000002",666,null);

OrderVO orderVO7=new OrderVO("20161017092601","C00000013","sweetstreet","17887780993"
		,VIPType.ORDINARYVIP,"2016-10-17 09:26",OrderType.ABNORMAL,"LLLHH","H00000002",666,null);
//OrderDataTool.list1.add(orderVO4);
//OrderDataTool.list1.add(orderVO5);
//OrderDataTool.list1.add(orderVO6);
//OrderDataTool.list1.add(orderVO7);
ArrayList<OrderVO> list=new ArrayList<OrderVO>();
list.add(orderVO4);
list.add(orderVO5);
list.add(orderVO6);
list.add(orderVO7);
		return list;
	}

	
}
