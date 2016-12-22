package bltest.marketingtest;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.marketingbl.MarketingManage;
import vo.levelVO.LevelVO;

public class LevelTester {
	private MarketingManage manage=new MarketingManage();
	@Test
	public void test1(){
		List<LevelVO> levels=manage.findAllLevel();
		LevelVO vo0=levels.get(0);
		assertEquals(1,vo0.getLevel());
		assertEquals("新秀",vo0.getName());
		assertEquals(1000,vo0.getCreditNeeded(),0.0001);
		assertEquals(0.9,vo0.getDiscount(),0.0001);

		LevelVO vo1=levels.get(1);
		assertEquals(2,vo1.getLevel());
		assertEquals("少侠",vo1.getName());
		assertEquals(2000,vo1.getCreditNeeded(),0.0001);
		assertEquals(0.85,vo1.getDiscount(),0.0001);

		LevelVO vo2=levels.get(2);
		assertEquals(3,vo2.getLevel());
		assertEquals("大侠",vo2.getName());
		assertEquals(3000,vo2.getCreditNeeded(),0.0001);
		assertEquals(0.8,vo2.getDiscount(),0.0001);

		LevelVO vo3=levels.get(3);
		assertEquals(4,vo3.getLevel());
		assertEquals("掌门",vo3.getName());
		assertEquals(4000,vo3.getCreditNeeded(),0.0001);
		assertEquals(0.75,vo3.getDiscount(),0.0001);

		LevelVO vo4=levels.get(4);
		assertEquals(5,vo4.getLevel());
		assertEquals("宗师",vo4.getName());
		assertEquals(5500,vo4.getCreditNeeded(),0.0001);
		assertEquals(0.7,vo4.getDiscount(),0.0001);

		LevelVO vo5=levels.get(5);
		assertEquals(6,vo5.getLevel());
		assertEquals("盟主",vo5.getName());
		assertEquals(8000,vo5.getCreditNeeded(),0.0001);
		assertEquals(0.6,vo5.getDiscount(),0.0001);
	}

	@Test
	public void test2(){
		List<LevelVO> vos=new ArrayList<LevelVO>();
		vos.add(new LevelVO(1,"路人",1500,0.95));
		vos.add(new LevelVO(2,"主角",3600,0.8));
		vos.add(new LevelVO(3,"影帝",5000,0.5));
		assertEquals(ResultMessage.SUCCESS,manage.updateLevel(vos));
	}
}





