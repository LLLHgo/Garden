package bltest.strategytest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import Enum.MarketingStrategy;
import Enum.ResultMessage;
import Enum.VIPType;
import businesslogic.strategybl.StrategyManage;
import vo.strategyVO.MarketingStrategyVO;

public class StrategyGetTester {
	private StrategyManage manage=new StrategyManage();

	@Test
	public void getMarketingStrategyTest(){
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
		MarketingStrategyVO vo2=new MarketingStrategyVO("元旦特惠",MarketingStrategy.PERIOD,begin1,end1,0.78);
		MarketingStrategyVO vo1=new MarketingStrategyVO("仙林圣诞优惠",MarketingStrategy.VIPSPECIAL,begin2,end2,"仙林大学城",levels,discounts);
		MarketingStrategyVO vo3=new MarketingStrategyVO("寒冷的冬天还好有你",MarketingStrategy.CREATED,begin3,end3,0.85,hotels,400,3,2,viptypes);


		List<MarketingStrategyVO> list=manage.getMarketingStrategy();

		MarketingStrategyVO get1=list.get(0);
		MarketingStrategyVO get2=list.get(1);
		MarketingStrategyVO get3=list.get(2);

		assertEquals(vo1.getName(),get1.getName());
		assertEquals(vo1.getType(),get1.getType());
		assertEquals(vo1.getStartTime().get(Calendar.DATE),get1.getStartTime().get(Calendar.DATE));
		assertEquals(vo1.getEndTime().get(Calendar.DATE),get1.getEndTime().get(Calendar.DATE));
		assertEquals(vo1.getDiscount(),get1.getDiscount(),0.0001);


		assertEquals(vo2.getName(),get2.getName());
		assertEquals(vo2.getType(),get2.getType());
		assertEquals(vo2.getBusinessDistrict(),get2.getBusinessDistrict());
		assertEquals(vo2.getStartTime().get(Calendar.DATE),get2.getStartTime().get(Calendar.DATE));
		assertEquals(vo2.getEndTime().get(Calendar.DATE),get2.getEndTime().get(Calendar.DATE));

		assertEquals(vo3.getName(),get3.getName());
		assertEquals(vo3.getType(),get3.getType());
		assertEquals(vo3.getStartTime().get(Calendar.DATE),get3.getStartTime().get(Calendar.DATE));
		assertEquals(vo3.getEndTime().get(Calendar.DATE),get3.getEndTime().get(Calendar.DATE));
		assertEquals(vo3.getHotels().get(0),get3.getHotels().get(0));
		assertEquals(vo3.getHotels().get(1),get3.getHotels().get(1));
		assertEquals(vo3.getHotels().get(2),get3.getHotels().get(2));
		assertEquals(vo3.getDiscount(),get3.getDiscount(),0.0001);
		assertEquals(vo3.getMinLevel(),get3.getMinLevel());
		assertEquals(vo3.getMinRooms(),get3.getMinRooms());
		assertEquals(vo3.getMinSum(),get3.getMinSum(),0.00001);
		assertEquals(vo3.getVipKinds().get(0),get3.getVipKinds().get(0));

	}


	@Test
	public void delete(){
		assertEquals(ResultMessage.SUCCESS,manage.deleteMarketingStrategy("仙林圣诞"));
	}
}
