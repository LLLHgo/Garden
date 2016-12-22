package vo.strategyVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Enum.HotelStrategy;
import Enum.VIPType;

public class HotelStrategyVO {
	//策略的名字
	private String name;
	//酒店工作人员制定的策略的种类，有enum：hotelStrategy{BIRTHDAY,COMPANY,SPECIALDAY,OVERTHREEROOMS;}
    private HotelStrategy type;
    //活动开始时间
    private Calendar startTime;
    //活动结束时间
    private Calendar endTime;
    //会员类型
    private VIPType viptype;
    //活动折扣
    private double discount;
    //设置策略的酒店ID
    private String hotelID;
    //享受折扣的最低消费金额
    private int minSum;
    //享受折扣的最少房间数
    private int minRooms;
    //参加活动的会员种类
    private  List<VIPType> vipKinds;

    public HotelStrategyVO(){
    }

    /**
     * 酒店工作人员制定会员生日特惠折扣/合作企业特惠折扣
     * @param hotelID
     * @param type
     * @param viptype
     * @param startTime
     * @param endTime
     * @param discount
     * @param poster
     * @param position
     */
    public HotelStrategyVO(String name,String hotelID,HotelStrategy type,VIPType viptype,Calendar startTime,Calendar endTime,double discount){
    	this.hotelID=hotelID;
    	this.type=type;
    	this.viptype=viptype;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.discount=discount;
    	this.name=name;

    }

    /**
     * 酒店工作人员制定特定期间优惠
     * @param hotelID
     * @param type
     * @param startTime
     * @param endTime
     * @param discount
     * @param poster
     * @param position
     */
    public HotelStrategyVO(String name,String hotelID,HotelStrategy type,Calendar startTime,Calendar endTime,double discount){
    	this.hotelID=hotelID;
    	this.type=type;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.discount=discount;
    	this.name=name;

    }

    /**
     * 酒店工作人员制定三间及三间以上房间优惠
     * @param hotelID
     * @param type
     * @param startTime
     * @param endTime
     * @param discount
     * @param poster
     * @param position
     * @param minRooms
     */
    public HotelStrategyVO(String name,String hotelID,HotelStrategy type,Calendar startTime,Calendar endTime,double discount,
    		int minRooms){
    	this.hotelID=hotelID;
    	this.type=type;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.discount=discount;

    	this.minRooms = minRooms;
    	this.name=name;
    }

    public HotelStrategyVO(String name,String hotelID,HotelStrategy type,List<VIPType> vipKinds,Calendar startTime,Calendar endTime,double discount,
    		int minRooms,int minSum){
    	this.hotelID=hotelID;
    	this.type=type;
    	this.vipKinds=vipKinds;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.discount=discount;
    	this.name=name;

    	this.minRooms = minRooms;
    	this.minSum = minSum;
    }

	public HotelStrategy getType() {
		return type;
	}

	public void setType(HotelStrategy type) {
		this.type = type;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public VIPType getViptype() {
		return viptype;
	}

	public void setViptype(VIPType viptype) {
		this.viptype = viptype;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}


	public int getMinSum() {
		return minSum;
	}

	public void setMinSum(int minSum) {
		this.minSum = minSum;
	}

	public int getMinRooms() {
		return minRooms;
	}

	public void setMinRooms(int minRooms) {
		this.minRooms = minRooms;
	}

	public List<VIPType> getVipKinds() {
		return vipKinds;
	}

	public void setVipKinds(List<VIPType> vipKinds) {
		this.vipKinds = vipKinds;
	}
}
