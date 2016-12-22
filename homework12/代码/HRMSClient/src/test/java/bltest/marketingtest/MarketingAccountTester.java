package bltest.marketingtest;

import static org.junit.Assert.*;

import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.marketingbl.MarketingManage;
import vo.marketingVO.MarketingVO;

public class MarketingAccountTester {
	private MarketingManage manage=new MarketingManage();

	/*@Test
	public void test1(){
		MarketingVO vo=new MarketingVO("网站营销人员","marketingpassword","","13477778888");
		assertEquals(ResultMessage.SUCCESS,manage.MarketingAccountAdd(vo));
	}*/
	@Test
	public void test2(){
		MarketingVO vo = null;
		assertEquals(ResultMessage.FAIL,manage.MarketingAccountAdd(vo));
	}

	@Test
	public void test3(){
		MarketingVO vo=new MarketingVO("Number9","simplepassword","M00000009","12333");
		assertEquals(ResultMessage.SUCCESS,manage.MarketingAccountUpdate(vo));
	}

	@Test
	public void test4(){
		MarketingVO vo=new MarketingVO("beauty","yes","M00000004","32");
		assertEquals(ResultMessage.SUCCESS,manage.MarketingAccountDelete(vo));
	}
}
