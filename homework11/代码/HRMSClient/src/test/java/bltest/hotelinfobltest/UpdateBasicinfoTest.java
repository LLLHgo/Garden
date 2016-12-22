package bltest.hotelinfobltest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Enum.ResultMessage;
import Enum.Star;
import businesslogic.hoteinfobl.HotelinfoManage;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;

public class UpdateBasicinfoTest {
	HotelinfoManage hotelinfo = new HotelinfoManage();
	static ArrayList<String> remark = new ArrayList<String>();
	static{
		remark.add("buzhidao");
	}
	static HotelinfoVO hotelinfoVO1 = new HotelinfoVO("HanTing","BeijingDongRode","山西路商圈","12345678",new ArrayList<RoominfoVO>(),Star.FOUR,
			remark,"Brief Introduction","H00000001");
	static{
		hotelinfoVO1.setFacility("设施");
	}
	@Test
	public void test1(){
		//更新成功
		assertEquals(ResultMessage.SUCCESS,hotelinfo.updateBassicinfo(hotelinfoVO1));	
	}
	
	@Test
	public void test2(){
		//更新失败
		assertEquals(ResultMessage.VOIDINFO,hotelinfo.updateBassicinfo(null));	
	}
	
}
