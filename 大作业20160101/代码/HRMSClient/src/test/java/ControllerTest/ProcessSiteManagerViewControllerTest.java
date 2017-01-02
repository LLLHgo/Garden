package ControllerTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import Enum.ResultMessage;
import Mock.MockClientManage;
import Mock.MockHotelinfoManage;
import Mock.MockHotelstaffManage;
import Mock.MockLogManage;
import Mock.MockMarketingManage;
import Mock.MockSitemanagerManage;
import datatool.ClientDataTool;
import datatool.HotelinfoDataTool;
import datatool.HotelstaffDataTool;
import datatool.LogDataTool;
import datatool.MarketingDataTool;
import datatool.SitemanagerDataTool;
import vo.clientVO.ClientVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.logVO.LogVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanagerVO.SitemanagerVO;

/**
 * sitemanager的controller类的测试
 * @author yilu
 *
 */
/*
public class ProcessSiteManagerViewControllerTest {
	MockSitemanagerManage ms;
	MockClientManage mc;
	MockHotelinfoManage mh;
	MockHotelstaffManage mhs;
	MockLogManage ml;
	LogDataTool logDataTool;
	ClientDataTool clientDataTool;
	SitemanagerDataTool sitemanagerDataTool;
	MarketingDataTool marketingDataTool;
	HotelinfoDataTool hotelinfoDataTool;
	HotelstaffDataTool hotelstaffDataTool;
	String clientId;
	String findinfo;
	String findinfoMarketing;
	String findinfoHotelstaff;
	boolean resultB;
	ClientVO clientVO;
	SitemanagerVO accountVO;
	MarketingVO marketingVO;
	HotelstaffVO hotelstaffVO;
	ResultMessage result;
	String logInfo;
	MockMarketingManage mm;
	
	@Before
	public void setUp(){
	    ms=new MockSitemanagerManage();
		mc=new MockClientManage();
		mh=new MockHotelinfoManage();
		mhs=new MockHotelstaffManage();
		mm=new MockMarketingManage();
		ml=new MockLogManage();
		logDataTool=new LogDataTool();
	    clientDataTool=new ClientDataTool();
	    sitemanagerDataTool=new SitemanagerDataTool();
	    hotelstaffDataTool=new HotelstaffDataTool();
	    marketingDataTool=new MarketingDataTool();
	    hotelinfoDataTool=new HotelinfoDataTool();
	    clientId="C00000002";
		findinfo="C00000001";
		findinfoMarketing="M00000001";
		findinfoHotelstaff="H00000001";
		accountVO=SitemanagerDataTool.sitemanagerVO;
		result=ResultMessage.SUCCESS;
		logInfo="";
		
	}

	@Test
	public void clientAccountUpdateTest() {
		// TODO Auto-generated method stub
		ClientVO clientVO=ClientDataTool.clientVO1;
		assertEquals(ResultMessage.SUCCESS,mc.updateInfo(clientVO));
	}

	//@Test
	public void accountDeleteTest(String userId) {
		// TODO Auto-generated method stub
		//result=ms.saveSitemanagerDelete(userId);
		//assertEquals(ResultMessage.SUCCESS,result);
		assertEquals(true,mm.saveSitemanagerDelete(marketingVO));
		assertEquals(ResultMessage.SUCCESS,mc.saveSitemanagerDelete(clientId));
		
	}

	@Test
	public void clientAccountFindTest() {
		// TODO Auto-generated method stub
	    ClientVO clientVOExpected=ClientDataTool.clientVO1;
	    ClientVO clientVOReal=mc.getclient(findinfo);
	    assertEquals(clientVOExpected.getBirth(),clientVOReal.getBirth());
	    assertEquals(clientVOExpected.getCreditRecord(),clientVOReal.getCreditRecord());
	    assertEquals(clientVOExpected.getFirm(),clientVOReal.getFirm());
	    assertEquals(clientVOExpected.getID(),clientVOReal.getID());
	    assertEquals(clientVOExpected.getLevel(),clientVOReal.getLevel());
	    assertEquals(clientVOExpected.getName(),clientVOReal.getName());
	    assertEquals(clientVOExpected.getPassword(),clientVOReal.getPassword());
	    assertEquals(clientVOExpected.getTel(),clientVOReal.getTel());
	    assertEquals(clientVOExpected.getType(),clientVOReal.getType());
	}

	@Test
	public void MarketingAccountAddTest() {
		// TODO Auto-generated method stub
		resultB=mm.saveSitemanagerAdd(marketingVO);
		assertEquals(true,resultB);
	}

	@Test
	public void MarketingAccountUpdateTest() {
		// TODO Auto-generated method stub
		result=mm.siteManagerUpdate(marketingVO);
		assertEquals(ResultMessage.SUCCESS,result);
	}

	@Test
	public void MarketingAccountFindTest() {
		// TODO Auto-generated method stub
		MarketingVO marketingVOReal=mm.returnSitemanagerAccount(findinfoMarketing);
		MarketingVO marketingVOExpected=MarketingDataTool.V1;
		assertEquals(marketingVOExpected.getMarketingID(),marketingVOReal.getMarketingID());
		assertEquals(marketingVOExpected.getName(),marketingVOReal.getName());
		assertEquals(marketingVOExpected.getPassword(),marketingVOReal.getPassword());
		assertEquals(marketingVOExpected.getTelephone(),marketingVOReal.getTelephone());
	}

	@Test
	public void MarketingAccountDeleteTest() {
		// TODO Auto-generated method stub
		assertEquals(true,mm.saveSitemanagerDelete(marketingVO));
	}

	@Test
	public void HotelAccountAddTest() {
		// TODO Auto-generated method stub
		assertEquals(true,mh.saveSitemanagerAdd(HotelinfoDataTool.hotelinfoVO1));
	}

	@Test
	public void HotelStaffAccountFindTest() {
		// TODO Auto-generated method stub
		HotelstaffVO hotelStaffVORreal=mhs.returnSitemanagerAccount(findinfoHotelstaff);
		HotelstaffVO hotelStaffVOExpected=HotelstaffDataTool.hotelstaffVO1;
		assertEquals(hotelStaffVOExpected.getHotelID(),hotelStaffVORreal.getHotelID());
		assertEquals(hotelStaffVOExpected.getPassword(),hotelStaffVORreal.getPassword());
		assertEquals(hotelStaffVOExpected.getTel(),hotelStaffVORreal.getTel());
		
	}

	@Test
	public void HotelStaffAccountUpdateTest() {
		// TODO Auto-generated method stub
		assertEquals(ResultMessage.SUCCESS,mhs.saveSitemanagerUpdate(HotelstaffDataTool.hotelstaffVO1));
		
	}

	@Test
	public void sitemanagerAcountShowTest() {
		// TODO Auto-generated method stub
		SitemanagerVO sitemanagerVOReal=ms.sitemanagerAcountShow();
		SitemanagerVO sitemanagerVOExpexted=SitemanagerDataTool.sitemanagerVO;
		assertEquals(sitemanagerVOExpexted.getPassword(),sitemanagerVOReal.getPassword());
		assertEquals(sitemanagerVOExpexted.getSitemanagerId(),sitemanagerVOReal.getSitemanagerId());
		assertEquals(sitemanagerVOExpexted.getSitemanagerPhoneNumber(),sitemanagerVOReal.getSitemanagerPhoneNumber());
	}

	@Test
	public void sitemanagerAccountUpdateTest() {
		// TODO Auto-generated method stub
		result=ms.sitemanagerAccountUpdate(accountVO);
		assertEquals(ResultMessage.SUCCESS,result);
	}

	@Test
	public void checkAccountTest() {
		// TODO Auto-generated method stub
		SitemanagerVO sitemanagerVOReal=SitemanagerDataTool.sitemanagerVO;
		resultB=ms.checkAccount(sitemanagerVOReal);
		assertEquals(true,resultB);
	}

	@Test
	public void findLogTestTest() {
		// TODO Auto-generated method stub
		ArrayList<LogVO> listReal=ml.getLog();
		ArrayList<LogVO> listExpected=LogDataTool.logList;
		Iterator<LogVO> it1=listReal.iterator();
		Iterator<LogVO> it2=listExpected.iterator();
		while(it1.hasNext()){
			assertEquals(it2.next().getLogInfo(),it1.next().getLogInfo());
		}
		
	}

	@Test
	public void addLogTest() {
		// TODO Auto-generated method stub
		result=ml.addLog(logInfo);
		assertEquals(ResultMessage.SUCCESS,result);
	}
	

}
*/