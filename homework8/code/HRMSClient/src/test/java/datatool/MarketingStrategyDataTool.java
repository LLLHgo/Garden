package datatool;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Enum.VIPType;
import Enum.marketingStrategy;
import javafx.scene.image.Image;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.strategyVO.MarketingStrategyVO;

public class MarketingStrategyDataTool {
	static String begin1="2016-11-11 00:00:00";
	static String end1="2016-11-11 23:59:59";
	static String begin2="2016-12-24 00:00:00";
	static String end2="2016-12-25 23:59:59";
	static String begin3="2016-12-31 00:00:00";
	static String end3="2016-12-31 23:59:59";
	static ArrayList<HotelinfoVO> hlist=new ArrayList<HotelinfoVO>();
	static ArrayList<String> blist=new ArrayList<String>();
	static ArrayList<VIPType> viplist=new ArrayList<VIPType>();
	static LevelVO lvo=new LevelVO(1,"铜牌",1000);
	static{
		hlist.add(HotelinfoDataTool.hotelinfoVO1);
		hlist.add(HotelinfoDataTool.hotelinfoVO2);
		hlist.add(HotelinfoDataTool.hotelinfoVO3);
		blist.add("新街口");
		blist.add("仙林大学城");
		viplist.add(VIPType.ORDINARYVIP);
		viplist.add(VIPType.ENTERPRISEVIP);
	}
    static Image image;
    public static MarketingStrategyVO V0=new  MarketingStrategyVO();
    public static MarketingStrategyVO V1=new MarketingStrategyVO("2016双十一",marketingStrategy.DOUBLE11,
    		begin1,end1,0.75,hlist,image,"North");
    public static MarketingStrategyVO V2=new MarketingStrategyVO("VIP专属商圈特惠",marketingStrategy.VIPSPECIAL,
    		begin2,end2,0.8,image,blist,"North");
    public static MarketingStrategyVO V3=new MarketingStrategyVO("2017元旦特惠",marketingStrategy.CRATEDE,
    		begin1,end2,0.85,hlist,blist,image,"North",678,2,lvo,viplist);
}
