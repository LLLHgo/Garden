package datatool;

import java.util.ArrayList;
import Enum.HotelStrategy;
import Enum.VIPType;
import javafx.scene.image.Image;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelStrategyDataTool {
	static String begin1="2016-11-11 00:00:00";
	static String end1="2016-11-11 23:59:59";
	static String begin2="2016-12-24 00:00:00";
	static String end2="2016-12-25 23:59:59";
	static String begin3="2016-12-31 00:00:00";
	static String end3="2016-12-31 23:59:59";
	static String begin4="2017-01-05 00:00:00";
	static String end4="2016-01-06 23:59:59";
	static ArrayList<VIPType> viplist=new ArrayList<VIPType>();
	static{
		viplist.add(VIPType.ORDINARYVIP);
		viplist.add(VIPType.ENTERPRISEVIP);
	}
    static Image image;
    public static MarketingStrategyVO V0=new  MarketingStrategyVO();
    public static HotelStrategyVO V1=new HotelStrategyVO("H00000001",HotelStrategy.BIRTHDAY,
    		VIPType.ORDINARYVIP,begin1,end1,0.75,image,"North");
    public static HotelStrategyVO V2=new HotelStrategyVO("H00000031",HotelStrategy.COMPANY,
    		begin2,end2,0.8,image,"North");
    public static HotelStrategyVO V3=new HotelStrategyVO("H00000003",HotelStrategy.OVERTHREEROOMS,
    		begin3,end3,0.85,image,"North",3);
    public static HotelStrategyVO V4=new HotelStrategyVO("H00000093",HotelStrategy.SPECIALDAY,
    		viplist,begin4,end4,0.85,image,"North",3,789);
}
