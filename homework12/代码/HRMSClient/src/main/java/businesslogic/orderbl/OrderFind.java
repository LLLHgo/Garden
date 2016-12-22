package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;


import Enum.OrderType;
import Enum.ResultMessage;
import businesslogicservice.orderblservice.OrderFindBLService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice.OrderDataService_Stub;
import po.OrderPO;
import rmi.RemoteHelper;
import vo.orderVO.OrderVO;

public class OrderFind implements OrderFindBLService{
	OrderDataService orderDateService;
	PackageTransform packageTrans;
	// 用来判断vo中信息是否完整的vo包
	OrderVO orderVO;
	ResultMessage result;
	boolean resultB;
	ArrayList<OrderPO> orderPOList;
	ArrayList<OrderVO> orderVOList;
	RemoteHelper remote;


	public OrderFind(){
		remote=RemoteHelper.getInstance();
		orderDateService=remote.getOrderDataService();
		packageTrans=new PackageTransform();
		orderPOList=new ArrayList<OrderPO>();
		orderVOList=new ArrayList<OrderVO>();
	}

	// 找到某用户的某个具体订单
	@Override
	public OrderVO findSpecificOrder(String userId, String orderID) {
		// 判断订单号是否在有效范围内
		int idLast = 0;
		try {
			idLast=orderDateService.lookIdValid()-1;
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if(idLast<Integer.parseInt(orderID)){
			return null;
		}
		OrderPO orderfindPO = null;
		try {
			orderfindPO = orderDateService.findSpecificUserOrder(orderID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		OrderVO orderfindVO=packageTrans.POToVO(orderfindPO);
		// 用户是否有权限查看该订单
		// 客户请求，订单是否属于这个客户
		if(orderfindVO.getClientId().equals(userId)){
			return orderfindVO;
		}
		// 酒店请求，订单是否是该酒店的
		else if(orderfindVO.getHotelId().equals(userId)){
			return orderfindVO;
		}
		// 网站营销人员请求，该订单是否是异常的
		else if(orderfindVO.getOrderType().equals(OrderType.ABNORMAL)&&orderID.charAt(0)=='M')
			return orderfindVO;
		else
			return null;
	}

	@Override
	public ArrayList<OrderVO> findUserOrderList(String userID) {

		if(validId(userID)){
			// 调用数据层的数据得到用户的所有订单
			try {
				orderPOList.clear();
				orderPOList=orderDateService.findUserOrderList(userID);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(orderPOList!=null){
				orderVOList.clear();
				for(int i=0;i<orderPOList.size();i++){
					orderVOList.add(packageTrans.POToVO(orderPOList.get(i)));
				}
				return orderVOList;
			}
		}
			return null;
		}
		// 查找用户某天的所有订单
		@Override
		public ArrayList<OrderVO> findSpecificDayClientOrderList(String clientId, String date) {
			// TODO Auto-generated method stub
			String findDate=date+" 12:00:00";
			if(validId(clientId)&&clientId.charAt(0)=='C'&&validDate(date)){

			try {
				orderPOList.clear();
				orderPOList=orderDateService.findSpecificDayClientOrderList(clientId, findDate);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(orderPOList!=null){
				orderVOList.clear();
				for(int i=0;i<orderPOList.size();i++){
					orderVOList.add(packageTrans.POToVO(orderPOList.get(i)));
				}
				return orderVOList;
			}
			else
				return null;
			}
			return null;
		}
		// 查看一个用户在某酒店的所有订单
		@Override
		public ArrayList<OrderVO> findSpecificHotelClientOrderList(String clientId, String hotelId) {
			// 如果帐号格式合法，则去数据库中查找
			if(validId(clientId)&&validId(hotelId)&&clientId.charAt(0)=='C'&&hotelId.charAt(0)=='H'){
				try {
					orderPOList.clear();
					orderPOList=orderDateService.findClientInHotelAllOrderList(clientId, hotelId);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				if(orderPOList!=null){
					orderVOList.clear();
					for(int i=0;i<orderPOList.size();i++){
						orderVOList.add(packageTrans.POToVO(orderPOList.get(i)));
					}
					return orderVOList;
				}
			}
			return null;
		}
	   // 查找客户的某种类型订单
		@Override
		public ArrayList<OrderVO> findClientTypeOrderList(OrderType type, String clientId) {
			// 如果帐号格式合法，则去数据库中查找
			if(validId(clientId)&&clientId.charAt(0)=='C'){
				orderPOList.clear();
				try {
					orderPOList=orderDateService.findClientTypeOrderList(type, clientId);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				if(orderPOList!=null){
					orderVOList.clear();
					for(int i=0;i<orderPOList.size();i++){
						orderVOList.add(packageTrans.POToVO(orderPOList.get(i)));
					}
					return orderVOList;
				}
			}
			return null;
		}
		// 查找某酒店的某种类型订单
		@Override
		public ArrayList<OrderVO> findHotelTypeOrderList(OrderType type, String hotelId) {
			// 如果酒店帐号合法，则去数据库中查找
			if(validId(hotelId)&&hotelId.charAt(0)=='H'){
				orderPOList.clear();
				try {
					orderPOList=orderDateService.findHotelTypeOrderList(type, hotelId);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				if(orderPOList!=null){
					orderVOList.clear();
					for(int i=0;i<orderPOList.size();i++){
						orderVOList.add(packageTrans.POToVO(orderPOList.get(i)));
					}
					return orderVOList;
				}
			}
			return null;
		}
		// 在数据库中查找某天的异常订单
		@Override
		public ArrayList<OrderVO> findAbnormalOrderList(String date) {
			// TODO Auto-generated method stub
			
			if(validDate(date)){
				String findDate=date+" 12:00:00";
				try {
					orderPOList.clear();
					orderPOList=orderDateService.findAbnormalOrderList(findDate);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				if(orderPOList!=null){
					orderVOList.clear();
					for(int i=0;i<orderPOList.size();i++){
						orderVOList.add(packageTrans.POToVO(orderPOList.get(i)));
					}
					return orderVOList;
				}
			}
			return null;
		}
		// 判断帐号的长度、第1位是否为合法字母、第2-8位是否为数字
		boolean validId(String str){
			if(str.length()!=9)
				return false;
			char firstC=str.charAt(0);
			if(firstC!='H'&&firstC!='M'&&firstC!='S'&&firstC!='C')
				return false;
			for(int i=1;i<9;i++){
				if(str.charAt(i)-'0'>9||str.charAt(i)-'0'<0)
					return false;
			}
			return true;
		}
		// 判断日期是否符合规范
		boolean validDate(String date){
			String[] dateStr=date.split("-");
			if(dateStr.length!=3)
				return false;
			else if(dateStr[0].length()!=4)
				return false;
			else if(dateStr[1].length()!=2)
				return false;
			else if(dateStr[2].length()!=2)
				return false;
			return true;
		}
}
