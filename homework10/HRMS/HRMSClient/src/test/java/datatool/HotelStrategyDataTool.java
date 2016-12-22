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
		begin4.set(2017,01,05,00,00);
		end4.set(2016,01,06,23,59);

		viplist.add(VIPType.ORDINARYVIP);
		viplist.add(VIPType.ENTERPRISEVIP);
	}
    public static MarketingStrategyVO V0=new  MarketingStrategyVO();
    public static HotelStrategyVO V1=new HotelStrategyVO("策略1","H00000001",HotelStrategy.BIRTHDAY,
    		VIPType.ORDINARYVIP,begin1,end1,0.75);
    public static HotelStrategyVO V2=new HotelStrategyVO("策略2","H00000031",HotelStrategy.COMPANY,
    		begin2,end2,0.8);
    public static HotelStrategyVO V3=new HotelStrategyVO("策略3","H00000003",HotelStrategy.OVERTHREEROOMS,
    		begin3,end3,0.85,3);
    public static HotelStrategyVO V4=new HotelStrategyVO("策略4","H00000093",HotelStrategy.SPECIALDAY,
    		viplist,begin4,end4,0.8,4,899);
}
