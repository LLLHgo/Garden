package presentation.client.controller;

import java.util.ArrayList;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogic.clientbl.ClientManage;
import businesslogic.orderbl.OrderFind;
import businesslogic.orderbl.OrderOperator;
import businesslogicservice.clientblservice.ClientBLService;
import businesslogicservice.orderblservice.OrderFindBLService;
import businesslogicservice.orderblservice.OrderOperatorBLService;
import vo.orderVO.OrderVO;
/**
 * 浏览订单界面控制器
 * @author ClaraLee
 *
 */
public class ViewOrderPanelController {
	ClientBLService client=new ClientManage();
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
	public boolean setCredit(String clientID, int recharge,String date,String reason){
		return client.setCredit(clientID,recharge,date,reason);
	}
}
