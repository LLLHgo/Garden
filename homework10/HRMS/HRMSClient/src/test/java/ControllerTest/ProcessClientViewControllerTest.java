package ControllerTest;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Enum.OrderType;
import Enum.ResultMessage;
import Enum.VIPType;
import Mock.MockClientManage;
import Mock.MockHotelinfoManage;
import Mock.MockOrderManage;
import businesslogic.clientbl.Client;
import datatool.HotelinfoDataTool;
import datatool.OrderDataTool;
import presentation.client.controller.ProcessClientViewController;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.ClientRequirementVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.orderVO.OrderVO;

public class ProcessClientViewControllerTest {
	private ProcessClientViewController controller;
	Client c1;
    Client c2;
    Client c3;
	@Before
	public void setUp(){
		 Date day1=new Date(1996,2,29);
		 File file=new File("credit");
		 Date day3=new Date(1992,5,29);
		c1 = new Client("C00000001","justfun","ErgouWang","13747474741",
				 VIPType.ORDINARYVIP,2,day1,"",file);
        c2 = new Client("C00000002","actullyjustfun","sangouWang","13747474742",
       		 VIPType.ENTERPRISEVIP,4,null,"Fake",file);
        c3 = new Client("C00000003","definitelyjustfun","sigouWang","13747474743",
       		 VIPType.ORDINARYVIP,1,day3,"",file);
	}

	/**
	 *通过客户ID得到客户个人信息
	 * @param clientID
	 * @return 客户的个人信息
	 */
	@Test
	public void getclientTest (){
		MockClientManage mc=new MockClientManage();
		assertEquals("ErgouWang",mc.getclient("C00000001").client_name);
		assertEquals("",mc.getclient("C00000001").client_firm);
		assertEquals("Fake",mc.getclient("C00000002").client_firm);
		assertEquals("13747474743",mc.getclient("C00000003").client_tel);
	}

