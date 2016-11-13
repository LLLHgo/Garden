package businesslogic.orderbl;

import java.util.Date;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import vo.orderVO.OrderVO;

public class OrderManage implements OrderBLService{

	@Override
	public ResultMessage createOrder(OrderVO orderInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage saveOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO findSpecificOrderList(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> findUserOrderList(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> findSpecificDayClientOrder(String clientId, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> findSpecificHotelClientOrder(String clientId, String hoteIId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> findClientTypeOrder(OrderType type, String clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO findSpecificHotelOrder(String hotelId, String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> findAbnormalOrderList(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkTime(OrderVO order, Date date) {
		// TODO Auto-generated method stub
		return false;
	}

}
