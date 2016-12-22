package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Enum.Star;
import businesslogic.hoteinfobl.HotelinfoManage;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;

public class GetBasicinfoTest {

	HotelinfoManage hotelinfo = new HotelinfoManage();
	public static HotelinfoVO hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","山西路商圈","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
			new ArrayList<String>(),"Brief Introduction","H00000001");
	
	@Test
	public void test1(){
		assertEquals(hotelinfoVO1.getAddress(),hotelinfo.getBasicinfo("H00000001").getAddress());	
		assertEquals(hotelinfoVO1.getArea(),hotelinfo.getBasicinfo("H00000001").getArea());
		assertEquals(hotelinfoVO1.getFacility(),hotelinfo.getBasicinfo("H00000001").getFacility());
		assertEquals(hotelinfoVO1.getIntroduction(),hotelinfo.getBasicinfo("H00000001").getIntroduction());
		assertEquals(hotelinfoVO1.getName(),hotelinfo.getBasicinfo("H00000001").getName());
		assertEquals(hotelinfoVO1.getTel(),hotelinfo.getBasicinfo("H00000001").getTel());
	}
}
