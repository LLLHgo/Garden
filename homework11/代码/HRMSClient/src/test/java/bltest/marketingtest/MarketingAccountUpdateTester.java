package bltest.marketingtest;

import static org.junit.Assert.*;

import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.marketingbl.MarketingManage;
import vo.marketingVO.MarketingVO;

public class MarketingAccountUpdateTester {
	private MarketingManage manage=new MarketingManage();

	@Test
	public void test1(){
		MarketingVO vo=new MarketingVO("网站营销人员","password","M00000001","13477778888");
		assertEquals(ResultMessage.SUCCESS,manage.MarketingAccountUpdate(vo));
	}
	@Test
	public void test2(){
		MarketingVO vo = null;
		assertEquals(ResultMessage.FAIL,manage.MarketingAccountUpdate(vo));
	}
}