	/**
	 *增加新客户
	 * @param vo
	 * @return 增加新用户成功与否
	 */
	@Test
	public void  createClientTest(){
		MockClientManage mc=new MockClientManage();
		ClientVO vo=mc.getclient("C00000001");
		assertEquals(ResultMessage.SUCCESS,mc.createClient(vo));
		vo=mc.getclient("C00000002");
		assertEquals(ResultMessage.SUCCESS,mc.createClient(vo));
		vo=mc.getclient("C00000003");
		assertEquals(ResultMessage.SUCCESS,mc.createClient(vo));
	}
	/**
	 *删除客户
	 * @param vo
	 * @return 删除用户成功与否
	 */
	@Test
	public void saveSitemanagerDeleteTest(){
		MockClientManage mc=new MockClientManage();
		assertEquals(ResultMessage.SUCCESS,mc.saveSitemanagerDelete("C00000001"));
		assertEquals(ResultMessage.SUCCESS,mc.saveSitemanagerDelete("C00000002"));
		assertEquals(ResultMessage.SUCCESS,mc.saveSitemanagerDelete("C00000003"));
	}
	/**
	 *设置（修改）某一客户信用值
	 * @param clientID
	 * @param recharge
	 * @return 修改信用值成功与否
	 */
	/*@Test
	public boolean setCredit(String clientID,int recharge){
		MockClientManage mc=new MockClientManage(clientID);
		return mc.setCredit(clientID,recharge);
	}*/
	/**
	 * 根据新的会员等级制度修改所有客户的会员等级
	 * @param vo
	 * @return 修改会员等级成功与否
	 */
	/*@Test
	public boolean setAllClientLevel(LevelVO vo){
		MockClientManage mc=new MockClientManage();
		return mc.setAllClientLevel(vo);
	}*/
	/**
	 * 通过完整正确的酒店关键词得到相关酒店列表
	 * @param vo
	 * @return符合关键词的酒店列表
	 */
	@Test
	public void getSearchHotelTest(){
		ClientRequirementVO vo=new ClientRequirementVO();
		MockHotelinfoManage mh=new MockHotelinfoManage();
		HotelinfoVO hvo1=HotelinfoDataTool.hotelinfoVO1;
		HotelinfoVO hvo2=HotelinfoDataTool.hotelinfoVO2;
		HotelinfoVO hvo3=HotelinfoDataTool.hotelinfoVO3;
		List<HotelinfoVO> list=mh.getBasicinfoList(vo);
		HotelinfoVO hvo=list.get(0);
		assertEquals(hvo1.getName(),hvo.getName());
		hvo=list.get(1);
		assertEquals(hvo2.getName(),hvo.getName());
		hvo=list.get(2);
		assertEquals(hvo3.getName(),hvo.getName());
	}
	/**
	 *得到具体日期的客户订单
	 * @param clientID
	 * @param date
	 * @return 该日期的客户订单
	 */
	@Test
	public void getSearchDateOrderTest(){
		String clientID="C00000002";
		Date date=new Date(2016,10,15);
		MockOrderManage mo=new MockOrderManage(clientID,date);
		List<OrderVO> list=mo.findSpecificDayClientOrder(clientID, date);
		OrderVO vo=list.get(0);
		assertEquals("20161015085702",vo.orderId);
		vo=list.get(1);
		assertEquals("20161015095706",vo.orderId);

	}
	/**
	 *得到具体酒店的客户订单
	 * @param clientID
	 * @param hotelID
	 * @return 该酒店的客户订单
	 */
	//@Test
	public List<OrderVO> getSearchHotelOrderTest( String clientID,String hotelID){
		MockOrderManage mo=new MockOrderManage(clientID);
		return mo.findSpecificHotelClientOrder(clientID,hotelID);
	}
	/**
	 *修改客户基本信息
	 * @param vo
	 * @return 修改个人信息成功与否提示信息
	 */
	@Test
	public  void updateInfoTest(){
		MockClientManage mc=new MockClientManage();
		ClientVO vo=mc.getclient("C00000001");
		assertEquals(ResultMessage.SUCCESS,mc.updateInfo(vo));
		vo=mc.getclient("C00000002");
		assertEquals(ResultMessage.SUCCESS,mc.updateInfo(vo));
	    assertEquals(ResultMessage.FAIL,mc.updateInfo(null));
	}
	/**
	 *创建订单
	 * @param orderID
	 * @return 创建成功与否
	 */
	@Test
	public void createOrder(){
		OrderVO vo=OrderDataTool.orderVO1;
		MockOrderManage mo=new MockOrderManage(vo);
		assertEquals(ResultMessage.SUCCESS,mo.createOrder(vo));
	}
	/**
	 *撤销订单
	 * @param orderID
	 * @return 撤销成功与否
	 */
	@Test
	public void repealOrder(){
		MockOrderManage mo=new MockOrderManage();
		assertEquals(ResultMessage.SUCCESS,mo.cancelOrder("20161015085702"));
		assertEquals(ResultMessage.SUCCESS,mo.cancelOrder("20161015095706"));
		assertEquals(ResultMessage.SUCCESS,mo.cancelOrder("20161017090702"));
	}
	/**
	 *得到客户的所有订单
	 * @param clientID
	 * @param order_type
	 * @return 所有订单列表
	 */
	@Test
	public void getAllOrderList(){
		MockOrderManage mo=new MockOrderManage();
		List<OrderVO> order=mo.findUserOrderList("C00000001");
		assertEquals("20161015085702",order.get(0).orderId);
		assertEquals("20161015095706",order.get(1).orderId);
		assertEquals("20161017090702",order.get(2).orderId);

	}
	/**
	 *得到客户某一类型的订单
	 * @param clientID
	 * @param order_type
	 * @return 类型订单列表
	 */
	@Test
	public void getOrderList(){
		MockOrderManage mo=new MockOrderManage();
		List<OrderVO> order=mo.findClientTypeOrder(OrderType.ABNORMAL,"C00000001");
		assertEquals("20161015085702",order.get(0).orderId);
		assertEquals("20161015095706",order.get(1).orderId);
		assertEquals("20161017090702",order.get(2).orderId);
	}
	/**
	 *得到客户的信用记录
	 * @param clientID
	 * @return 信用记录
	 */
	@Test
	public void getCreditRecord(){
		MockClientManage mc=new MockClientManage();
		File file=new File("credit");
		assertEquals(file,mc.getCreditRecord("C00000001"));
		assertEquals(file,mc.getCreditRecord("C00000002"));
		assertEquals(null,mc.getCreditRecord(null));
	}
	/**
	 *得到客户的历史预订酒店列表
	 * @param clientID
	 * @return 历史预订酒店列表
	 */
	@Test
	public void getHistoryList(){
		ClientRequirementVO vo=new ClientRequirementVO();
		MockHotelinfoManage mh=new MockHotelinfoManage();
		HotelinfoVO hvo1=HotelinfoDataTool.hotelinfoVO1;
		HotelinfoVO hvo2=HotelinfoDataTool.hotelinfoVO2;
		HotelinfoVO hvo3=HotelinfoDataTool.hotelinfoVO3;
		List<HotelinfoVO> list=mh.getBasicinfoList(vo);
		HotelinfoVO hvo=list.get(0);
		assertEquals(hvo1.getName(),hvo.getName());
		hvo=list.get(1);
		assertEquals(hvo2.getName(),hvo.getName());
		hvo=list.get(2);
		assertEquals(hvo3.getName(),hvo.getName());
	}


}
