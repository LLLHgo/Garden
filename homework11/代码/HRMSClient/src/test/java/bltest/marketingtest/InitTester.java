package bltest.marketingtest;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.marketingbl.MarketingManage;
import vo.marketingVO.MarketingVO;

public class InitTester {
	private MarketingManage manage=new MarketingManage();

	@Test
	public void test1(){
		MarketingVO vo=new MarketingVO("网站营销人员","password","M00000001","13477778888");
		assertEquals(vo.getName(),manage.init("M00000001").getName());
		assertEquals(vo.getPassword(),manage.init("M00000001").getPassword());
		assertEquals(vo.getMarketingID(),manage.init("M00000001").getMarketingID());
		assertEquals(vo.getTelephone(),manage.init("M00000001").getTelephone());
	}

	@Test
	public void test2(){//传入了不是首字母为M的账号
		assertEquals(null,manage.init("C000000001"));
	}

}
