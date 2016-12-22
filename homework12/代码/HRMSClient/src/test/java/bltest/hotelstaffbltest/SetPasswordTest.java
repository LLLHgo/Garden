//package bltest.hotelstaffbltest;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//
//import Enum.ResultMessage;
//import businesslogic.hotelstaffbl.HotelstaffManage;
//
//public class SetPasswordTest {
//
//	HotelstaffManage hManage = new HotelstaffManage();
//	
//	@Test
//	public void test1(){
//		//设置密码正确
//		assertEquals(ResultMessage.SUCCESS,hManage.setPassword("H0000001", "0000001"));
//	}
//	
//	@Test
//	public void test2(){
//		//设置密码为空
//		assertEquals(ResultMessage.VOIDPASSWORD,hManage.setPassword("H00000001",""));
//	}
//}
