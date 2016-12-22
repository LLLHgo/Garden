package businesslogic.strategybl;

import po.StrategyPO.MarketingPeriodPO;
import po.StrategyPO.StrategyPO;

public  class MarketingPeriod extends Strategy{
	public double calDis(StrategyPO strt) {
		if(super.isavailable(strt.getStartTime(),strt.getEndTime())){
			return ( (MarketingPeriodPO) strt).getDiscount();
		}else{
			return 1;
		}
	}

}
