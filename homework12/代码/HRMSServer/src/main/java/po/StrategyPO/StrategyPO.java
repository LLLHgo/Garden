package po.StrategyPO;

import java.io.Serializable;
import java.util.Calendar;

import Enum.StrategyMaker;

public class  StrategyPO  implements Serializable{

	private static final long serialVersionUID = 1L;
    private String name;
    private Calendar startTime;
    private Calendar endTime;
    private StrategyMaker makerType;

	public StrategyPO(String name,Calendar startTime,Calendar endTime,StrategyMaker makerType){
		this.name=name;
		this.startTime=startTime;
		this.endTime=endTime;
		this.makerType=makerType;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Calendar getStartTime() {
		return startTime;
	}
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	public StrategyMaker getMakerType() {
		return makerType;
	}
	public void setMakerType(StrategyMaker makerType) {
		this.makerType = makerType;
	}
	public Calendar getEndTime() {
		return endTime;
	}
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

}


















