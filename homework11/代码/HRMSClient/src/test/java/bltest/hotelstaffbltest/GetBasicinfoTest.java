package bltest.hotelstaffbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.hotelstaffbl.HotelstaffManage;

public class GetBasicinfoTest {
	HotelstaffManage hManage = new HotelstaffManage();
//	
//	public GetBasicinfoTest(){
//		hManage = new HotelstaffManage();
//	}
	
	@Test
	public void test1(){
		//获得正确的密码
		assertEquals("000000",hManage.getBasicinfo("H00000001"));
	}
}
