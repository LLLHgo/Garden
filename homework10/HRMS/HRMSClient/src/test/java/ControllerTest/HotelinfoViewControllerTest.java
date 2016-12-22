package ControllerTest;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Enum.HotelStrategy;
import Enum.OrderType;
import Enum.ResultMessage;
import Enum.RoomState;
import Enum.Star;
import Enum.VIPType;
import businesslogic.hoteinfobl.HotelinfoManage;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;

public class HotelinfoViewControllerTest {
	HotelstaffViewController controller;

	HotelinfoManage hotelinfo;
	HotelinfoVO hotelinfoVO1;
	HotelinfoVO hotelinfoVO2;
	HotelinfoVO hotelinfoVO3;
	HotelinfoVO hotelinfoVO4;
	List<HotelinfoVO> hotelList;

	RoominfoVO roominfo1 ;
	RoominfoVO roominfo2 ;
	RoominfoVO roominfo3 ;
	RoominfoVO roominfo4 ;
	RoominfoVO roominfo5 ;
	RoominfoVO roominfo6 ;
	List<RoominfoVO> roominfoList;
	List<HotelStrategyVO> hotelstrategyList;

	HotelStrategyVO V1;

	ClientVO clientVO1;

	OrderVO orderVO1;
	List<OrderVO> hotelOrderList;

	@Before
	public void setup(){
		hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","山西路商圈","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000001");

		hotelinfoVO2 = new HotelinfoVO("RuJia","LongPanRode","GuLouArea","12345679",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000002");

		hotelinfoVO3 = new HotelinfoVO("LvZhou","XianLinRode","XianLinArea","12345670",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000003");
		hotelinfoVO4 = new HotelinfoVO("LvZhou","XianLinRode","XianLinArea","12345670",new ArrayList<RoominfoVO>(),Star.FOUR,
				new ArrayList<String>(),"Brief Introduction","H00000004");

		hotelList = new ArrayList<HotelinfoVO>();
		hotelList.add(hotelinfoVO1);
		hotelList.add(hotelinfoVO2);
		hotelList.add(hotelinfoVO3);

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
//
		controller = HotelstaffViewController.getInstance("H00000001");

		Calendar begin1=Calendar.getInstance();
		Calendar end1=Calendar.getInstance();
		begin1.set(2016,11,11,00,00);
		end1.set(2016,11,11,23,59);
		ArrayList<HotelinfoVO> hlist=new ArrayList<HotelinfoVO>();

		V1=new HotelStrategyVO("策略1","H00000001",HotelStrategy.SPECIALDAY,
	    		begin1,end1,0.75);
		hotelstrategyList = new ArrayList<HotelStrategyVO>();
		hotelstrategyList.add(V1);

		Date day1=new Date(1996,2,29);
		File file=new File("credit");
		Date day3=new Date(1992,5,29);
		clientVO1=new ClientVO("C00000001","justfun","ErgouWang","13747474741",
				 VIPType.ORDINARYVIP,2,"19960-02-29","",file,100);

		ArrayList<String> strategy;
		String strategy1="M2016091501";
		String strategy2="H2016091602";
		strategy=new ArrayList<String>();
		strategy.add(strategy1);
		strategy.add(strategy2);
		orderVO1=new OrderVO("20161015085702","C00000002","Lucy","17714368889",
				VIPType.ORDINARYVIP,"2016-10-15 08:57",OrderType.NORMALNONEXEC,"caesar","H00000001",650.32,strategy);
		hotelOrderList = new ArrayList<OrderVO>();
		hotelOrderList.add(orderVO1);
	}

	@Test
	public void testgetBasicInfo(){
		assertEquals(hotelinfoVO1.getAddress(),controller.getHotelBasicinfo("H00000001").getAddress());
		assertEquals(hotelinfoVO1.getArea(),controller.getHotelBasicinfo("H00000001").getArea());
		assertEquals(hotelinfoVO1.getName(),controller.getHotelBasicinfo("H00000001").getName());
		assertEquals(hotelinfoVO1.getStar(),controller.getHotelBasicinfo("H00000001").getStar());
	}


	@Test
	public void testsaveSitemanagerAdd(){
		assertEquals(true,controller.saveSitemanagerAdd(hotelinfoVO1));
		assertEquals(true,controller.saveSitemanagerAdd(hotelinfoVO2));
		assertEquals(false,controller.saveSitemanagerAdd(hotelinfoVO4));
	}


	@Test
	public void testupdateOrderState(){
		assertEquals(ResultMessage.SUCCESS,controller.updateOrderState(orderVO1));
	}


	@Test
	public void testgethotelStrategy(){
		assertEquals("H00000001",controller.gethotelStrategy("H00000001").get(0).getHotelID());
	}

	@Test
	public void testupdatehotelStrategy(){
		assertEquals(ResultMessage.SUCCESS,controller.updatehotelStrategy(V1));
	}
}
