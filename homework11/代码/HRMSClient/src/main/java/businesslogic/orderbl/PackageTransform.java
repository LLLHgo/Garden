package businesslogic.orderbl;

import po.OrderPO;
import vo.orderVO.OrderVO;

public class PackageTransform {
	// 将orderVO解包，制作orderPO包
		public OrderPO VOToPO(OrderVO vo){
			OrderPO po=new OrderPO(vo.getOrderId(),vo.getClientId(),vo.getClientName(),vo.getClientPhone(),
					vo.getVipType(),vo.getOrderDate(),vo.getOrderType(),vo.getHotelName(),vo.getHotelId(),
					vo.getPrice(),vo.getStrategies(),vo.getRoomType(),vo.getRoomNum(),vo.getDays(),
					vo.getAnticipateArrivedTime(),vo.getActualArrivedTime(),vo.getAnticipateLeaveTime());
			return po;
		}
		// 将orderPO解包，制作orderVO包
		public OrderVO POToVO(OrderPO po){
				OrderVO vo=new OrderVO(po.getOrderId(),po.getClientId(),po.getClientName(),po.getClientPhone(),
						po.getVipType(),po.getOrderDate(),po.getOrderType(),po.getHotelName(),po.getHotelId(),
						po.getPrice(),po.getStrategies(),po.getRoomType(),po.getRoomNum(),po.getDays(),
						po.getAnticipateArrivedTime(),po.getActualArrivedTime(),po.getAnticipateLeaveTime());
				return vo;
		}
		
}
