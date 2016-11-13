package Mock;

import java.util.ArrayList;
import java.util.List;

import Enum.HotelStrategy;
import Enum.OrderType;
import Enum.ResultMessage;
import Enum.RoomState;
import Enum.Star;
import Enum.VIPType;
import businesslogic.hoteinfobl.Roominfo;
import javafx.scene.image.Image;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
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
		roominfo1 = new RoominfoVO("标准间","8304",200, RoomState.Usable);
		roominfo2 = new RoominfoVO("标准间","8305",200, RoomState.Usable);
		roominfo3 = new RoominfoVO("大床房","8306",200, RoomState.Usable);
		roominfo4 = new RoominfoVO("标准间","8307",200, RoomState.Usable);
		roominfo5 = new RoominfoVO("标准间","8308",200, RoomState.Unusable);
		roominfo6 = new RoominfoVO("大床房","8309",200, RoomState.Unusable);
		roominfoList = new ArrayList<RoominfoVO>();
		roominfoList.add(roominfo1);
		roominfoList.add(roominfo2);
		roominfoList.add(roominfo3);
		roominfoList.add(roominfo4);
		roominfoList.add(roominfo5);
		roominfoList.add(roominfo6);
		
		hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","GuLouArea","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000001");
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
		
		String begin1="2016-11-11 00:00:00";
		String end1="2016-11-11 23:59:59";
		Image image = null;
	    V1=new HotelStrategyVO("H00000001",HotelStrategy.BIRTHDAY,
	    		VIPType.ORDINARYVIP,begin1,end1,0.75,image,"North");
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


	public List<HotelinfoVO> getBasicinfoList(ClientRequirementVO vo) {
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
		return null;
	}


	public List<RoominfoVO> getRoominfoList(String hotelID) {
		return null;
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


	public ResultMessage updateOrderState(String orderID, OrderType orderType) {
	
		return ResultMessage.SUCCESS;
	}
}
