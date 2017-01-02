package businesslogicservice.orderblservice;
import Enum.ResultMessage;
import vo.orderVO.OrderVO;
/**
 * 订单模块的操作订单类OrderOperator的bl层接口
 * @author yilu
 *
 */
public interface OrderOperatorBLService {
	/**
	 * 下订单
	 * @param orderInfo
	 * @return 创建订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage createOrderPO (OrderVO orderInfo);
	/**
	 * 保存订单
	 * @param order
	 * @return 保存订单成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage saveOrderPO (OrderVO order);
	/**
	 * 取消订单
	 * @param orderId
	 * @return 置订单于取消状态成功（Success）或是失败（fail）的ResultMessage值
	 */
	public ResultMessage cancelOrderPO (String orderId);


}
