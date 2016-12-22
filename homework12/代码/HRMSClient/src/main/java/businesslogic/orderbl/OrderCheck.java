package businesslogic.orderbl;


import businesslogicservice.orderblservice.OrderCheckTimeBLService;
import vo.orderVO.OrderVO;

public class OrderCheck implements OrderCheckTimeBLService{

	@Override
	public boolean checkTimeOperateAbnormal(OrderVO order, String date) {
		// TODO Auto-generated method stub
		return false;
	}

}
