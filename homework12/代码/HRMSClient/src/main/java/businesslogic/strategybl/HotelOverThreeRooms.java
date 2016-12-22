package businesslogic.strategybl;

import po.StrategyPO.HotelOverThreeRoomsPO;
import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.StrategyPO;

public class HotelOverThreeRooms extends Strategy{

	public double calDis(StrategyPO strt, String ID,int num) {
		if(super.isavailable(strt.getStartTime(), strt.getEndTime())&&ID.equals(((HotelStrategyPO) strt).getHotelID())&&
				num>=((HotelOverThreeRoomsPO) strt).getMinRooms()){
			//满足时间,酒店名字与促销中的名字一致,房间数超过最小房间数条件
			return ((HotelOverThreeRoomsPO) strt).getDiscount();
		}else{//不满足时间,酒店名字与促销中的名字一致，,房间数超过最小房间数条件
			return 1;
		}
	}



}
