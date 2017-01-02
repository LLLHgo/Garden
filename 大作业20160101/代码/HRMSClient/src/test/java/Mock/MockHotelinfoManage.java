package Mock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Enum.HotelStrategy;
import Enum.OrderType;
import Enum.ResultMessage;
import Enum.RoomState;
import Enum.Star;
import Enum.VIPType;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class MockHotelinfoManage {
	HotelinfoVO hotelinfoVO1;
	HotelinfoVO hotelinfoVO2;
	HotelinfoVO hotelinfoVO3;
	List<HotelinfoVO> list;
	OrderVO orderVO1;
	List<OrderVO> orderList;
	RoominfoVO roominfo1 ;
	RoominfoVO roominfo2 ;
	RoominfoVO roominfo3 ;
	RoominfoVO roominfo4 ;
	RoominfoVO roominfo5 ;
	RoominfoVO roominfo6 ;
	List<RoominfoVO> roominfoList;
	ArrayList<String> strategy;
	HotelStrategyVO V1;
	public MockHotelinfoManage(){
		roominfo1 = new RoominfoVO("H00000001","标准间","8304",200, RoomState.Usable);
		roominfo2 = new RoominfoVO("H00000001","标准间","8305",200, RoomState.Usable);
		roominfo3 = new RoominfoVO("H00000001","大床房","8306",200, RoomState.Usable);
		roominfo4 = new RoominfoVO("H00000001","标准间","8307",200, RoomState.Usable);
		roominfo5 = new RoominfoVO("H00000001","标准间","8308",200, RoomState.Unusable);
		roominfo6 = new RoominfoVO("H00000001","大床房","8309",200, RoomState.Unusable);
		roominfoList = new ArrayList<RoominfoVO>();
		roominfoList.add(roominfo1);
		roominfoList.add(roominfo2);
		roominfoList.add(roominfo3);
		roominfoList.add(roominfo4);
		roominfoList.add(roominfo5);
		roominfoList.add(roominfo6);

	    Calendar begin1=Calendar.getInstance();
		Calendar end1=Calendar.getInstance();
		begin1.set(2016,11,11,00,00);
		end1.set(2016,11,11,23,59);

		hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","山西路商圈","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000001");
//		hotelinfoVO1 = new HotelinfoVO("BeijingDongRode","GuLouArea",
//		"Brief Introduction","Facility","12345678",Star.FOUR,"H00000001");
		hotelinfoVO2 = new HotelinfoVO("RuJia","LongPanRode","GuLouArea","12345679",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000002");
		hotelinfoVO3 = new HotelinfoVO("LvZhou","XianLinRode","XianLinArea","12345670",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000003");
		list = new ArrayList<HotelinfoVO>();
		list.add(hotelinfoVO1);
		list.add(hotelinfoVO2);
		list.add(hotelinfoVO3);

		String strategy1="M2016091501";
		String strategy2="H2016091602";
		strategy=new ArrayList<String>();
		strategy.add(strategy1);
		strategy.add(strategy2);

		orderVO1=new OrderVO("20161017090702","C00000002","Lucy","17714368889",
				VIPType.ORDINARYVIP,"2016-10-17 09:07",OrderType.NORMALNONEXEC,"caesar","H00000001",650.32,strategy);
		orderList = new ArrayList<OrderVO>();
		orderList.add(orderVO1);


		V1=new HotelStrategyVO("策略1","H00000001",HotelStrategy.BIRTHDAY,
	    		VIPType.ORDINARYVIP,begin1,end1,0.75);
	}

	public HotelinfoVO getBasicinfo(String hotelID) {
		if(hotelID.equals("H00000001")){
			return hotelinfoVO1;
		}
		else if(hotelID.equals("H00000002")){
			return hotelinfoVO2;
		}
		else if(hotelID.equals("H00000003")){
			return 	hotelinfoVO3;
		}
		else {
			return null;
		}
	}


	public List<HotelinfoVO> getBasicinfoList(String area) {
		HotelinfoVO hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","GuLouArea","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000001");
		
		HotelinfoVO hotelinfoVO2 = new HotelinfoVO("RuJia","LongPanRode","GuLouArea","12345679",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000002");
		HotelinfoVO hotelinfoVO3 = new HotelinfoVO("LvZhou","XianLinRode","XianLinArea","12345670",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000003");
		List<HotelinfoVO> list = new ArrayList<HotelinfoVO>();
		list.add(hotelinfoVO1);
		list.add(hotelinfoVO2);
		list.add(hotelinfoVO3);
		return list;
	}


	public ResultMessage updateBassicinfo(HotelinfoVO vo) {
		if(vo.getHotelID().equals("H00000001")||vo.getHotelID().equals("H00000002")
				||vo.getHotelID().equals("H00000003")){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAIL;
	}


	public RoominfoVO getRoominfo(String hotelID, String roomtype) {
		return roominfo1;
	}


	public List<RoominfoVO> getRoominfoList(String hotelID) {
		return roominfoList;
	}


	public double calculatePrice(List<HotelStrategyVO> hotelStrategylist,
			List<MarketingStrategyVO> marketingStrategyList, ClientVO vo, double originalPrice) {

		return 0;
	}

	public boolean saveSitemanagerAdd(HotelinfoVO vo) {
		if(vo.getHotelID().equals("H00000001")||vo.getHotelID().equals("H00000002")
				||vo.getHotelID().equals("H00000003")){
			return true;
		}
		return false;
	}


	public ResultMessage updatehotelStrategy(String hotelID, HotelStrategyVO vo) {

		return null;
	}


	public HotelStrategyVO gethotelStrategy(String hotelID) {
		if(hotelID.equals("H00000001")){
			return V1;
		}
		return null;
	}


	public ResultMessage deletehotelStrategy(String hotelID, HotelStrategyVO hotelStrategy) {

		return ResultMessage.SUCCESS;
	}


	public HotelinfoVO gethotelinfoVO(String hotelID) {

		return null;
	}


	public RoominfoVO getroominfo(String hotelID, String roomID) {

		return null;
	}


	public ResultMessage updateroominfo(HotelinfoVO vo) {

		return null;
	}


	public List<OrderVO> gethotelOrderList(String hotelID) {
		if(hotelID.equals("H00000001")){
			return orderList;
		}
		return null;
	}


	public boolean updateroominfo(RoominfoVO vo, String hotelID) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String[] getArea(){
		String[] areas={"新街口商圈","山西路商圈","珠江路商圈","江东门商圈","江北商圈","卡子门商圈"};
		return areas;
	}
	
	public boolean addArea(String area){
		return true;
		
	}
}
