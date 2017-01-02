package datatool;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Enum.MarketingStrategy;
import Enum.VIPType;
import vo.strategyVO.MarketingStrategyVO;

public class MarketingStrategyDataTool {
	static Calendar begin1=Calendar.getInstance();
	static Calendar end1=Calendar.getInstance();
	static Calendar begin2=Calendar.getInstance();
	static Calendar end2=Calendar.getInstance();
	static Calendar begin3=Calendar.getInstance();
	static Calendar end3=Calendar.getInstance();
	static ArrayList<String> hlist=new ArrayList<String>();
	static ArrayList<String> blist=new ArrayList<String>();
	static ArrayList<VIPType> viplist=new ArrayList<VIPType>();
	static int[] levels={0,1,2};
	static double[] discounts={0.7,0.8,0.9};
	public static List<MarketingStrategyVO> list=new ArrayList<MarketingStrategyVO>();
	static{
		begin1.set(2016,11,11,00,00);
		end1.set(2016,11,11,23,59);
		begin2.set(2016,12,24,00,00);
		end2.set(2016,11,11,00,00);
		begin3.set(2016,12,31,00,00);
		end3.set(2016,12,31,23,59);
		hlist.add(HotelinfoDataTool.hotelinfoVO1.getName());
		hlist.add(HotelinfoDataTool.hotelinfoVO2.getName());
		hlist.add(HotelinfoDataTool.hotelinfoVO3.getName());

		viplist.add(VIPType.ORDINARYVIP);
		viplist.add(VIPType.ENTERPRISEVIP);
	}
    public static MarketingStrategyVO V0=new  MarketingStrategyVO();
    public static MarketingStrategyVO V1=new MarketingStrategyVO("2016双十一",MarketingStrategy.PERIOD,
    		begin1,end1,0.75);
    public static MarketingStrategyVO V2=new MarketingStrategyVO("VIP专属商圈特惠",MarketingStrategy.VIPSPECIAL,
    		begin2,end2,"仙林大学城",levels,discounts);
    public static MarketingStrategyVO V3=new MarketingStrategyVO("2017元旦特惠",MarketingStrategy.CREATED,
    		begin1,end2,0.85,hlist,678,2,2,viplist);

    static{
    	list.add(V0);
    	list.add(V1);
    	list.add(V2);
    	list.add(V3);
    }
}
