package presentation.client.controller;

import java.util.ArrayList;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogic.orderbl.OrderFind;
import businesslogic.orderbl.OrderOperator;
import businesslogicservice.orderblservice.OrderFindBLService;
import businesslogicservice.orderblservice.OrderOperatorBLService;
import vo.hotelinfoVO.HotelinfoVO;
import vo.orderVO.OrderVO;

public class ViewOrderPanelController {
	OrderOperatorBLService orderOp=new OrderOperator();
	OrderFindBLService orderFind=new OrderFind();
	public ArrayList<OrderVO> findUserOrderList(String userID) {
		return orderFind.findUserOrderList(userID);
	}
	public ArrayList<OrderVO> findSpecificDayClientOrderList(String clientId, String date) {
		return orderFind.findSpecificDayClientOrderList(clientId,date);
	}
	public ArrayList<OrderVO> findSpecificHotelClientOrderList(String clientId, String hotelId) {
		return orderFind.findSpecificHotelClientOrderList(clientId, hotelId);
	}
	public ArrayList<OrderVO> findClientTypeOrderList(OrderType type, String clientId){
		return orderFind.findClientTypeOrderList(type, clientId);
	}
	public ResultMessage cancelOrderPO(String orderId) {
		return orderOp.cancelOrderPO(orderId);
	}
}
