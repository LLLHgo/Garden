package ControllerTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Mock.MockHotelinfoManage;
import Mock.MockHotelstaffManager;
import presentation.hotelstaff.controller.HotelstaffViewController;
import vo.hotelstaffVO.HotelstaffVO;

public class HotelstaffViewControllerTest {
	
	MockHotelstaffManager hotelstaff;
	HotelstaffVO hotelstaffVO1;
	HotelstaffVO hotelstaffVO2;
	HotelstaffVO hotelstaffVO3;
	
	@Before
	public void setup(){
		hotelstaff = new MockHotelstaffManager();
		hotelstaffVO1 = new HotelstaffVO("H00000001","00000000","12345678");
		hotelstaffVO2 = new HotelstaffVO("H00000002","00000000","12345679");
		hotelstaffVO3 = new HotelstaffVO("H00000003","00000000","12345670");
	}
	
	@Test
	public void testsaveSitemanagerUpdate(){
		assertEquals(true , hotelstaff.saveSitemanagerUpdate(hotelstaffVO1));
		assertEquals(true , hotelstaff.saveSitemanagerUpdate(hotelstaffVO2));
	}
	
	@Test
	public void testreturnSitemanagerAccount(){
		assertEquals(hotelstaffVO1.getTel(),hotelstaff.returnSitemanagerAccount("H00000001").getTel());
		assertEquals(hotelstaffVO2.getTel(),hotelstaff.returnSitemanagerAccount("H00000002").getTel());
		assertEquals(null,hotelstaff.returnSitemanagerAccount("H00000005"));
	}
}
