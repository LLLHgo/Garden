package businesslogic.orderbl;

import po.OrderPO;
import vo.orderVO.OrderVO;
/**
 * 订单vo包和po包之间的转化
 * @author yilu
 *
 */
public class PackageTransform {
	// 将orderVO解包，制作orderPO包
		public OrderPO VOToPO(OrderVO orderVO){

			OrderPO po=new OrderPO(orderVO.getOrderId(),orderVO.getClientId(),orderVO.getClientName(),orderVO.getClientPhone(),
					orderVO.getVipType(),orderVO.getOrderDate(),orderVO.getOrderType(),orderVO.getHotelName(),orderVO.getHotelId(),
					orderVO.getPrice(),orderVO.getStrategies(),orderVO.getRoomType(),orderVO.getRoomNum(),orderVO.getDays(),
					orderVO.getAnticipateArrivedTime(),orderVO.getActualArrivedTime(),orderVO.getAnticipateLeaveTime(),orderVO.getPrePrice()
					,orderVO.iseValuate());
			return po;
		}
		// 将orderPO解包，制作orderVO包
		public OrderVO POToVO(OrderPO po){
				OrderVO vo=new OrderVO(po.getOrderId(),po.getClientId(),po.getClientName(),po.getClientPhone(),
						po.getVipType(),po.getOrderDate(),po.getOrderType(),po.getHotelName(),po.getHotelId(),
						po.getPrice(),po.getStrategies(),po.getRoomType(),po.getRoomNum(),po.getDays(),
						po.getAnticipateArrivedTime(),po.getActualArrivedTime(),po.getAnticipateLeaveTime()
						,po.getPrePrice(),po.iseValuate());
				return vo;
		}

}
