package presentation.client.controller;

import java.util.ArrayList;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogic.hoteinfobl.Hotelinfo;
import businesslogic.orderbl.OrderFind;
import businesslogic.orderbl.OrderOperator;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.orderblservice.OrderFindBLService;
import businesslogicservice.orderblservice.OrderOperatorBLService;
import vo.orderVO.OrderVO;
/**
 * 评价界面控制器
 * @author ClaraLee
 *
 */
public class EvaluatePanelController {
	HotelinfoBLService hotelInfo=new Hotelinfo();
	OrderFindBLService orderfind=new OrderFind();
	OrderOperatorBLService orderop=new OrderOperator();
	public ArrayList<OrderVO> findClientFinOrderList( String clientId){
		return orderfind.findClientTypeOrderList(OrderType.NORMALEXEC,clientId);
	}
	public ArrayList<OrderVO> findClientTypeOrderList(OrderType type, String clientId){
		return orderfind.findClientTypeOrderList(type, clientId);
	}
	public boolean setEvaluate(int star,String str,String clientID,String hotelID){
		return hotelInfo.setEvaluate(star,str,clientID,hotelID);
	}
	public ResultMessage saveOrderPO(OrderVO orderVO) {
		return orderop.saveOrderPO(orderVO);
	}
}
