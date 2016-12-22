package bltest.strategytest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import Enum.MarketingStrategy;
import Enum.ResultMessage;
import Enum.VIPType;
import businesslogic.strategybl.StrategyManage;
import vo.strategyVO.MarketingStrategyVO;

public class MarketingStrategyAddTester {
	private StrategyManage manage=new StrategyManage();

	@Test
	public void marketingStrategyAddTest(){
	    Calendar begin1=Calendar.getInstance();
		Calendar end1=Calendar.getInstance();
		Calendar begin2=Calendar.getInstance();
	    Calendar end2=Calendar.getInstance();
		Calendar begin3=Calendar.getInstance();
		Calendar end3=Calendar.getInstance();
		begin1.set(2016,11,30,23,59,00);
		end1.set(2017,0,1,23,59,00);
		begin2.set(2016,11,24,00,00,00);
		end2.set(2016,11,25,00,00,00);
		begin3.set(2016,11,31,00,00,00);
		end3.set(2017,0,30,23,59,00);

		int[] levels={1,2,3,4};
		double[] discounts={0.9,0.85,0.8,0.75};
		List<String> hotels=new ArrayList<String>();
		hotels.add("南京颐和");
		hotels.add("和园");
		hotels.add("南京悦宁宾馆");
		List<VIPType> viptypes=new ArrayList<VIPType>();
		viptypes.add(VIPType.ENTERPRISEVIP);

		MarketingStrategyVO vo1=new MarketingStrategyVO("元旦特惠",MarketingStrategy.PERIOD,begin1,end1,0.78);
		MarketingStrategyVO vo2=new MarketingStrategyVO("仙林圣诞优惠",MarketingStrategy.VIPSPECIAL,begin2,end2,"仙林大学城",levels,discounts);
		MarketingStrategyVO vo3=new MarketingStrategyVO("寒冷的冬天还好有你",MarketingStrategy.CREATED,begin3,end3,0.85,hotels,400,3,2,viptypes);
		assertEquals(ResultMessage.SUCCESS,manage.addMarketingStrategy(vo1));
		assertEquals(ResultMessage.SUCCESS,manage.addMarketingStrategy(vo2));
		assertEquals(ResultMessage.SUCCESS,manage.addMarketingStrategy(vo3));
	}
}



































