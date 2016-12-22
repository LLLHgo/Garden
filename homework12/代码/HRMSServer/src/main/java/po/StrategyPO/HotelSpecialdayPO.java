package po.StrategyPO;

import java.io.Serializable;
import java.util.Calendar;

import Enum.HotelStrategy;

public class HotelSpecialdayPO extends HotelStrategyPO implements Serializable{

	private static final long serialVersionUID = 1L;

	public HotelSpecialdayPO(String name, Calendar startTime, Calendar endTime,
			String hotelID, double discount) {
		super(name, startTime, endTime, HotelStrategy.SPECIALDAY, hotelID, discount);

	}

}
