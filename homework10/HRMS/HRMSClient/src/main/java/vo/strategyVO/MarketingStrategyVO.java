package vo.strategyVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Enum.*;

public class MarketingStrategyVO {
	//活动名称
	private String name;
	//网站营销人员制定的策略的种类，有enum：marketingStrategy{DOUBLE11,VIPSPECIAL,CRATEDE;}
    private marketingStrategy type;
    //活动开始时间
    private Calendar startTime;
    //活动结束时间
    private Calendar endTime;
    //活动折扣
    private double discount;
    //参加VIP特定专属商圈的商圈
    private String businessDistrict;
    //参加VIP特定专属商圈折扣的商圈
    private List<String> businessArea;
    //参加参加VIP特定专属商圈的等级
    private int[] levels;
  //参加参加VIP特定专属商圈的等级对应的折扣
    private double[] discounts;
    //参加活动的酒店
    private List<String> hotels;
    //享受折扣的最低消费金额
    private double minSum;
    //享受折扣的最少房间数
    private int minRooms;
    //参加活动的最低会员等级
    private int minLevel;
    //参加活动的会员种类
    private List<VIPType> vipKinds;

    /**
     * 空的构造函数
     *
     */
    public MarketingStrategyVO(){

    }

    /**
     * 营销人员制定特定时间促销策略
     *
     * @param type  网站营销人员制定的策略的种类，这里为DOUBLE11
     * @param startTime 活动开始时间
     * @param endTime 活动结束时间
     * @param discount 活动折扣
     * @param hotels 参加活动的酒店
     * @param poster 活动海报
     * @param position 活动海报显示在客户界面的位置
     */
    public MarketingStrategyVO(String name,marketingStrategy type,Calendar startTime,
    		Calendar endTime,double discount){
    	this.name=name;
    	this.type=type;
    	this.setStartTime(startTime);
    	this.setEndTime(endTime);
    	this.discount=discount;
    }

    /**
     * 网站营销人员制定的VIP特定商圈折扣
     *
     * @param type  网站营销人员制定的策略的种类，这里为VIPSPECIAL
     * @param startTime
     * @param endTime
     * @param discount
     * @param poster
     * @param businessArea
     * @param position
     */
    public MarketingStrategyVO(String name,marketingStrategy type,Calendar startTime,
    		Calendar endTime,String businessDistrict,int[] levels,double[] discounts){
    	this.name=name;
    	this.type=type;
    	this.setStartTime(startTime);
    	this.setEndTime(endTime);
    	this.setBusinessDistrict(businessDistrict);
    	this.setLevels(levels);
    	this.setDiscounts(discounts);

    }

    /**
     *
     * @param type    网站营销人员制定的策略的种类，这里为CREATED
     * @param startTime
     * @param endTime
     * @param discount
     * @param hotels
     * @param businessArea
     * @param poster
     * @param position
     * @param minSum
     * @param minRooms
     * @param levels
     * @param vipKinds
     */
    public MarketingStrategyVO(String name,marketingStrategy type,Calendar startTime,Calendar endTime,double discount,List<String> hotels,
    		double minSum,int minRooms,int levels,List<VIPType> viptypes){
    	this.name=name;
    	this.type=type;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.discount=discount;
    	this.hotels=hotels;
    	this.minSum=minSum;
    	this.minRooms=minRooms;
    	this.setMinLevel(levels);
    	this.vipKinds=viptypes;
    }
	public marketingStrategy getType() {
		return type;
	}
	public void setType(marketingStrategy type) {
		this.type = type;
	}


	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public List<String> getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(ArrayList<String> businessArea) {
		this.businessArea = businessArea;
	}
	public List<String> getHotels() {
		return hotels;
	}
	public void setHotels(ArrayList<String> hotels) {
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


	public List<VIPType> getVipKinds() {
		return vipKinds;
	}
	public void setVipKinds(ArrayList<VIPType> vipKinds) {
		this.vipKinds = vipKinds;
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

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public String getBusinessDistrict() {
		return businessDistrict;
	}

	public void setBusinessDistrict(String businessDistrict) {
		this.businessDistrict = businessDistrict;
	}



	public double[] getDiscounts() {
		return discounts;
	}

	public void setDiscounts(double[] discounts) {
		this.discounts = discounts;
	}

	public int[] getLevels() {
		return levels;
	}

	public void setLevels(int[] levels) {
		this.levels = levels;
	}

	public int getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(int minLevel) {
		this.minLevel = minLevel;
	}


}
