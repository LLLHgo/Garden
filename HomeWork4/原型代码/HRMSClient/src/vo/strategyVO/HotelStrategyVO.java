package vo.strategyVO;

import java.util.ArrayList;
import java.util.Date;

import Enum.HotelStrategy;
import Enum.VIPType;
import Enum.marketingStrategy;
import javafx.scene.image.Image;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;

public class HotelStrategyVO {
	//酒店工作人员制定的策略的种类，有enum：hotelStrategy{BIRTHDAY,COMPANY,SPECIALDAY,OVERTHREEROOMS;}
    private HotelStrategy type;
    //活动开始时间
    private Date startTime;
    //活动结束时间
    private Date endTime;
    //会员类型
    private VIPType viptype;
    //活动折扣
    private double discount;
    //设置策略的酒店ID
    private String hotelID;
    //活动海报
    private Image poster;
    //活动海报显示在客户界面的位置
    private String position;
    //享受折扣的最低消费金额
    private int minSum;
    //享受折扣的最少房间数
    private int minRooms;
    //参加活动的会员种类
    private ArrayList<VIPType> vipKinds;
    
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
    public HotelStrategyVO(String hotelID,HotelStrategy type,VIPType viptype,Date startTime,Date endTime,double discount,
    		Image poster,String position){
    	this.hotelID=hotelID;
    	this.type=type;
    	this.viptype=viptype;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.discount=discount;
    	this.poster=poster;
    	this.position=position;
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
    public HotelStrategyVO(String hotelID,HotelStrategy type,Date startTime,Date endTime,double discount,
    		Image poster,String position){
    	this.hotelID=hotelID;
    	this.type=type;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.discount=discount;
    	this.poster=poster;
    	this.position=position;
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
    public HotelStrategyVO(String hotelID,HotelStrategy type,Date startTime,Date endTime,double discount,
    		Image poster,String position,int minRooms){
    	this.hotelID=hotelID;
    	this.type=type;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.discount=discount;
    	this.poster=poster;
    	this.position=position;
    	this.minRooms = minRooms;
    }
    
    public HotelStrategyVO(String hotelID,HotelStrategy type,ArrayList<VIPType> vipKinds,Date startTime,Date endTime,double discount,
    		Image poster,String position,int minRooms,int minSum){
    	this.hotelID=hotelID;
    	this.type=type;
    	this.vipKinds=vipKinds;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.discount=discount;
    	this.poster=poster;
    	this.position=position;
    	this.minRooms = minRooms;
    	this.minSum = minSum;
    }
}
