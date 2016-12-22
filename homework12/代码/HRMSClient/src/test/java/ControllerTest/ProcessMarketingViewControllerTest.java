package ControllerTest;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Enum.ResultMessage;
import Enum.VIPType;
import Mock.*;
import datatool.ClientDataTool;
import datatool.LevelDataTool;
import datatool.MarketingStrategyDataTool;
import datatool.OrderDataTool;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.MarketingStrategyVO;

public class ProcessMarketingViewControllerTest {
	private MockStrategyManage sm;
	private MockClientManage cm;
	private MockOrderManage om;
	private MockLogManage lm;
	private Date date;

	@Before
	public void setup(){
		sm=new MockStrategyManage();
		cm=new MockClientManage();
		om=new MockOrderManage();
		lm=new MockLogManage();
		date=new Date(2016,10,17);
	}
	@Test
	public void testgetClient() {
        ClientVO cvo=ClientDataTool.clientVO1;
        assertEquals(cvo.client_birth,cm.getclient("C00000001").client_birth);
	}

	@Test
	public void testsetAllClientLevel(){
		LevelVO lvo=LevelDataTool.v1;
		assertEquals(true,cm.setAllClientLevel(lvo));
	}

	@Test
	public void testfindAbnormalOrderList(){
		OrderVO ov1=OrderDataTool.orderVO1,ov2=OrderDataTool.orderVO2,ov3=OrderDataTool.orderVO7;
		List<OrderVO> olist=om.findAbnormalOrderList(date);
		//assertEquals(true,olist.contains(ov1));
		//assertEquals(true,olist.contains(ov2));

	}
	@Test
	public void testfindSpecificAbnormalOrder(){
		OrderVO vo=OrderDataTool.orderVO1;
		assertEquals(vo.getClientId(),om.findSpecificOrder("20161015085702").getClientId());
	}

	@Test
	public  void testsaveAbnormalOrder(){
		OrderVO vo=OrderDataTool.orderVO5;
		assertEquals(ResultMessage.SUCCESS,om.saveOrder(vo));
	}

	@Test
	public void testaddMarketingStrategy(){
		MarketingStrategyVO ms=MarketingStrategyDataTool.V1;
		assertEquals(true,sm.addMarketingStrategy(ms));
	}
	@Test
	public void testdeleteMarketingStrategy(){
		MarketingStrategyVO ms=MarketingStrategyDataTool.V1;
		assertEquals(true,sm.deleteMarketingStrategy(ms));
	}

	@Test
	public void testgetMarketingStrategy(){
		MarketingStrategyVO ms1=MarketingStrategyDataTool.V1;
		MarketingStrategyVO ms2=MarketingStrategyDataTool.V2;
		MarketingStrategyVO ms3=MarketingStrategyDataTool.V3;
		assertEquals(true,sm.getMarketingStrategy("M000001").contains(ms1));
		assertEquals(true,sm.getMarketingStrategy("M000001").contains(ms2));
		assertEquals(true,sm.getMarketingStrategy("M000001").contains(ms3));
	}


	@Test
	public void testaddLog(){
		String log="2016-08-10 09:21:22 M0000001 修改异常订单状态";
		assertEquals(ResultMessage.SUCCESS,lm.addLog(log));
	}
}
