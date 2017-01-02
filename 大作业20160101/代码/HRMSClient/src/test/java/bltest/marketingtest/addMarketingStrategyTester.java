package bltest.marketingtest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import Enum.MarketingStrategy;
import Enum.ResultMessage;
import Enum.VIPType;
import businesslogic.marketingbl.MarketingManage;
import businesslogic.strategybl.StrategyManage;
import vo.strategyVO.MarketingStrategyVO;

public class addMarketingStrategyTester {
	private StrategyManage Smanage=new StrategyManage();

	@Test
	public void addPeriodTest(){
	    Calendar begin=Calendar.getInstance();
	    Calendar end=Calendar.getInstance();
		begin.set(2017,10,10,23,57);
		end.set(2017,10,11,23,59);
		MarketingStrategyVO vo=new MarketingStrategyVO("2017双11",MarketingStrategy.PERIOD,begin,end,0.8);
		assertEquals(ResultMessage.SUCCESS,Smanage.addMarketingStrategy(vo));
		assertEquals(ResultMessage.DUPLICATESTRATEGY,Smanage.addMarketingStrategy(vo));
	}

	@Test
	public void addSpecialTest(){
		Calendar begin=Calendar.getInstance();
	    Calendar end=Calendar.getInstance();
		begin.set(2017,9,1,23,59);
		end.set(2017,9,7,23,59);
		int[] levels={1,2};
		double[] discounts={0.75,0.7};
		MarketingStrategyVO vo=new MarketingStrategyVO("栖霞专属",MarketingStrategy.VIPSPECIAL,begin,end,"栖霞区商圈",levels,discounts);
		assertEquals(ResultMessage.SUCCESS,Smanage.addMarketingStrategy(vo));
		assertEquals(ResultMessage.DUPLICATESTRATEGY,Smanage.addMarketingStrategy(vo));
	}

	@Test
	public void addNewTest(){
		Calendar begin=Calendar.getInstance();
	    Calendar end=Calendar.getInstance();
		begin.set(2017,9,1,23,59);
		end.set(2017,9,7,23,59);
		List<String> hotels=new ArrayList<String>();
		hotels.add("南京悦宁宾馆");
		List<VIPType> viptypes=new ArrayList<VIPType>();
		viptypes.add(VIPType.ENTERPRISEVIP);
		MarketingStrategyVO vo=new MarketingStrategyVO("新增",MarketingStrategy.CREATED,begin,end,0.75,hotels,666,2,1,viptypes);
		assertEquals(ResultMessage.SUCCESS,Smanage.addMarketingStrategy(vo));
		assertEquals(ResultMessage.DUPLICATESTRATEGY,Smanage.addMarketingStrategy(vo));
	}

}
