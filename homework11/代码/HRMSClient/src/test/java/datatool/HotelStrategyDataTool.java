package datatool;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Enum.HotelStrategy;
import Enum.VIPType;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelStrategyDataTool {
	static Calendar begin1=Calendar.getInstance();
	static Calendar end1=Calendar.getInstance();
	static Calendar begin2=Calendar.getInstance();
	static Calendar end2=Calendar.getInstance();
	static Calendar begin3=Calendar.getInstance();
	static Calendar end3=Calendar.getInstance();
	static Calendar begin4=Calendar.getInstance();
	static Calendar end4=Calendar.getInstance();
	static List<VIPType> viplist=new ArrayList<VIPType>();
	static{
		begin1.set(2016,11,11,00,00);
		end1.set(2016,11,11,23,59);
		begin2.set(2016,12,24,00,00);
		end2.set(2016,11,11,00,00);
		begin3.set(2016,12,31,00,00);
		end3.set(2016,12,31,23,59);
		begin4.set(2017,12,05,00,00);
		end4.set(2016,01,06,23,59);

		viplist.add(VIPType.ORDINARYVIP);
		viplist.add(VIPType.ENTERPRISEVIP);
	}
    public static MarketingStrategyVO V0=new  MarketingStrategyVO();
    public static HotelStrategyVO V1=new HotelStrategyVO("生日特惠折扣","H00000001",HotelStrategy.BIRTHDAY,
    		VIPType.ORDINARYVIP,begin1,end1,0.75);
    public static HotelStrategyVO V2=new HotelStrategyVO("三间及以上预订特惠","H00000031",HotelStrategy.COMPANY,
    		begin2,end2,0.8);
    public static HotelStrategyVO V3=new HotelStrategyVO("合作企业客户折扣","H00000003",HotelStrategy.OVERTHREEROOMS,
    		begin3,end3,0.85,3);
    public static HotelStrategyVO V4=new HotelStrategyVO("双十一活动折扣","H00000093",HotelStrategy.SPECIALDAY,
    		viplist,begin4,end4,0.8,4,899,3);
    public static HotelStrategyVO V5=new HotelStrategyVO("优惠1","H00000093",HotelStrategy.CREATED,
    		viplist,begin4,end4,0.8,4,899,3);
    public static List<HotelStrategyVO> list = new ArrayList<HotelStrategyVO>();
    
    static{
    	list.add(V1);
    	list.add(V2);
    	list.add(V3);
    	list.add(V4);
    	list.add(V5);
    }
}
