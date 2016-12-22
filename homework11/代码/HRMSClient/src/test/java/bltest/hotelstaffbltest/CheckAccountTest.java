package bltest.hotelstaffbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.hotelstaffbl.HotelstaffManage;

public class CheckAccountTest {

	HotelstaffManage hManage = new HotelstaffManage();
	
	@Test
	public void test1(){
		//账号密码都对
		assertEquals(true,hManage.checkAccount("H00000001","000000"));
	}
	
	@Test
	public void test2(){
		//账号错
		assertEquals(false,hManage.checkAccount("H00000002","000000"));
	}
	
	@Test
	public void test3(){
		//密码错
		assertEquals(false,hManage.checkAccount("H00000001","000001"));
	}
	
	@Test
	//账号密码都错
	public void test4(){
		//密码错
		assertEquals(false,hManage.checkAccount("H00000002","000001"));
	}
}
