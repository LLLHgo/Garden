package ControllerTest;
import static org.junit.Assert.*;
import org.junit.Test;

import Enum.ResultMessage;
import Mock.MockClientManage;
import Mock.MockLoginManage;
import Mock.MockSitemanagerManage;
import datatool.SitemanagerDataTool;
import vo.clientVO.ClientVO;
import vo.sitemanager.SitemanagerVO;
public class ProcessLoginViewControllerTest {

	/**
	 *验证用户登陆账号
	 * @param user_id
	 * @param password
	 * @return 登陆成功与否
	 */
	@Test
		public void loginTest() {
		SitemanagerVO so=SitemanagerDataTool.sitemanagerVO;
		MockSitemanagerManage ms=new MockSitemanagerManage();
		assertEquals(true,ms.checkAccount(so));
		MockClientManage mc=new MockClientManage();
		ClientVO vo=mc.getclient("C00000001");
		assertEquals(true,mc.checkAccount(vo));
	}

	/**
	 * 注册新用户
	 */
	@Test
	public void addclientTest() {
		MockLoginManage ml=new MockLoginManage();
		MockClientManage mc=new MockClientManage();
		ClientVO vo=mc.getclient("C00000001");
		assertEquals(ResultMessage.SUCCESS,ml.addclient(vo));
		assertEquals(ResultMessage.FAIL,ml.addclient(null));
	}
}
