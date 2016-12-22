package po.StrategyPO;

import java.io.Serializable;
import java.util.Calendar;

import Enum.StrategyMaker;
import Enum.MarketingStrategy;

public class MarketingStrategyPO extends StrategyPO implements Serializable{

	private static final long serialVersionUID = 1L;
	private MarketingStrategy marketingStrategyType;

    public MarketingStrategyPO(String name, Calendar startTime, Calendar endTime,MarketingStrategy marketingStrategyType) {
		super(name, startTime, endTime, StrategyMaker.MARKTING);
		this.setMarketingStrategyType(marketingStrategyType);
	}

	public MarketingStrategy getMarketingStrategyType() {
		return marketingStrategyType;
	}

	public void setMarketingStrategyType(MarketingStrategy marketingStrategyType) {
		this.marketingStrategyType = marketingStrategyType;
	}
}
