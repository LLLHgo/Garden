package po.StrategyPO;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import Enum.MarketingStrategy;
import Enum.VIPType;

public class MarketingCreatedPO extends MarketingStrategyPO implements Serializable{

	private static final long serialVersionUID = 1L;

	private double discount;
	private List<String> hotels;
	private double minSum;
	private int minRooms;
	private int levels;
	private List<VIPType> viptypes;
	public MarketingCreatedPO(String name, Calendar startTime, Calendar endTime,
			double discount,List<String> hotels,double minSum,int minRooms,int levels,List<VIPType> viptypes) {
		super(name, startTime, endTime, MarketingStrategy.CREATED);
		this.setDiscount(discount);
		this.hotels=hotels;
		this.minSum=minSum;
		this.minRooms=minRooms;
		this.levels=levels;
		this.viptypes=viptypes;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public List<String> getHotels() {
		return hotels;
	}
	public void setHotels(List<String> hotels) {
		this.hotels = hotels;
	}
	public double getMinSum() {
		return minSum;
	}
	public void setMinSum(double minSum) {
		this.minSum = minSum;
	}
	public int getMinRooms() {
		return minRooms;
	}
	public void setMinRooms(int minRooms) {
		this.minRooms = minRooms;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}
	public List<VIPType> getViptypes() {
		return viptypes;
	}
	public void setViptypes(List<VIPType> viptypes) {
		this.viptypes = viptypes;
	}

}
