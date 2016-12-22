package bltest.clientbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.clientbl.ClientManage;
import datatool.ClientDataTool;
import vo.clientVO.ClientVO;

public class CreateClientTest {
	/*ClientManage Manage = new ClientManage();
	@Test
	public void test1(){
		//账号格式错误
		assertEquals(ResultMessage.FAIL,Manage.createClient(new ClientVO("H00000001","trick")));
	}

	@Test
	public void test2(){
		//账号已经存在
		assertEquals(ResultMessage.FAIL,Manage.createClient(ClientDataTool.clientVO1));
		}

	@Test
	public void test3(){
		//账号正确，密码为空
		assertEquals(ResultMessage.FAIL,Manage.createClient(new ClientVO("C00000001","")));
	}

	@Test
	//账号密码都错
	public void test4(){
		//账号格式正确且有密码
		assertEquals(ResultMessage.SUCCESS,Manage.createClient(new ClientVO("C00000009","hi~")));
	}*/
}
