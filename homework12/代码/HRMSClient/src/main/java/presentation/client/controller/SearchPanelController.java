package presentation.client.controller;

import java.util.ArrayList;

import Enum.ResultMessage;
import businesslogic.hoteinfobl.Hotelinfo;
import businesslogic.orderbl.OrderOperator;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.orderblservice.OrderOperatorBLService;

import vo.hotelinfoVO.HotelinfoVO;
import vo.orderVO.OrderVO;

public class SearchPanelController {
HotelinfoBLService hotelInfo=new Hotelinfo();
OrderOperatorBLService order=new OrderOperator();
	public HotelinfoVO getBasicinfo(String hotelID) {
	return hotelInfo.getBasicinfo(hotelID);
}
	public ArrayList<HotelinfoVO> getBasicinfoList(String str) {
		return hotelInfo.getBasicinfoList(str);
	}
	public ResultMessage createOrderPO(OrderVO orderVO) {
		return order.createOrderPO(orderVO);
	}
}
