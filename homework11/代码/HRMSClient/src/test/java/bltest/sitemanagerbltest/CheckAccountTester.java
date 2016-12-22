package bltest.sitemanagerbltest;

import static org.junit.Assert.*;

import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.sitemanagerbl.SitemanagerManage;
import vo.sitemanager.SitemanagerVO;

public class CheckAccountTester {
	SitemanagerManage sManage;
	private SitemanagerVO accountVO1;
	private SitemanagerVO accountVO2;
	private SitemanagerVO accountVO3;
	private SitemanagerVO accountVO4;
	
	public CheckAccountTester(){
		accountVO1=new SitemanagerVO("S00000002","025-88888888","HRMSSitemanager");
		accountVO2=new SitemanagerVO("S00000001","025-88888888","HRMS");
		accountVO3=new SitemanagerVO("S00000002","025-88888888","HRMS");
		accountVO4=new SitemanagerVO("S00000001","025-88888888","HRMSSitemanager");
		
		sManage=new SitemanagerManage();
	}

	@Test
	public void test1() {
		// 账号密码匹配
		assertEquals(ResultMessage.SUCCESS,sManage.checkAccount(accountVO4));
	}
	
	@Test
	public void test2() {
		// 账号错误
		assertEquals(ResultMessage.FAIL,sManage.checkAccount(accountVO1));
	}
	
	@Test
	public void test3() {
		// 密码错误
		assertEquals(ResultMessage.FAIL,sManage.checkAccount(accountVO2));
	}
	
	@Test
	public void test4() {
		// 账号、密码都出错
		assertEquals(ResultMessage.FAIL,sManage.checkAccount(accountVO3));
	}
	
	

}
