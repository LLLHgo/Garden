package bltest.orderbltest.orderOperatorTester;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Enum.OrderType;
import Enum.ResultMessage;
import Enum.VIPType;
import businesslogic.orderbl.OrderOperator;
import vo.orderVO.OrderVO;

public class CreateOrderPOTester {
	
	OrderOperator operator;
	OrderVO orderVO1;
	OrderVO orderVO2;
	OrderVO orderVO3;
	OrderVO orderVO4;
	OrderVO orderVO5;
	OrderVO orderVO6;
	OrderVO orderVO7;
	ArrayList<String> strategy;
	public CreateOrderPOTester(){
		operator=new OrderOperator();
		strategy=new ArrayList<String>();
		strategy.add("圣诞节bonus！！");
		strategy.add("新年bonus！");
		orderVO1=new OrderVO("","C00000001","小螺丝","16679876372",VIPType.ORDINARYVIP,"2016-12-01 12:23:28",
			OrderType.NORMALNONEXEC,"冠军楼酒店","H00000010",340.28,strategy,"大床房",1,1,"2016-12-23 12:00:00",
			null,"2016-12-24 12:00:00");
		orderVO2=new OrderVO("","C00000001","小螺丝","16679876372",VIPType.ORDINARYVIP,"2016-12-01 12:23:28",
				OrderType.ABNORMAL,"lll","H00000010",340.28,strategy,"大床房",1,1,"2016-12-23 12:00:00",
				null,"2016-12-24 12:00:00");
		orderVO3=new OrderVO("","C00000001","小螺丝","",VIPType.ENTERPRISEVIP,"2016-12-01 12:23:28",
				OrderType.NORMALNONEXEC,"冠军楼酒店","H00000010",340.28,strategy,"大床房",1,1,"2016-12-23 12:00:00",
				null,"2016-12-24 12:00:00");
		orderVO4=new OrderVO("","C00000001","小螺丝","",VIPType.ENTERPRISEVIP,"2016-12-01 12:23:28",
				OrderType.NORMALNONEXEC,"冠军楼酒店","H00000010",340.28,null,"大床房",1,1,"2016-12-23 12:00:00",
				null,"2016-12-24 12:00:00");
		orderVO5=new OrderVO("","C00000001","小螺丝","",VIPType.ENTERPRISEVIP,"2016-12-01 12:23:28",
				OrderType.NORMALNONEXEC,"冠军楼酒店","H00000010",340.28,null,"大床房",0,1,"2016-12-23 12:00:00",
				null,"2016-12-24 12:00:00");
		orderVO6=new OrderVO("","C00000001","小螺丝","",VIPType.ENTERPRISEVIP,"2016-12-01 12:23:28",
				OrderType.NORMALNONEXEC,"冠军楼酒店","H00000010",340.28,null,"大床房",1,0,"2016-12-23 12:00:00",
				null,"2016-12-24 12:00:00");
		orderVO7=new OrderVO("","C00000001","小螺丝","",VIPType.ENTERPRISEVIP,"2016-12-01 12:23:28",
				OrderType.NORMALNONEXEC,"冠军楼酒店","H00000010",340.28,null,"大床房",1,1,"2016-12-01 12:00:00",
				null,"2016-12-03 12:00:00");
	}
	// 完整订单
	@Test
	public void test1() {
		assertEquals(ResultMessage.SUCCESS,operator.createOrderPO(orderVO1));
	}
	// 订单状态错误
	@Test
	public void test2() {
		assertEquals(ResultMessage.WORNGORDERTYPEWHENCREATE,operator.createOrderPO(orderVO2));
	}
	// 缺少一个数据
	@Test
	public void test3() {
		assertEquals(ResultMessage.HASVOID,operator.createOrderPO(orderVO3));
	}
	// 缺少2个数据
	@Test
	public void test4() {
		assertEquals(ResultMessage.HASVOID,operator.createOrderPO(orderVO4));
	}
	// 订了0间房间
	@Test
	public void test5() {
		assertEquals(ResultMessage.NOROOMORDERED,operator.createOrderPO(orderVO5));
	}
	// 订了0天
	@Test
	public void test6() {
		assertEquals(ResultMessage.NODAYORDERED,operator.createOrderPO(orderVO6));
	}
	// 订单预计入住时间在下订单日期之前
	@Test
	public void test7() {
		assertEquals(ResultMessage.STARTDAYNOTALLOWED,operator.createOrderPO(orderVO7));
	}
	
}
