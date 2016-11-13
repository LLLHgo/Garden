package businesslogicservice.orderblservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import po.OrderPO;
import vo.orderVO.OrderVO;

public class OrderBLService_Stub implements OrderBLService{
	    
	OrderVO orderVO;
	
	public OrderBLService_Stub(OrderVO orderVO){
		this.orderVO=orderVO;
	}
	/**
	 * 下订单
	 * @param orderInfo
	 * @return 创建订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	@Override
	public ResultMessage createOrder(OrderVO orderInfo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 保存订单
	 * @param order
	 * @return 保存订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	@Override
	public ResultMessage saveOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	/**
	 * 取消订单
	 * @param orderId
	 * @return 置订单于取消状态成功（Success）或是失败（fail）的ResultMessage值
	 */
	@Override
	public ResultMessage cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	/**
	 * 查找具体订单
	 * @param orderID
	 * @return 具体订单
	 */
	@Override
	public OrderVO findSpecificOrderList(String orderID) {
		// TODO Auto-generated method stub
		return orderVO;
	}
	/**
	 * 查找某种用户(客户或酒店)的所有订单
	 * @param userID
	 * @return 某种用户(客户或酒店)的所有订单列表
	 */
	@Override
	public List<OrderVO> findUserOrderList(String userID) {
		// TODO Auto-generated method stub
		List<OrderVO> UserOrderList=new ArrayList<OrderVO>();
		return UserOrderList;
	}
	/**
	 * 查找客户某天的订单
	 * @param clientId
	 * @param date
	 * @return 客户某天的订单列表
	 */
	@Override
	public List<OrderVO> findSpecificDayClientOrder(String clientId, Date date) {
		// TODO Auto-generated method stub
		List<OrderVO> SpecificDayClientOrderList=new ArrayList<OrderVO>();
		return SpecificDayClientOrderList;
	}
	/**
	 * 查找用户客户在某个酒店的所有订单
	 * @param clientId
	 * @param hoteIId
	 * @return 客户在某个酒店的所有订单列表
	 */
	@Override
	public List<OrderVO> findSpecificHotelClientOrder(String clientId, String hoteIId) {
		// TODO Auto-generated method stub
		List<OrderVO> SpecificHotelClientOrderList=new ArrayList<OrderVO>();
		return SpecificHotelClientOrderList;
	}
	/**
	 * 查找客户某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param type
	 * @param clientId
	 * @return 客户某个种类（正常未执行、正常已执行、取消、异常）的订单列表
	 */
	@Override
	public List<OrderVO> findClientTypeOrder(OrderType type, String clientId) {
		// TODO Auto-generated method stub
		List<OrderVO> ClientTypeOrder=new ArrayList<OrderVO>();
		return  ClientTypeOrder;
	}
	/**
	 * 查找酒店的某个具体订单
	 * @param hotelId
	 * @param orderId
	 * @return 酒店的某个具体订单
	 */
	@Override
	public OrderVO findSpecificHotelOrder(String hotelId, String orderId) {
		// TODO Auto-generated method stub
		return orderVO;
	}
	/**
	 * 查找具体某天的异常订单
	 * @param date
	 * @return 具体某天的所有订单列表
	 */
	@Override
	public List<OrderVO> findAbnormalOrderList(Date date) {
		// TODO Auto-generated method stub
		List<OrderVO> findAbnormalOrder=new ArrayList<OrderVO>();
		return  findAbnormalOrder;
	}
	/**
	 * 检查时间，判断是否将订单置为异常
	 * @param order
	 * @param date
	 * @return 判断订单置为异常状态（true）或不修改状态（false）的布尔值
	 */
	@Override
	public boolean checkTime(OrderVO order, Date date) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
