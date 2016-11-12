package vo.orderVO;

import java.util.ArrayList;
import java.util.Date;

import Enum.OrderType;
import Enum.VIPType;

public class OrderVO {
	 // 订单号
    public String orderId;
    // 客户帐号
    private String clientId;
    // 客户名字
	private String clientName;
	// 客户手机号
	private String clientPhone;
	// 客户vip类型
	private VIPType vipType;
	// 订单下达时间
	private String orderDate;
	// 订单类型
	private OrderType orderType;
	// 订单中酒店名称
	private String hotelName;
	// hotelId
	private String hotelId;
	// 订单价格
	private double price;
	// 订单享受的优惠策略
	private ArrayList <String> strategies;

	public OrderVO(){

	}
	public OrderVO (String orderId,String clientId,String clientName,String clientPhone,VIPType vipType,
			String orderDate,OrderType orderType,String hotelName,String hotelId,double price,ArrayList <String> strategies){
		this.orderId=orderId;
		this.clientId=clientId;
		this.clientName=clientName;
		this.clientPhone=clientPhone;
		this.vipType=vipType;
		this.orderDate=orderDate;
		this.orderType=orderType;
		this.hotelName=hotelName;
		this.hotelId=hotelId;
		this.price=price;
		this.strategies=strategies;
		}

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
				this.orderId = orderId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
     	this.orderDate = orderDate;
	}
	public OrderType getOrderStatus() {
		return orderType;
	}
	public void setOrderStatus(OrderType orderType) {
		this.orderType = orderType;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ArrayList<String> getStrategies() {
		return strategies;
	}
	public void setStrategies(ArrayList<String> strategies) {
		this.strategies = strategies;
	}
	public VIPType getVipType() {
		return vipType;
	}
	public void setVipType(VIPType vipType) {
		this.vipType = vipType;
	}
	public OrderType getOrderType() {
		return orderType;
	}
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
}
