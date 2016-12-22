package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Enum.OrderType;
import Enum.VIPType;
import dataservice.orderdataservice.OrderDataService;
import initial.DataBaseInit;
import po.OrderPO;

public class OrderDataServiceMySqlImpl extends UnicastRemoteObject implements OrderDataService{

	private static final long serialVersionUID = 1L;
	Statement stmt;
	Connection conn;

	public OrderDataServiceMySqlImpl() throws RemoteException {
		super();
		conn=DataBaseInit.getConnection();
	}
	// 获取当前可用的新增id值
	public int lookIdValid() throws RemoteException {
		int id=0;
		ResultSet rs;
		String sql="SELECT MAX(id) as id FROM orders";
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				id=rs.getInt("id");
			}
			return id+1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	// 添加账户
	public boolean add(OrderPO orderPO) throws RemoteException {
		String strategy="";
		for(int i=0;i<orderPO.getStrategies().size();i++){
			strategy=strategy+orderPO.getStrategies().get(i)+" ";
		}
		String sql="INSERT INTO orders (order_id,client_id,client_name,client_phone,vip_type,order_date,order_type,hotel_name,hotel_id,price,strategy,room_type,room_number,days,anticipate_arrived_time,actual_arrived_time,anticipate_leave_time) VALUES ('"+orderPO.getOrderId()+"','"+orderPO.getClientId()+"','"+orderPO.getClientName()+"','"+orderPO.getClientPhone()+"','"+orderPO.getOrderType()+"','"+orderPO.getOrderDate()+"','"+orderPO.getOrderType()+"','"+orderPO.getHotelName()+"','"+orderPO.getHotelId()+"','"+orderPO.getPrice()+"','"+strategy+"','"+orderPO.getRoomType()+"','"+orderPO.getRoomNum()+"','"+orderPO.getDays()+"','"+orderPO.getAnticipateArrivedTime()+"','"+orderPO.getActualArrivedTime()+ "','"+orderPO.getAnticipateLeaveTime()+"')";
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// 保存订单
	public boolean save(OrderPO orderPO) throws RemoteException {
		//UPDATE table_anem SET column_name1 = value1, column_name2 = value2, ...
				//WHERE ... ;
		String strategy="";
		for(int i=0;i<orderPO.getStrategies().size();i++){
			strategy=strategy+orderPO.getStrategies().get(i)+" ";
		}
		String sql="UPDATE orders SET client_id='"+orderPO.getClientId()+"',client_name='"+orderPO.getClientName()+"',client_phone='"+orderPO.getClientPhone()+"',vip_type='"+orderPO.getVipType()+"',order_date='"+orderPO.getOrderDate()+"',order_type='"+orderPO.getOrderType()+"',hotel_name='"+orderPO.getHotelName()+"',hotel_id='"+orderPO.getHotelId()+"',price='"+orderPO.getPrice()+"',strategy='"+strategy+"',room_type='"+orderPO.getRoomType()+"',room_number='"+orderPO.getRoomNum()+"',days='"+orderPO.getDays()+"',anticipate_arrived_time='"+orderPO.getAnticipateArrivedTime()+"',actual_arrived_time='"+orderPO.getActualArrivedTime()+"',anticipate_leave_time='"+orderPO.getAnticipateLeaveTime()+"' WHERE order_id='"+orderPO.getOrderId()+"'";
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// 取消某一帐号的订单
	public boolean cancel(String orderId) throws RemoteException {
		String sql="UPDATE orders SET order_type='"+OrderType.CANCEL+"' WHERE order_id='"+orderId+"'";
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	// 找到某用户的某一订单号的订单
	public OrderPO findSpecificUserOrder(String orderId) throws RemoteException {
		String sql="SELECT order_id,client_id,client_name,client_phone,vip_type,order_date,order_type,hotel_name,hotel_id,price,strategy,room_type,room_number,days,anticipate_arrived_time,actual_arrived_time,anticipate_leave_time FROM orders WHERE order_id='"+orderId+"'";
		ResultSet rs;
		OrderPO orderPO=null;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				orderPO=createOrderPO(rs);
			}
			return orderPO;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// 查找具体某天的客户订单列表
	public ArrayList<OrderPO> findSpecificDayClientOrderList(String clientId, String date) throws RemoteException {
		String sql="SELECT order_id,client_id,client_name,client_phone,vip_type,order_date,order_type,hotel_name,hotel_id,price,strategy,room_type,room_number,days,anticipate_arrived_time,actual_arrived_time,anticipate_leave_time FROM orders WHERE client_id='"+clientId+"'AND anticipate_arrived_time='"+date+"'";
		return getCommandList(sql);
	}
	// 找到某用户（客户、酒店、网站营销人员的所有订单）
	public ArrayList<OrderPO> findUserOrderList(String userId) throws RemoteException {
		String sql="";
		if(userId.charAt(0)=='C'){
			sql="SELECT order_id,client_id,client_name,client_phone,vip_type,order_date,order_type,hotel_name,hotel_id,price,strategy,room_type,room_number,days,anticipate_arrived_time,actual_arrived_time,anticipate_leave_time FROM orders WHERE client_id='"+userId+"'";
		}
		else if(userId.charAt(0)=='H'){
			sql="SELECT order_id,client_id,client_name,client_phone,vip_type,order_date,order_type,hotel_name,hotel_id,price,strategy,room_type,room_number,days,anticipate_arrived_time,actual_arrived_time,anticipate_leave_time FROM orders WHERE hotel_id='"+userId+"'";
		}
		else if(userId.charAt(0)=='M'){
			sql="SELECT order_id,client_id,client_name,client_phone,vip_type,order_date,order_type,hotel_name,hotel_id,price,strategy,room_type,room_number,days,anticipate_arrived_time,actual_arrived_time,anticipate_leave_time FROM orders WHERE order_type='ABNORMAL'";
		}
		return getCommandList(sql);
	}
	// 查找客户某一种类订单
	public ArrayList<OrderPO> findClientTypeOrderList(OrderType orderType, String clientId) throws RemoteException {

		String sql="SELECT order_id,client_id,client_name,client_phone,vip_type,order_date,order_type,hotel_name,hotel_id,price,strategy,room_type,room_number,days,anticipate_arrived_time,actual_arrived_time,anticipate_leave_time FROM orders WHERE client_id='"+clientId+"'AND order_type='"+orderType+"'";
		return getCommandList(sql);
	}
	// 查找某酒店的某种类型订单
	public ArrayList<OrderPO> findHotelTypeOrderList(OrderType orderType, String hotelId) throws RemoteException {
		String sql="SELECT order_id,client_id,client_name,client_phone,vip_type,order_date,order_type,hotel_name,hotel_id,price,strategy,room_type,room_number,days,anticipate_arrived_time,actual_arrived_time,anticipate_leave_time FROM orders WHERE hotel_id='"+hotelId+"'AND order_type='"+orderType+"'";
		return getCommandList(sql);
	}
	// 查找某客户在某酒店的所有订单
	public ArrayList<OrderPO> findClientInHotelAllOrderList(String clientId, String hotelId) throws RemoteException {
		String sql="SELECT order_id,client_id,client_name,client_phone,vip_type,order_date,order_type,hotel_name,hotel_id,price,strategy,room_type,room_number,days,anticipate_arrived_time,actual_arrived_time,anticipate_leave_time FROM orders WHERE hotel_id='"+hotelId+"'AND client_id='"+clientId+"'";
		return getCommandList(sql);
	}
	// 找到指定时间下的当天所有异常订单
	public ArrayList<OrderPO> findAbnormalOrderList(String date) throws RemoteException {
		String sql="SELECT order_id,client_id,client_name,client_phone,vip_type,order_date,order_type,hotel_name,hotel_id,price,strategy,room_type,room_number,days,anticipate_arrived_time,actual_arrived_time,anticipate_leave_time FROM orders WHERE anticipate_arrived_time='"+date+"'AND order_type='ABNORMAL'";
		return getCommandList(sql);
	}
	
	// 根据resultset信息创建po
	OrderPO createOrderPO(ResultSet rs){
		OrderPO po = null;
		// 处理策略问题
		ArrayList<String> strategy=new ArrayList<String>();
		String[] strs = null;
		String strategyString = null;
		String actual_arrived_time = null;
		String order_type=null;
		String vip_type=null;
		OrderType orderTypeEnum = null;
		VIPType vipTypeEnum = null;
		try {
			strategyString = rs.getString("strategy");
			actual_arrived_time = rs.getString("actual_arrived_time");
			order_type=rs.getString("order_type");
			vip_type=rs.getString("vip_type");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(strategyString!=null){
			strs=strategyString.split(" ");
			for(int i=0;i<strs.length;i++){
				strategy.add(strs[i]);
			}
		}
		//  处理实际到达时间一栏为空的情况
		if(actual_arrived_time==null){
			actual_arrived_time="";
		}
		// 处理ordertype的enum值
		if(order_type.equals("NORMALNONEXEC"))
			orderTypeEnum=OrderType.NORMALNONEXEC;
		else if(order_type.equals("NORMALEXEC"))
			orderTypeEnum=OrderType.NORMALEXEC;
		else if(order_type.equals("CANCEL"))
			orderTypeEnum=OrderType.CANCEL;
		else if(order_type.equals("ABNORMAL"))
			orderTypeEnum=OrderType.ABNORMAL;
		// 处理viptype的enum值
		if(vip_type.equals("ORDINARYVIP"))
			vipTypeEnum=VIPType.ORDINARYVIP;
		else if(vip_type.equals("ENTERPRISEVIP"))
			vipTypeEnum=VIPType.ENTERPRISEVIP;
		// 生成po
		try {
			po=new OrderPO(rs.getString("order_id"),rs.getString("client_id"),rs.getString("client_name"),rs.getString("client_phone"),vipTypeEnum,rs.getString("order_date"),orderTypeEnum,rs.getString("hotel_name"),rs.getString("hotel_id"),rs.getDouble("price"),strategy,rs.getString("room_type"),rs.getInt("room_number"),rs.getInt("days"),rs.getString("anticipate_arrived_time"),actual_arrived_time,rs.getString("anticipate_leave_time"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}
	// 根据sql语句执行，并将结果放在arraylist中返回
	ArrayList<OrderPO> getCommandList(String sql){
		ResultSet rs;
		OrderPO orderPO=null;
		ArrayList<OrderPO> list=new ArrayList<OrderPO>();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				orderPO=createOrderPO(rs);
				list.add(orderPO);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void checkTimeOperateAbnormal(String orderId) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


}
