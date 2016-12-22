package bltest.strategytest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import Enum.HotelStrategy;
import Enum.VIPType;
import businesslogic.strategybl.StrategyManage;
import vo.strategyVO.HotelStrategyVO;

public class HotelStrategyGetTester {
	private StrategyManage manage=new StrategyManage();
	@Test
	public void test(){
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

		List<HotelStrategyVO> vo1s=manage.getHotelStrategy("H00000001");
		List<HotelStrategyVO> vo2s=manage.getHotelStrategy("H00000002");
		List<HotelStrategyVO> vo4s=manage.getHotelStrategy("H00000004");

		HotelStrategyVO get1=vo1s.get(1);
		HotelStrategyVO get2=vo4s.get(1);
		HotelStrategyVO get3=vo4s.get(0);
		HotelStrategyVO get4=vo2s.get(0);
		HotelStrategyVO get5=vo1s.get(0);

		assertEquals(vo1.getName(),get1.getName());
		assertEquals(vo1.getStartTime().get(Calendar.MONTH),get1.getStartTime().get(Calendar.MONTH));
		assertEquals(vo1.getEndTime().get(Calendar.MONTH),get1.getEndTime().get(Calendar.MONTH));
		assertEquals(vo1.getDiscount(),get1.getDiscount(),0.0001);
		assertEquals(vo1.getType(),get1.getType());


		assertEquals(vo2.getName(),get2.getName());
		assertEquals(vo2.getStartTime().get(Calendar.MONTH),get2.getStartTime().get(Calendar.MONTH));
		assertEquals(vo2.getEndTime().get(Calendar.MONTH),get2.getEndTime().get(Calendar.MONTH));
		assertEquals(vo2.getDiscount(),get2.getDiscount(),0.0001);
		assertEquals(vo2.getType(),get2.getType());

		assertEquals(vo3.getName(),get3.getName());
		assertEquals(vo3.getStartTime().get(Calendar.MONTH),get3.getStartTime().get(Calendar.MONTH));
		assertEquals(vo3.getEndTime().get(Calendar.MONTH),get3.getEndTime().get(Calendar.MONTH));
		assertEquals(vo3.getDiscount(),get3.getDiscount(),0.0001);
		assertEquals(vo3.getType(),get3.getType());

		assertEquals(vo4.getName(),get4.getName());
		assertEquals(vo4.getStartTime().get(Calendar.MONTH),get4.getStartTime().get(Calendar.MONTH));
		assertEquals(vo4.getEndTime().get(Calendar.MONTH),get4.getEndTime().get(Calendar.MONTH));
		assertEquals(vo4.getDiscount(),get4.getDiscount(),0.0001);
		assertEquals(vo4.getType(),get4.getType());
		assertEquals(vo4.getMinRooms(),get4.getMinRooms());

		assertEquals(vo5.getName(),get5.getName());
		assertEquals(vo5.getStartTime().get(Calendar.MONTH),get5.getStartTime().get(Calendar.MONTH));
		assertEquals(vo5.getEndTime().get(Calendar.MONTH),get5.getEndTime().get(Calendar.MONTH));
		assertEquals(vo5.getDiscount(),get5.getDiscount(),0.0001);
		assertEquals(vo5.getType(),get5.getType());
		assertEquals(vo5.getMinRooms(),get5.getMinRooms());
		assertEquals(vo5.getMinSum(),get5.getMinSum(),0.00001);
		assertEquals(vo5.getLevel(),get5.getLevel());
		assertEquals(vo5.getVipKinds().get(0),get5.getVipKinds().get(0));
		assertEquals(vo5.getVipKinds().get(1),get5.getVipKinds().get(1));


	}
}
