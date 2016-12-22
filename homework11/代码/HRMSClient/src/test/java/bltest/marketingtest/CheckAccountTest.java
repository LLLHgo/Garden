package bltest.marketingtest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.marketingbl.MarketingManage;

public class CheckAccountTest {
	private MarketingManage manage=new MarketingManage();

	@Test
	public void test1(){
		//账号密码都对
		assertEquals(true,manage.checkAccount("M00000001","password"));
	}

	@Test
	public void test2(){
		//账号密码都对
		assertEquals(true,manage.checkAccount("M00000004","passwordfor04"));
	}

	@Test
	public void test3(){
		//账号错
		assertEquals(false,manage.checkAccount("M","0000"));
	}

	@Test
	public void test4(){
		//账号对密码粗
		assertEquals(false,manage.checkAccount("M00000001","000000"));
	}


}
