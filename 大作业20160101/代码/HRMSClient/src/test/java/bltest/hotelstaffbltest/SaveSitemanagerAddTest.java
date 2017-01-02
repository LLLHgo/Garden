package bltest.hotelstaffbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Enum.ResultMessage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService_Stub;
import vo.hotelstaffVO.HotelstaffVO;

public class SaveSitemanagerAddTest {
	HotelstaffBLService hManage = new HotelstaffBLService_Stub();
//
//	public GetBasicinfoTest(){
//		hManage = new HotelstaffManage();
//	}

	@Test
	public void test1(){
		//获得正确的密码
		HotelstaffVO vo = new HotelstaffVO();
		vo.setHotelID("H00000002");
		vo.setTel("12345678");
		vo.setPassword("111111");
		assertEquals(ResultMessage.SUCCESS,hManage.saveSitemanagerUpdate(vo));
		vo.setHotelID("H00000001");
		assertEquals(ResultMessage.FAIL,hManage.saveSitemanagerUpdate(vo));
		
	}
}