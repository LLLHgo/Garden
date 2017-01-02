package bltest.marketingtest;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.marketingbl.MarketingManage;

public class getMarketingIDTester {
@Test
public void test(){
	MarketingManage manage=new MarketingManage();
	assertEquals("M00000009",manage.getMarketingID());
}
}
