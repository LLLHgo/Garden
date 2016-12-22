package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.hoteinfobl.HotelinfoManage;
import datatool.AreaDataTool;
import vo.areaVO.AreaVO;

public class GetAreaHotels {

	HotelinfoManage hManage ;
	AreaVO vo;
	
	@Before
	public void init(){
	hManage = new HotelinfoManage();
	ArrayList<String> hotels = new ArrayList<String>();
	hotels.add("HanTing");
	vo = new AreaVO("山西路商圈",hotels);
	}
	
	@Test
	public void test1(){
		assertEquals("山西路商圈",hManage.getAreaHotels().get(0).getName());
		assertEquals("HanTing",hManage.getAreaHotels().get(0).getHotels().get(0));
	}
}
