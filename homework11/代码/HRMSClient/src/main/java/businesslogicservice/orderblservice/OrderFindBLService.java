package businesslogicservice.orderblservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import vo.orderVO.OrderVO;

public interface OrderFindBLService {
	/**
	 * 查找某种用户(客户或酒店)的所有订单
	 * @param userID
	 * @return 某种用户(客户或酒店)的所有订单列表
	 */
	public ArrayList<OrderVO>  findUserOrderList (String userID);

	/**
	 * 查找客户某天的订单
	 * @param clientId
	 * @param date
	 * @return 客户某天的订单列表
	 */
	public  ArrayList<OrderVO> findSpecificDayClientOrderList(String clientId, String date);
	/**
	 * 查找客户在某个酒店的所有订单
	 * @param clientId
	 * @param hoteIId
	 * @return 客户在某个酒店的所有订单列表
	 */
	public  ArrayList<OrderVO> findSpecificHotelClientOrderList (String clientId, String hoteIId);
	/**
	 * 查找客户某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param type
	 * @param clientId
	 * @return 客户某个种类（正常未执行、正常已执行、取消、异常）的订单列表
	 */
	public ArrayList<OrderVO> findClientTypeOrderList (OrderType type,String clientId);
	
	/**
	 * 查找酒店的某一类型的所有订单
	 * @param type
	 * @param hotelId
	 * @return
	 */
	public ArrayList<OrderVO> findHotelTypeOrderList(OrderType type, String hotelId);

	/**
	 * 查找具体某天的异常订单
	 * @param date
	 * @return 具体某天的所有订单列表
	 */
	public ArrayList<OrderVO> findAbnormalOrderList (String date);
	/**
	 * 返回给某一用户的具体订单
	 * @param userType
	 * @param orderID
	 * @return
	 */
	public OrderVO findSpecificOrder(String userId, String orderId);



}
