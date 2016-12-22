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
import vo.hotelinfoVO.HotelinfoVO;
import vo.orderVO.OrderVO;

public class EvaluatePanelController {
	HotelinfoBLService hotelInfo=new Hotelinfo();
	OrderFindBLService orderfind=new OrderFind();
	public ArrayList<OrderVO> findClientFinOrderList( String clientId){
		return orderfind.findClientTypeOrderList(OrderType.NORMALEXEC,clientId);
	}
	public ArrayList<OrderVO> findClientTypeOrderList(OrderType type, String clientId){
		return orderfind.findClientTypeOrderList(type, clientId);
	}
}
