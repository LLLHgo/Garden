package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.hoteinfobl.HotelinfoManage;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;

public class SaveSitemanagerAddTest {

	HotelinfoManage hotelinfo = new HotelinfoManage();
	SitemanagerAddVO sVO1 = new SitemanagerAddVO("LLLH酒店");
	SitemanagerAddVO sVO2 = new SitemanagerAddVO("新酒店");
	HotelstaffVO hVO = new HotelstaffVO("H00000002","000000","123456");
	@Test
	public void test1(){
		//成功
		assertEquals(ResultMessage.SUCCESS,hotelinfo.saveSitemanagerAdd(sVO2, hVO));
	}
	
	@Test
	public void test2(){
		//因为酒店名称重复而导致的失败
		assertEquals(ResultMessage.DUPLICATENAME,hotelinfo.saveSitemanagerAdd(sVO1, hVO));
	}
}
