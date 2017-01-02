package bltest.strategytest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import Enum.HotelStrategy;
import Enum.ResultMessage;
import Enum.VIPType;
import businesslogic.strategybl.StrategyManage;
import vo.strategyVO.HotelStrategyVO;

public class HotelStrategyUpdateTester {
	private StrategyManage manage=new StrategyManage();

	@Test
	public void getMarketingStrategyTest(){
		Calendar begin1=Calendar.getInstance();
		Calendar end1=Calendar.getInstance();
		Calendar begin2=Calendar.getInstance();
	    Calendar end2=Calendar.getInstance();
		Calendar begin3=Calendar.getInstance();
		Calendar end3=Calendar.getInstance();
		Calendar begin4=Calendar.getInstance();
	    Calendar end4=Calendar.getInstance();
		Calendar begin5=Calendar.getInstance();
		Calendar end5=Calendar.getInstance();
		begin1.set(2016,11,30,23,59,00);
		end1.set(2017,0,1,23,59,00);
		begin2.set(2016,11,24,00,00,00);
		end2.set(2016,11,25,00,00,00);
		begin3.set(2016,11,31,00,00,00);
		end3.set(2017,0,30,23,59,00);
		begin4.set(2016,11,24,00,00,00);
		end4.set(2016,11,25,00,00,00);
		begin5.set(2016,11,31,00,00,00);
		end5.set(2017,0,30,23,59,00);
		List<VIPType> viptypes=new ArrayList<VIPType>();
		viptypes.add(VIPType.ORDINARYVIP);
		viptypes.add(VIPType.ENTERPRISEVIP);
		HotelStrategyVO vo1=new HotelStrategyVO("来啊 诗和远方","H00000001",HotelStrategy.BIRTHDAY,VIPType.ORDINARYVIP,begin1,end1,0.74);
		HotelStrategyVO vo2=new HotelStrategyVO("我的漂泊就是在向你靠近","H00000004",HotelStrategy.COMPANY,VIPType.ENTERPRISEVIP,begin2,end2,0.87);
		HotelStrategyVO vo3=new HotelStrategyVO("Where are you?","H00000004",HotelStrategy.SPECIALDAY,begin3,end3,0.68);
		HotelStrategyVO vo4=new HotelStrategyVO("我要水蜜桃","H00000002",HotelStrategy.OVERTHREEROOMS,begin4,end4,0.92,2);
		HotelStrategyVO vo5=new HotelStrategyVO("love me like you do","H00000001",HotelStrategy.CREATED,viptypes,begin5,end5,0.4,3,678,2);
		assertEquals(ResultMessage.SUCCESS,manage.updateHotelStrategy(vo1));
		assertEquals(ResultMessage.SUCCESS,manage.updateHotelStrategy(vo2));
		assertEquals(ResultMessage.SUCCESS,manage.updateHotelStrategy(vo3));
		assertEquals(ResultMessage.SUCCESS,manage.updateHotelStrategy(vo4));
		assertEquals(ResultMessage.SUCCESS,manage.updateHotelStrategy(vo5));

	}

}
































