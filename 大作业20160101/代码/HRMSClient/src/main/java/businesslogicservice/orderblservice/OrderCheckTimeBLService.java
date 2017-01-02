package businesslogicservice.orderblservice;

/**
 * 订单模块的OrderCheckTime类的bl层接口
 * @author yilu
 *
 */
public interface OrderCheckTimeBLService {
	/**
	 * 检查时间，判断是否将订单置为异常
	 * @param order
	 * @param date
	 * @return 判断订单置为异常状态（true）或不修改状态（false）的布尔值
	 */
	public boolean checkTimeOperateAbnormal ();
}
