package po.StrategyPO;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import Enum.HotelStrategy;
import Enum.VIPType;

public class HotelCreatedPO extends HotelStrategyPO implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<VIPType> viptypes;
	private int minRooms;
	private double minSum;
	private int levels;

	public HotelCreatedPO(String name, Calendar startTime, Calendar endTime,
			String hotelID, double discount,List<VIPType> viptypes,int minRooms,double minSum,int level) {
		super(name, startTime, endTime,HotelStrategy.CREATED, hotelID, discount);
		this.setViptypes(viptypes);
		this.setMinRooms(minRooms);
		this.setMinSum(minSum);
		this.setLevels(level);
	}
	public int getMinRooms() {
		return minRooms;
	}
	public void setMinRooms(int minRooms) {
		this.minRooms = minRooms;
	}
	public double getMinSum() {
		return minSum;
	}
	public void setMinSum(double minSum) {
		this.minSum = minSum;
	}
	public List<VIPType> getViptypes() {
		return viptypes;
	}
	public void setViptypes(List<VIPType> viptypes) {
		this.viptypes = viptypes;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}


}
