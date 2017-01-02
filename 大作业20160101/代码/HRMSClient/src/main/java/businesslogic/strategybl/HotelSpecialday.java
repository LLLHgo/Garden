package businesslogic.strategybl;

import po.StrategyPO.HotelSpecialdayPO;
import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.StrategyPO;

public class HotelSpecialday extends Strategy{

	public double calDis(StrategyPO strt, String ID) {
		if(super.isavailable(strt.getStartTime(), strt.getEndTime())&&ID.equals(((HotelStrategyPO) strt).getHotelID())){
			//满足时间,酒店名字与促销中的名字一致条件
			return ((HotelSpecialdayPO) strt).getDiscount();
		}else{//不满足时间,酒店名字与促销中的名字一致条件
			return 1;
		}
	}



}
