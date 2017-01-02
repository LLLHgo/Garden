package bltest.orderbltest.orderFindTester;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import businesslogic.orderbl.OrderFind;
import dataservice.orderdataservice.OrderDataService;
import dataservice.orderdataservice.OrderDataService_Stub;
import datatool.OrderDataTool;
import po.OrderPO;
import vo.orderVO.OrderVO;
/**
 * 订单模块的orderFind的测试2
 * @author yilu
 *
 */
public class FindSpecificOrderTester {

	OrderFind orderFind;
	OrderDataService orderDataService;
	OrderDataTool findTester;
	OrderPO orderVO;
	OrderPO orderPO;
	public FindSpecificOrderTester(){
		orderFind=new OrderFind();
		findTester=new OrderDataTool();
		try {
			orderDataService=new OrderDataService_Stub();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		orderPO=findTester.orderPOFindTester;
	}
	@Test
	public void test1() {
		// 客户帐号，订单帐号  找到
		assertEquals(true,orderPO.getClientPhone().equals(orderFind.findSpecificOrder("C00000001", "000000001").getClientPhone()));
	}
	
	@Test
	public void test2() {
		// 酒店帐号，订单帐号  找到
		assertEquals(true,orderPO.getClientPhone().equals(orderFind.findSpecificOrder("H00000010", "000000001").getClientPhone()));
	}

	@Test
	public void test3() {
		// 网站营销人员帐号，订单帐号  没找到
		assertEquals(null,orderFind.findSpecificOrder("M00000001", "000000001"));
	}
	
	@Test
	public void test4() {
		//  客户帐号和订单中的客户信息不匹配 没找到
		assertEquals(null,orderFind.findSpecificOrder("C00000002", "000000001"));
	}
	
	@Test
	public void test5() {
		// 酒店工作人员帐号与订单中的酒店张哈不匹配， 没找到
		assertEquals(null,orderFind.findSpecificOrder("H00000001", "000000001"));
	}
	
	@Test
	public void test6() {
		// 订单号过大
		assertEquals(null,orderFind.findSpecificOrder("C00000001", "000000106"));
	}
	
}
