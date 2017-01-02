package datatool;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Enum.VIPType;
import po.StrategyPO.HotelBirthdayPO;
import po.StrategyPO.HotelCompanyPO;
import po.StrategyPO.HotelCreatedPO;
import po.StrategyPO.HotelOverThreeRoomsPO;
import po.StrategyPO.HotelSpecialdayPO;
import po.StrategyPO.MarketingCreatedPO;
import po.StrategyPO.MarketingPeriodPO;
import po.StrategyPO.MarketingSpecialPO;
import po.StrategyPO.StrategyPO;

public class StrategyPODataTool {
	static Calendar begin1=Calendar.getInstance();
	static Calendar end1=Calendar.getInstance();
	static Calendar begin2=Calendar.getInstance();
	static Calendar end2=Calendar.getInstance();
	static Calendar begin3=Calendar.getInstance();
	static Calendar end3=Calendar.getInstance();
	static Calendar begin4=Calendar.getInstance();
	static Calendar end4=Calendar.getInstance();
	static ArrayList<String> hlist=new ArrayList<String>();
	static ArrayList<String> blist=new ArrayList<String>();
	static ArrayList<String> clist=new ArrayList<String>();
	static ArrayList<VIPType> viplist=new ArrayList<VIPType>();
	static int[] levels={2,1,0};
	static double[] discounts={0.7,0.8,0.9};
	public static List<StrategyPO> list1=new ArrayList<StrategyPO>();
	public static List<StrategyPO> list2=new ArrayList<StrategyPO>();
	static{
		begin1.set(2016,11,5,23,30);
		end1.set(2016,11,11,23,59);
		begin2.set(2016,11,2,00,00);
		end2.set(2016,11,11,00,00);
		begin3.set(2016,11,5,23,29);
		end3.set(2016,11,6,23,29);
		begin4.set(2016,11,02,00,00);
		end4.set(2016,11,06,23,59);
		hlist.add("凯撒大酒店");
		hlist.add("南京禹城");
		hlist.add("AOA");
		clist.add("南京大学");
		clist.add("中国石油");
		viplist.add(VIPType.ORDINARYVIP);
		viplist.add(VIPType.ENTERPRISEVIP);
	}

    public static MarketingPeriodPO V1=new MarketingPeriodPO("2016双十一",begin1,end1,0.5);
    public static MarketingSpecialPO V2=new MarketingSpecialPO("VIP专属商圈特惠",begin2,end2,"仙林大学城",levels,discounts);
    public static MarketingCreatedPO V3=new MarketingCreatedPO("2017元旦特惠",begin3,end3,0.55,hlist,400,2,1,viplist);
    public static HotelBirthdayPO V11=new HotelBirthdayPO("生日特惠折扣",begin1,end1,"H00000001",0.6);
    public static HotelCompanyPO V22=new HotelCompanyPO("合作企业特惠",begin2,end2,"H00000001",0.65);
    public static HotelCreatedPO V33=new HotelCreatedPO("新增折扣",begin3,end3,"H00000001",0.7,viplist,2,400,3);
    public static HotelOverThreeRoomsPO V44=new HotelOverThreeRoomsPO("超过三间折扣",begin4,end4,"H00000001",0.75,4);
    public static HotelSpecialdayPO V55=new HotelSpecialdayPO("hotel特定时间",begin4,end4,"H00000001",0.8);
    static{
    	list1.add(V1);
    	list1.add(V2);
    	list1.add(V3);
    	list2.add(V11);
    	list2.add(V22);
    	list2.add(V33);
    	list2.add(V44);
    	list2.add(V55);
    }
}
