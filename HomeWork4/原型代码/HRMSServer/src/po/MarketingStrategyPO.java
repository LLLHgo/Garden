package po;

import java.util.ArrayList;
import java.util.Date;

import Enum.*;
import javafx.scene.image.Image;


public class MarketingStrategyPO {
	//网站营销人员制定的策略的种类，有enum：marketingStrategy{DOUBLE11,VIPSPECIAL,CRATEDE;}
    private marketingStrategy type;
    //活动开始时间
    private Date startTime;
    //活动结束时间
    private Date endTime;
    //活动折扣
    private double discount;
    //参加VIP特定专属商圈折扣的商圈
    private ArrayList<String> businessArea;
    //参加活动的酒店
    private ArrayList<HotelinfoPO> hotels;
    //活动海报
    private Image poster;
    //活动海报显示在客户界面的位置
    private String position;
    //享受折扣的最低消费金额
    private int minSum;
    //享受折扣的最少房间数
    private int minRooms;
    //参加活动的最低会员等级
    private LevelPO levels;
    //参加活动的会员种类
    private ArrayList<VIPType> vipKinds;

    /**
     * 空的构造函数
     *
     */
    public MarketingStrategyPO(){

    }

    /**
     * 营销人员制定双十一促销策略
     *
     * @param type  网站营销人员制定的策略的种类，这里为DOUBLE11
     * @param startTime 活动开始时间
     * @param endTime 活动结束时间
     * @param discount 活动折扣
     * @param hotels 参加活动的酒店
     * @param poster 活动海报
     * @param position 活动海报显示在客户界面的位置
     */
    public MarketingStrategyPO(marketingStrategy type,Date startTime,Date endTime,double discount,ArrayList<HotelinfoPO> hotels,
    		Image poster,String position){
    	this.type=type;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.discount=discount;
    	this.hotels=hotels;
    	this.poster=poster;
    	this.position=position;
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
    public MarketingStrategyPO(marketingStrategy type,Date startTime,Date endTime,double discount,Image poster,
    		ArrayList<String> businessArea,String position){
    	this.type=type;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.discount=discount;
    	this.businessArea=businessArea;
    	this.poster=poster;
    	this.position=position;
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
    public MarketingStrategyPO(marketingStrategy type,Date startTime,Date endTime,double discount,ArrayList<HotelinfoPO> hotels,
    		ArrayList<String> businessArea,Image poster,String position,int minSum,int minRooms,LevelPO levels,
    		ArrayList<VIPType> vipKinds){
    	this.type=type;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.discount=discount;
    	this.hotels=hotels;
    	this.businessArea=businessArea;
    	this.poster=poster;
    	this.position=position;
    	this.minSum=minSum;
    	this.minRooms=minRooms;
    	this.levels=levels;
    	this.vipKinds=vipKinds;
    }
	public marketingStrategy getType() {
		return type;
	}
	public void setType(marketingStrategy type) {
		this.type = type;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Image getPoster() {
		return poster;
	}
	public void setPoster(Image poster) {
		this.poster = poster;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public ArrayList<String> getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(ArrayList<String> businessArea) {
		this.businessArea = businessArea;
	}
	public ArrayList<HotelinfoPO> getHotels() {
		return hotels;
	}
	public void setHotels(ArrayList<HotelinfoPO> hotels) {
		this.hotels = hotels;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
	public LevelPO getLevels() {
		return levels;
	}
	public void setLevels(LevelPO levels) {
		this.levels = levels;
	}
	public ArrayList<VIPType> getVipKinds() {
		return vipKinds;
	}
	public void setVipKinds(ArrayList<VIPType> vipKinds) {
		this.vipKinds = vipKinds;
	}


}
