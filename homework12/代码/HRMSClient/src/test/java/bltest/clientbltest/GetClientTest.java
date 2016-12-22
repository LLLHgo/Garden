package bltest.clientbltest;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.clientbl.ClientManage;
import datatool.ClientDataTool;

public class GetClientTest {
	/*ClientManage Manage = new ClientManage();
	@Test
	public void test1() {
		//传入账号为空

		assertEquals(null,Manage.getclient(""));

	}

	/*@Test
	public void test2() {
		//传入账号为null值
		assertEquals(null,Manage.getclient(null));

	}*/
	/*@Test
	public void test3() {
		//传入账号不属于客户
		assertEquals(null,Manage.getclient("H00000001"));
	}
	@Test
	public void test4() {
		//传入账号格式正确但不存在
		assertEquals(null,Manage.getclient("C00100001"));
	}
	@Test
	public void test5() {
		//传入账号格式正确且该用户存在，返回相应客户的VO
	assertEquals(ClientDataTool.clientVO1.getFirm(),Manage.getclient("C00000001").getFirm());
	assertEquals(ClientDataTool.clientVO1.getName(),Manage.getclient("C00000001").getName());
	assertEquals(ClientDataTool.clientVO1.getTel(),Manage.getclient("C00000001").getTel());
	assertEquals(ClientDataTool.clientVO1.getCredit(),Manage.getclient("C00000001").getCredit());
	}
	*/
}
