package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Enum.RoomState;
import Enum.Star;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService;
import businesslogicservice.hotelinfoblservice.HotelinfoBLService_Stub;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;

public class SortRemarkStarTest {

	HotelinfoBLService hotel;
	ArrayList<HotelinfoVO> beforelist;
	
	public SortRemarkStarTest(){
		
	hotel = new HotelinfoBLService_Stub();
	HotelinfoVO vo1 = new HotelinfoVO();
	
	RoominfoVO roominfo11 = new RoominfoVO("H00000001","标准间","8304",200, RoomState.Usable);
	RoominfoVO roominfo12 = new RoominfoVO("H00000001","标准间","8305",200, RoomState.Usable);
	RoominfoVO roominfo13 = new RoominfoVO("H00000001","大床房","8306",200, RoomState.Usable);
	
	RoominfoVO roominfo21 = new RoominfoVO("H00000001","标准间","8304",900, RoomState.Usable);
	RoominfoVO roominfo22 = new RoominfoVO("H00000001","标准间","8305",200, RoomState.Usable);
	RoominfoVO roominfo23 = new RoominfoVO("H00000001","大床房","8306",50, RoomState.Usable);
	
	RoominfoVO roominfo31 = new RoominfoVO("H00000001","标准间","8307",100, RoomState.Usable);
	RoominfoVO roominfo32 = new RoominfoVO("H00000001","标准间","8308",200, RoomState.Unusable);
	
	ArrayList<RoominfoVO> roominfoList1 = new ArrayList<RoominfoVO>();
	roominfoList1.add(roominfo11);
	roominfoList1.add(roominfo12);
	roominfoList1.add(roominfo13);
	
	ArrayList<RoominfoVO> roominfoList2 = new ArrayList<RoominfoVO>();
	roominfoList2.add(roominfo21);
	roominfoList2.add(roominfo22);
	roominfoList2.add(roominfo23);
	
	ArrayList<RoominfoVO> roominfoList3 = new ArrayList<RoominfoVO>();
	roominfoList3.add(roominfo31);
	roominfoList3.add(roominfo32);
	
	
	
	ArrayList<String> remark1 = new ArrayList<String>();
	//3.33
	remark1.add("4 很好啊");
	remark1.add("3 很好啊");
	remark1.add("4 很好啊");
	vo1.setRemark(remark1);
	vo1.setStar(Star.ONE);
	vo1.setRoominfoList(roominfoList1);
	vo1.setHotelID("1");
	
	HotelinfoVO vo2 = new HotelinfoVO();
	ArrayList<String> remark2 = new ArrayList<String>();
	//4
	remark2.add("5 很好啊");
	remark2.add("3 很好啊");
	remark2.add("4 很好啊");
	vo2.setRemark(remark2);
	vo2.setStar(Star.FIVE);
	vo2.setRoominfoList(roominfoList2);
	vo2.setHotelID("2");
	
	HotelinfoVO vo3 = new HotelinfoVO();
	ArrayList<String> remark3 = new ArrayList<String>();
	//2.3
	remark3.add("3 很好啊");
	remark3.add("4 很好啊");
	vo3.setRemark(remark3);
	vo3.setStar(Star.TWO);
	vo3.setRoominfoList(roominfoList3);
	vo3.setHotelID("3");
	
	beforelist = new ArrayList<HotelinfoVO>();
	beforelist.add(vo1);
	beforelist.add(vo2);
	beforelist.add(vo3);
	}
	
//	@Test
//	public void test1(){
//		assertEquals("2",hotel.rankHotelAccordingtoRemarkStar(beforelist).get(0).getHotelID());
//		assertEquals("1",hotel.rankHotelAccordingtoRemarkStar(beforelist).get(1).getHotelID());
//		assertEquals("3",hotel.rankHotelAccordingtoRemarkStar(beforelist).get(2).getHotelID());
//	}
	
	@Test
	public void test2(){
		assertEquals("2",hotel.rankHotelAccordingtoHotelStar(beforelist).get(0).getHotelID());
		assertEquals("3",hotel.rankHotelAccordingtoHotelStar(beforelist).get(1).getHotelID());
		assertEquals("1",hotel.rankHotelAccordingtoHotelStar(beforelist).get(2).getHotelID());
	}
	
	@Test
	public void test3(){
		assertEquals("2",hotel.rankHotelAccordingtoMinPrice(beforelist).get(0).getHotelID());
		assertEquals("3",hotel.rankHotelAccordingtoMinPrice(beforelist).get(1).getHotelID());
		assertEquals("1",hotel.rankHotelAccordingtoMinPrice(beforelist).get(2).getHotelID());
	}
}
