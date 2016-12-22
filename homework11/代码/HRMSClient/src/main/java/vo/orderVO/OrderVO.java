package vo.orderVO;

import java.util.ArrayList;

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
	private String orderDate;  // "2016-12-01 12:21:21"
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
	//房间类型
	private String roomType="标准间";
	//房间数量
	private int roomNum=1;
	// 入住天数
	private int days=1;
	// 预计入住时间
	private String anticipateArrivedTime; // 如“2016-12-02 12:00:00
	// 实际入住时间
	private String actualArrivedTime; // 如“2016-12-02 13:28:40
	// 预计离开时间
	private String anticipateLeaveTime; // 预计离开时间 如“2016-12-03 12:00:00”
	
	public OrderVO(){

	}
	// 完整的orderVO
	public OrderVO (String orderId,String clientId,String clientName,String clientPhone,VIPType vipType,
			String orderDate,OrderType orderType,String hotelName,String hotelId,double price,ArrayList <String> strategies,
			String roomType,int roomNum,int days,String anticipateArrivedTime,String actualArrivedTime,
			String anticipateLeaveTime){
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
		this.roomType=roomType;
		this.roomNum=roomNum;
		this.days=days;
		this.anticipateArrivedTime=anticipateArrivedTime;
		this.actualArrivedTime=actualArrivedTime;
		this.anticipateLeaveTime=anticipateLeaveTime;
	}
	// 旧orderVO
	public OrderVO (String orderId,String clientId,String clientName,String clientPhone,VIPType vipType,
			String orderDate,OrderType orderType,String hotelName,
			String hotelId,double price,ArrayList <String> strategies){
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
	public String getLeaveDate() {
		return anticipateLeaveTime;
	}
	public void setLeaveDate(String anticipateLeaveTime) {
		this.anticipateLeaveTime = anticipateLeaveTime;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getAnticipateArrivedTime() {
		return anticipateArrivedTime;
	}
	public void setAnticipateArrivedTime(String anticipateArrivedTime) {
		this.anticipateArrivedTime = anticipateArrivedTime;
	}
	public String getActualArrivedTime() {
		return actualArrivedTime;
	}
	public void setActualArrivedTime(String actualArrivedTime) {
		this.actualArrivedTime = actualArrivedTime;
	}
	public String getAnticipateLeaveTime() {
		return anticipateLeaveTime;
	}
	public void setAnticipateLeaveTime(String anticipateLeaveTime) {
		this.anticipateLeaveTime = anticipateLeaveTime;
	}
}
