package bltest.marketingtest;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.marketingbl.MarketingManage;
import vo.marketingVO.MarketingVO;

public class InitTester {
	private MarketingManage manage=new MarketingManage();

	@Test
	public void test1(){
		MarketingVO vo=new MarketingVO("melody","password","M00000001","43748738743");
		MarketingVO voFromBase=manage.init("M00000001");
		assertEquals(vo.getName(),voFromBase.getName());
		assertEquals(vo.getPassword(),voFromBase.getPassword());
		assertEquals(vo.getMarketingID(),voFromBase.getMarketingID());
		assertEquals(vo.getTelephone(),voFromBase.getTelephone());
	}

	@Test
	public void test2(){//传入了不是首字母为M的账号
		assertEquals(null,manage.init("C000000001"));
	}

	@Test
	public void test3(){//传入了不存在的账号
		assertEquals(null,manage.init("M000000009"));
	}

	@Test
	public void test4(){
		MarketingVO vo=new MarketingVO("john","johnpass","M00000002","4343");
		MarketingVO voFromBase=manage.init("M00000002");
		assertEquals(vo.getName(),voFromBase.getName());
		assertEquals(vo.getPassword(),voFromBase.getPassword());
		assertEquals(vo.getMarketingID(),voFromBase.getMarketingID());
		assertEquals(vo.getTelephone(),voFromBase.getTelephone());
	}

	/*@Test
	public void test5(){
		MarketingVO vo=new MarketingVO("beauty","yes","M00000004","32");
		MarketingVO voFromBase=manage.init("M00000004");
		assertEquals(vo.getName(),voFromBase.getName());
		assertEquals(vo.getPassword(),voFromBase.getPassword());
		assertEquals(vo.getMarketingID(),voFromBase.getMarketingID());
		assertEquals(vo.getTelephone(),voFromBase.getTelephone());
	}*/

	@Test
	public void test6(){
		MarketingVO vo=new MarketingVO("handsome","that'sright","M00000008","387");
		MarketingVO voFromBase=manage.init("M00000008");
		assertEquals(vo.getName(),voFromBase.getName());
		assertEquals(vo.getPassword(),voFromBase.getPassword());
		assertEquals(vo.getMarketingID(),voFromBase.getMarketingID());
		assertEquals(vo.getTelephone(),voFromBase.getTelephone());
	}
}
