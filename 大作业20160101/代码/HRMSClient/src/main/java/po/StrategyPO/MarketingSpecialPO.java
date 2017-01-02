package po.StrategyPO;

import java.io.Serializable;
import java.util.Calendar;

import Enum.MarketingStrategy;

public class MarketingSpecialPO extends MarketingStrategyPO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String businessDistrict;
	private int[] levels;
	private double[] discounts;

	public MarketingSpecialPO(String name, Calendar startTime, Calendar endTime,
			String businessDistrict,int[] levels,double[] discounts) {
		super(name, startTime, endTime, MarketingStrategy.VIPSPECIAL);
		this.businessDistrict=businessDistrict;
		this.levels=levels;
		this.discounts=discounts;
	}
	public String getBusinessDistrict() {
		return businessDistrict;
	}
	public void setBusinessDistrict(String businessDistrict) {
		this.businessDistrict = businessDistrict;
	}
	public int[] getLevels() {
		return levels;
	}
	public void setLevels(int[] levels) {
		this.levels = levels;
	}
	public double[] getDiscounts() {
		return discounts;
	}
	public void setDiscounts(double[] discounts) {
		this.discounts = discounts;
	}

}
