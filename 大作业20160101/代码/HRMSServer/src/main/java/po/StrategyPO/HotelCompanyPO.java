package po.StrategyPO;

import java.io.Serializable;
import java.util.Calendar;

import Enum.HotelStrategy;
import Enum.VIPType;

public class HotelCompanyPO extends HotelStrategyPO implements Serializable{

	private static final long serialVersionUID = 1L;

	private VIPType viptype;
	public HotelCompanyPO(String name, Calendar startTime, Calendar endTime,String hotelID,
			double discount) {
		super(name, startTime, endTime,HotelStrategy.COMPANY,hotelID,discount);
		this.setViptype(VIPType.ENTERPRISEVIP);
	}

	public VIPType getViptype() {
		return viptype;
	}
	public void setViptype(VIPType viptype) {
		this.viptype = viptype;
	}


}
