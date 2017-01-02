package bltest.marketingtest;


import static org.junit.Assert.assertEquals;

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
		LevelVO vo1=new LevelVO(1,"铜牌",1000,0.9);
		LevelVO vo2=new LevelVO(2,"银牌",2000,0.85);
		LevelVO vo3=new LevelVO(3,"金牌",3000,0.8);
		List<LevelVO> vos=new ArrayList<LevelVO>();
		vos.add(vo1);
		vos.add(vo2);
		vos.add(vo3);
		assertEquals(ResultMessage.SUCCESS,manage.updateLevel(vos));
	}


}





