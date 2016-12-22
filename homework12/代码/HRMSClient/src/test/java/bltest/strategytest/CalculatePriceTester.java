package bltest.strategytest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Enum.RoomState;
import Enum.Star;
import Enum.VIPType;
import businesslogic.strategybl.StrategyManage;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;

public class CalculatePriceTester {
	private StrategyManage manage=new StrategyManage();
	private ClientVO clientvo=new ClientVO("C00000001","justfun","ErgouWang","13747474741",
			VIPType.ENTERPRISEVIP,2,"1996-02-29","南京大学",100,new ArrayList<String>());
	private RoominfoVO roominfo1 = new RoominfoVO("H00000001","标准间","8304",200, RoomState.Usable);
	public  HotelinfoVO hotelinfoVO1 = new HotelinfoVO("凯撒大酒店","BeijingDongRode","仙林大学城",
			"12345678",new ArrayList<RoominfoVO>(),Star.FOUR,new ArrayList<String>(),"Brief Introduction","H00000001");

	@Test
	public void marketingPeriodTest(){
		ArrayList<String> l=new ArrayList<String>();
		l.add("南京大学");
		hotelinfoVO1.setCompany(l);
		assertEquals(40.04,((manage.calculatePrice(clientvo, roominfo1, hotelinfoVO1,2)).getPrice()),0.000001);
	}
}
