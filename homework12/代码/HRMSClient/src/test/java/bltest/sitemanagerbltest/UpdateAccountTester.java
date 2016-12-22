package bltest.sitemanagerbltest;

import static org.junit.Assert.*;

import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.sitemanagerbl.SitemanagerManage;
import vo.sitemanager.SitemanagerVO;

public class UpdateAccountTester {
	SitemanagerManage sManage;
	private SitemanagerVO updateVO1;
	private SitemanagerVO updateVO2;
	private SitemanagerVO updateVO3;
	private SitemanagerVO updateVO4;
	private SitemanagerVO updateVO5;
	private SitemanagerVO updateVO6;
	
	public UpdateAccountTester(){
		updateVO1=new SitemanagerVO("S00000001","025-88888888","HRMSSitemanager");
		updateVO2=new SitemanagerVO("S00000001","","HRMSSitemanager");
		updateVO3=new SitemanagerVO("S00000001","025-88888888","");
		updateVO4=new SitemanagerVO("S00000001","025-88888887","HRMSSitemanager");
		updateVO5=new SitemanagerVO("S00000001","025-88888888","HRMS");
		updateVO6=new SitemanagerVO("S00000001","","");
		
		sManage=new SitemanagerManage();
		sManage.sitemanagerAcountShow();
	}
	@Test
	public void test1() {
		// 只修改电话 
		assertEquals(ResultMessage.SUCCESS,sManage.sitemanagerAccountUpdatePO(updateVO4));
	}
	@Test
	public void test2() {
		// 只修改密码
		assertEquals(ResultMessage.SUCCESS,sManage.sitemanagerAccountUpdatePO(updateVO5));
	}
	@Test
	public void test3() {
		// 不修改密码或电话，信息不变
		assertEquals(ResultMessage.SAMEINFO,sManage.sitemanagerAccountUpdatePO(updateVO1));
	}
	@Test
	public void test4() {
		// 电话为空
		assertEquals(ResultMessage.VOIDTEL,sManage.sitemanagerAccountUpdatePO(updateVO2));
	}
	@Test
	public void test5() {
		// 密码为空
		assertEquals(ResultMessage.VOIDPASSWORD,sManage.sitemanagerAccountUpdatePO(updateVO3));
	}
	@Test
	public void test6() {
		// 电话密码都为空
		assertEquals(ResultMessage.VOIDINFO,sManage.sitemanagerAccountUpdatePO(updateVO6));
	}

}
