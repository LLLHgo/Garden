package Mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import Enum.VIPType;
import datatool.LogDataTool;
import datatool.OrderDataTool;
import po.OrderPO;
import vo.orderVO.OrderVO;
/**
 * order的mock
 * @author yilu
 *
 */
public class MockOrderManage {
	// 订单号
   private String orderId;
   // 客户帐号
   private String clientId;
   // 客户名字
	private String clientName;
	// 客户手机号
	private String clientPhone;
	// 客户vip类型
	private VIPType vipType;
	// 订单下达时间
	private Date orderDate;
	// 订单类型
	private OrderType orderType;
	// 订单中酒店名称
	private String hotelName;
	// 订单价格
	private double price;
	// 订单享受的优惠策略
	private ArrayList <String> strategies;
	// 酒店帐号
	private String hotelId;
	// 日志
	private String logInfo;
	// orderVO
	public OrderVO orderVO;

	OrderDataTool orderDatatool=new OrderDataTool();

	LogDataTool logDataToll=new LogDataTool();

	// 构造函数1
	public MockOrderManage(OrderVO orderVO){
		this.orderVO=orderVO;
	}
	// 构造函数2
	public MockOrderManage(String str){
		if(str.length()==16)
			this.orderId=str;
		else if(str.charAt(0)=='C')
			this.clientId=str;
		else if(str.charAt(0)=='H')
			this.hotelId=str;
		else
			this.logInfo=str;
	}
	// 构造函数3
	public MockOrderManage(){

	}
	// 构造函数4
	public MockOrderManage(String str,Date orderDate){
		if(str.charAt(0)=='C'){
			this.clientId=str;
			this.orderDate=orderDate;
		}
		else{
			this.orderId=str;
			this.orderDate=orderDate;
		}
	}


	/**
	 * 下订单
	 * @param orderInfo
	 * @return 创建订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage createOrder (OrderVO orderInfo){
		return ResultMessage.SUCCESS;
	}
	/**
	 * 保存订单
	 * @param order
	 * @return 保存订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage saveOrder (OrderVO order){
		return ResultMessage.SUCCESS;
	}
	/**
	 * 取消订单
	 * @param orderId
	 * @return 置订单于取消状态成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage cancelOrder (String orderId){
		return ResultMessage.SUCCESS;
	}
	/**
	 * 查找具体订单
	 * @param orderID
	 * @return 具体订单
	 */
	public OrderVO  findSpecificOrder(String orderID){
		return OrderDataTool.orderVO1;
	}
	/**
	 * 查找某种用户(客户或酒店)的所有订单
	 * @param userID
	 * @return 某种用户(客户或酒店)的所有订单列表
	 */
	public ArrayList<OrderVO>  findUserOrderList (String userID){
		return OrderDataTool.list1;
	}

	/**
	 * 查找客户某天的订单
	 * @param clientId
	 * @param date
	 * @return 客户某天的订单列表
	 */
	public  List<OrderVO> findSpecificDayClientOrder(String clientId, Date date){
		return OrderDataTool.list2;
	}
	/**
	 * 查找客户在某个酒店的所有订单
	 * @param clientId
	 * @param hoteIId
	 * @return 客户在某个酒店的所有订单列表
	 */
	public  List<OrderVO> findSpecificHotelClientOrder (String clientId, String hoteIId){
		return OrderDataTool.list1;
	}
	/**
	 * 查找客户某个种类（正常未执行、正常已执行、取消、异常）的订单
	 * @param type
	 * @param clientId
	 * @return 客户某个种类（正常未执行、正常已执行、取消、异常）的订单列表
	 */
	public  ArrayList<OrderVO> findClientTypeOrder (OrderType type,String clientId){
		return OrderDataTool.list1;
	}

	/**
	 * 查找酒店的某个具体订单
	 * @param hotelId
	 * @param orderId
	 * @return 酒店的某个具体订单
	 */
	public OrderVO findSpecificHotelOrder (String hotelId, String orderId){
		return OrderDataTool.orderVO4;
	}

	/**
	 * 查找具体某天的异常订单
	 * @param date
	 * @return 具体某天的所有订单列表
	 */
	public ArrayList<OrderVO> findAbnormalOrderList (Date date){
		return OrderDataTool.list3;
	}

	/**
	 * 检查时间，判断是否将订单置为异常
	 * @param order
	 * @param date
	 * @return 判断订单置为异常状态（true）或不修改状态（false）的布尔值
	 */
	public boolean checkTime (OrderVO order, Date date){
		return true;
	}


}

