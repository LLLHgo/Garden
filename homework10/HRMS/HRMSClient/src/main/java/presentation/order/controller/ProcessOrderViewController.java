package presentation.order.controller;

import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogic.orderbl.OrderManage;
import businesslogicservice.logblservice.LogBLService;
import businesslogicservice.orderblservice.OrderBLService;
import presentation.order.view.ProcessOrderViewControllerService;
import vo.orderVO.OrderVO;

public class ProcessOrderViewController implements ProcessOrderViewControllerService{
	
	private OrderBLService orderBLService;
	private LogBLService logBLService;
	
	public ProcessOrderViewController(){
		orderBLService=new OrderManage();
		//logBLService=new LogBLService();
		
	}

	
	public ResultMessage createOrder(OrderVO orderInfo) {
		return orderBLService.createOrder(new OrderVO());
	}

	public ResultMessage saveOrder(OrderVO order) {
		return null;
	}

	
	public ResultMessage cancelOrder(String orderId) {
		return null;
	}

	
	public OrderVO findSpecificOrderList(String orderID) {
		return null;
	}

	public List<OrderVO> findUserOrderList(String userID) {
		return null;
	}

	public List<OrderVO> findSpecificDayClientOrder(String clientId, Date date) {
		return null;
	}

	public List<OrderVO> findSpecificHotelClientOrder(String clientId, String hoteIId) {
		return null;
	}

	public List<OrderVO> findUserTypeOrder(OrderType type, String userId) {
		return null;
	}

	public OrderVO findSpecificHotelOrder(String hotelId, String orderId) {
		return null;
	}

	public List<OrderVO> findAbnormalOrderList(Date date) {
		return null;
	}

	public boolean checkTime(String orderId, Date date) {
		return false;
	}

	public boolean addLog(String logInfo) {
		return false;
	}

}
