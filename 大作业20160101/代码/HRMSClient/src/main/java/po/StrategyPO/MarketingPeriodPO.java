package po.StrategyPO;

import java.io.Serializable;
import java.util.Calendar;

import Enum.MarketingStrategy;

public class MarketingPeriodPO extends MarketingStrategyPO implements Serializable{

	private static final long serialVersionUID = 1L;

	private double discount;
	public MarketingPeriodPO(String name, Calendar startTime, Calendar endTime,double discount) {
		super(name, startTime, endTime,MarketingStrategy.PERIOD);
		this.setDiscount(discount);
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
