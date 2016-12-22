package datatool;

import java.util.ArrayList;
import java.util.List;

import Enum.Star;
import po.HotelinfoPO;
import po.RoominfoPO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;

public class HotelinfoDataTool {
	public static HotelinfoVO hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","山西路商圈","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
			new ArrayList<String>(),"Brief Introduction","H00000001");

	public static HotelinfoVO hotelinfoVO2 = new HotelinfoVO("RuJia","LongPanRode","GuLouArea","12345679",new ArrayList<RoominfoVO>(),Star.FOUR,
			new ArrayList<String>(),"Brief Introduction","H00000002");

	public static HotelinfoVO hotelinfoVO3 = new HotelinfoVO("LvZhou","XianLinRode","XianLinArea","12345670",new ArrayList<RoominfoVO>(),Star.FOUR,
			new ArrayList<String>(),"Brief Introduction","H00000003");

	public static HotelinfoPO hotelinfoPO1 = new HotelinfoPO("HanTing","BeijingDongRode","山西路商圈","12345678",new ArrayList<RoominfoPO>(),Star.FOUR,
			new ArrayList<String>(),"Brief Introduction","H00000001");
	
	public static ArrayList<HotelinfoPO> listPO = new ArrayList<HotelinfoPO>();
	static{
		listPO.add(hotelinfoPO1);
	}
	
	public static List<HotelinfoVO> list = new ArrayList<HotelinfoVO>();
	static{
		HotelinfoVO hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","GuLouArea","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000001");
		HotelinfoVO hotelinfoVO2 = new HotelinfoVO("RuJia","LongPanRode","GuLouArea","12345679",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000002");
		HotelinfoVO hotelinfoVO3 = new HotelinfoVO("LvZhou","XianLinRode","XianLinArea","12345670",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000003");
		list.add(hotelinfoVO1);
		list.add(hotelinfoVO2);
		list.add(hotelinfoVO3);
	}
}
