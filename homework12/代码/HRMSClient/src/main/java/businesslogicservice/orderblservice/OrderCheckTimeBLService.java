package businesslogicservice.orderblservice;

import java.util.Date;

import vo.orderVO.OrderVO;

public interface OrderCheckTimeBLService {
	/**
	 * 检查时间，判断是否将订单置为异常
	 * @param order
	 * @param date
	 * @return 判断订单置为异常状态（true）或不修改状态（false）的布尔值
	 */
	public boolean checkTimeOperateAbnormal (OrderVO order, String date);
}
